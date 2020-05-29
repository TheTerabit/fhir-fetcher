package pl.bs.fhirfetcher.controllers;

import org.springframework.web.bind.annotation.*;
import pl.bs.fhirfetcher.models.FhirResponse;
import pl.bs.fhirfetcher.models.Patient;
import pl.bs.fhirfetcher.services.FhirService;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class FhirEndpoint {

    private final FhirService fhirService;

    public FhirEndpoint(FhirService fhirService) {
        this.fhirService = fhirService;
    }

    @GetMapping
    public List<Patient> getPatients() {
        return fhirService.getPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable("id") String id) {
        return fhirService.getById(id);
    }

}
