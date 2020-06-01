package pl.bs.fhirfetcher.models;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import pl.bs.fhirfetcher.models.response.entry.resource.Name;

import java.io.DataInput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Patient {

    private String id;
    private String name;
    private String gender;
    private String birthDate;
    private List<Observation> observations;
    private List<MedicationRequest> medicationRequests;

    public Patient(String id, JsonNode names, String birthDate, String gender) {
        this.id = id;
        this.birthDate = birthDate;
        this.gender = gender;
        this.name = createName(names);
        this.observations = new ArrayList<>();
        this.medicationRequests = new ArrayList<>();
    }

    private String createName(JsonNode names) {
        System.out.println(names.toString());
        ObjectMapper objectMapper = new ObjectMapper();

        List<Name> nameList = new ArrayList<>();
        try {
            nameList = Arrays.asList(objectMapper.readValue(names.toString(), Name[].class));
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        StringBuilder name = new StringBuilder();

        if(nameList.size()==0)
            return "[UNDEFINED PATIENT]";
        if(nameList.get(0).getPrefix() != null)
            name.append(nameList.get(0).getPrefix().get(0)).append(" ");

        name.append(nameList.get(0).getFamily().replaceAll("[0-9]",""))
                .append(" ")
                .append(nameList.get(0).getGiven().get(0).replaceAll("[0-9]",""));

        return name.toString();
    }

}
