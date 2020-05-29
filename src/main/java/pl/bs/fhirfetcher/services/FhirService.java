package pl.bs.fhirfetcher.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pl.bs.fhirfetcher.models.FhirResponse;
import pl.bs.fhirfetcher.models.Patient;

import java.util.ArrayList;
import java.util.List;

@Service
public class FhirService {

    private final FhirClient fhirClient;

    public FhirService(FhirClient fhirClient) {
        this.fhirClient = fhirClient;
    }

    public FhirResponse getPatients() {
        return fhirClient.getPatientsResponse();
    }

    public FhirResponse getById(String id) {
        return fhirClient.getPatientHistory(id);
    }
}
