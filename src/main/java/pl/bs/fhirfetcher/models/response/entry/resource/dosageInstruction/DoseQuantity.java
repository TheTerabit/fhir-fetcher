package pl.bs.fhirfetcher.models.response.entry.resource.dosageInstruction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DoseQuantity {

    private final Integer value;

    public DoseQuantity(@JsonProperty("value") Integer value) {
        this.value = value;
    }
}
