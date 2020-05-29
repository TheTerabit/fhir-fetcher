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
    public FhirResponse getPatients() {
        return fhirService.getPatients();
    }


    @GetMapping("/{id}")
    public FhirResponse getPatientById(@PathVariable("id") String id) {
        return fhirService.getById(id);
    }

    /*
    @PostMapping
    public void create(@RequestBody FhirMsg fhirMsg) {
        fhirService.create(fhirMsg);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody FhirMsg fhirMsg) {
        fhirService.update(id, fhirMsg);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        fhirService.delete(id);
    }

    */
}
