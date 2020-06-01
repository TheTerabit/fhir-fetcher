package pl.bs.fhirfetcher.models.response.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;
import pl.bs.fhirfetcher.models.DoubleDeserializer;
import pl.bs.fhirfetcher.models.Patient;
import pl.bs.fhirfetcher.models.response.entry.resource.*;

import java.time.ZonedDateTime;
import java.util.List;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Resource {

    private final String resourceType;
    private final String id;
    private final String gender;
    private final String birthDate;
    //@JsonDeserialize(using = DoubleDeserializer.class)
    private final JsonNode names;
    //Observation
    private final Code code;
    private final String effectiveDateTime;
    private final ValueQuantity valueQuantity;
    //MedicationRequest
    private final String authoredOn;
    private final MedicationCodeableConcept medicationCodeableConcept;
    private final List<DosageInstruction> dosageInstructions;


    public Resource(@JsonProperty("resourceType") String resourceType,
                    @JsonProperty("id") String id,
                    @JsonProperty("gender") String gender,
                    @JsonProperty("birthDate") String birthDate,
                    @JsonProperty("name") JsonNode names,
                    @JsonProperty("code") Code code,
                    @JsonProperty("effectiveDateTime") String effectiveDateTime,
                    @JsonProperty("valueQuantity") ValueQuantity valueQuantity,
                    @JsonProperty("authoredOn") String authoredOn,
                    @JsonProperty("medicationCodealbeConcept") MedicationCodeableConcept medicationCodeableConcept,
                    @JsonProperty("dosageInstruction") List<DosageInstruction> dosageInstructions) {
        this.resourceType = resourceType;
        this.id = id;
        this.gender = gender;
        this.birthDate = birthDate;
        this.names = names;
        this.code = code;
        this.effectiveDateTime = effectiveDateTime;
        this.valueQuantity = valueQuantity;
        this.authoredOn = authoredOn;
        this.medicationCodeableConcept = medicationCodeableConcept;
        this.dosageInstructions = dosageInstructions;
    }
}
