package pl.bs.fhirfetcher.models.response.entry.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import pl.bs.fhirfetcher.models.response.entry.resource.dosageInstruction.DoseQuantity;
import pl.bs.fhirfetcher.models.response.entry.resource.dosageInstruction.Timing;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DosageInstruction {

    private final Boolean asNeededBoolean;
    private final DoseQuantity doseQuantity;
    private final Timing timing;

    public DosageInstruction(@JsonProperty("asNeededBoolean") Boolean asNeededBoolean,
                             @JsonProperty("doseQuantity") DoseQuantity doseQuantity,
                             @JsonProperty("timing") Timing timing) {
        this.asNeededBoolean = asNeededBoolean;
        this.doseQuantity = doseQuantity;
        this.timing = timing;
    }
}
