package pl.bs.fhirfetcher.models;

import lombok.Data;
import pl.bs.fhirfetcher.models.response.entry.resource.Name;

import java.util.ArrayList;
import java.util.List;

@Data
public class Patient {

    private String id;
    private String name;
    private String gender;
    private String birthDate;
    private List<Observation> observations;
    private List<MedicationRequest> medicationRequests;

    public Patient(String id, List<Name> names, String birthDate, String gender) {
        this.id = id;
        this.birthDate = birthDate;
        this.gender = gender;
        this.name = createName(names);
        this.observations = new ArrayList<>();
        this.medicationRequests = new ArrayList<>();
    }

    private String createName(List<Name> names) {
        StringBuilder name = new StringBuilder();

        if(names.size()==0)
            return "[UNDEFINED PATIENT]";

        if(names.get(0).getPrefix() != null)
            name.append(names.get(0).getPrefix().get(0)).append(" ");

        name.append(names.get(0).getFamily().replaceAll("[0-9]",""))
                .append(" ")
                .append(names.get(0).getGiven().get(0).replaceAll("[0-9]",""));

        return name.toString();
    }

}
