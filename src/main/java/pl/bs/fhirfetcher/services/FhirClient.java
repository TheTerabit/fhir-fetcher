package pl.bs.fhirfetcher.services;

import org.springframework.stereotype.Service;
import pl.bs.fhirfetcher.models.FhirResponse;

import javax.ws.rs.client.WebTarget;

import static javax.ws.rs.client.ClientBuilder.newClient;

@Service
public class FhirClient {

    public FhirResponse getPatientsResponse(){
        WebTarget targetAllPatients = newClient().target("http://localhost:8080/baseDstu3/Patient?_pretty=true&_format=json");
        return targetAllPatients.request()
                .get(FhirResponse.class);
    }

    public FhirResponse getPatientHistory(String id) {
        WebTarget targetPatientHistory = newClient().target("http://localhost:8080/baseDstu3/Patient/" + id + "/$everything?_format=json");
        return targetPatientHistory.request()
                .get(FhirResponse.class);
    }
}
