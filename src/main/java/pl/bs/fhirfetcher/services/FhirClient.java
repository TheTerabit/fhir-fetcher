package pl.bs.fhirfetcher.services;

import org.springframework.stereotype.Service;
import pl.bs.fhirfetcher.models.FhirResponse;

import javax.ws.rs.client.WebTarget;

import java.util.ArrayList;
import java.util.List;

import static javax.ws.rs.client.ClientBuilder.newClient;

@Service
public class FhirClient {

    private WebTarget targetAllPatients;
    private List<FhirResponse> fhirResponses;

    public List<FhirResponse> getPatientsResponse() {
        fhirResponses = new ArrayList<>();
        getNextPage("http://localhost:8080/baseDstu3/Patient?&_count=100&_pretty=true&_format=json");
        return fhirResponses;
    }

    private void getNextPage(String url) {
        System.out.println(url);
        targetAllPatients = newClient().target(url);
        FhirResponse fhirResponse = targetAllPatients.request().get(FhirResponse.class);
        fhirResponses.add(fhirResponse);
        fhirResponse.getLinks().stream().filter(l -> l.getRelation().equals("next")).forEach(l -> getNextPage(l.getUrl()));
    }

    public List<FhirResponse> getPatientHistory(String id) {
        fhirResponses = new ArrayList<>();
        getNextPage("http://localhost:8080/baseDstu3/Patient/" + id + "/$everything?_count=100&_format=json");
        return fhirResponses;
    }
}
