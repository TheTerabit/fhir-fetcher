package pl.bs.fhirfetcher.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pl.bs.fhirfetcher.models.FhirResponse;
import pl.bs.fhirfetcher.models.MedicationRequest;
import pl.bs.fhirfetcher.models.Observation;
import pl.bs.fhirfetcher.models.Patient;
import pl.bs.fhirfetcher.models.response.Entry;
import pl.bs.fhirfetcher.models.response.entry.Resource;

import java.util.ArrayList;
import java.util.List;

@Service
public class FhirService {

    private final FhirClient fhirClient;

    public FhirService(FhirClient fhirClient) {
        this.fhirClient = fhirClient;
    }

    public List<Patient> getPatients() {

        return fetchPatients(fhirClient.getPatientsResponse());
    }

    public Patient getById(String id) {
        return fetchPatients(fhirClient.getPatientHistory(id)).get(0);
    }

    private List<Patient> fetchPatients(List<FhirResponse> fhirResponses) {

        List<Object> objects = new ArrayList<>();

        fhirResponses.stream().forEach(fhirResponse -> {
            fhirResponse.getEntries().stream().forEach(entry -> objects.add(recognizeObject(entry)));});

        List<Patient> patients = new ArrayList<>();
        objects.stream().filter(o -> o instanceof Patient).forEach(patient -> patients.add((Patient) patient));
        List<Observation> observations = new ArrayList<>();
        objects.stream().filter(o -> o instanceof Observation).forEach(observation -> observations.add((Observation) observation));
        List<MedicationRequest> medicationRequests = new ArrayList<>();
        objects.stream().filter(o -> o instanceof MedicationRequest).forEach(medicationRequest -> medicationRequests.add((MedicationRequest) medicationRequest));
        patients.get(0).setMedicationRequests(medicationRequests);
        patients.get(0).setObservations(observations);
        return patients;
    }

    private Object recognizeObject(Entry entry) {
        Resource resource = entry.getResource();
        if (resource.getResourceType().equals("Patient"))
            return createPatient(resource);
        else if (resource.getResourceType().equals("MedicationRequest"))
            return createMedicationRequest(resource);
        else if (resource.getResourceType().equals("Observation"))
            return createObservation(resource);

        return new Object();
    }

    private Patient createPatient(Resource resource) {
        Patient patient = new Patient(resource.getId(),
                                    resource.getNames(),
                                    resource.getBirthDate(),
                                    resource.getGender());
        return patient;
    }

    private MedicationRequest createMedicationRequest(Resource resource) {
        System.out.println("New med");
        MedicationRequest medicationRequest = new MedicationRequest(resource.getMedicationCodeableConcept(),
                                                                resource.getAuthoredOn(),
                                                                resource.getDosageInstructions());
        return medicationRequest;
    }

    private Observation createObservation(Resource resource) {
        Observation observation = new Observation(resource.getCode(),
                                                resource.getEffectiveDateTime(),
                                                resource.getValueQuantity());
        return observation;
    }


}
