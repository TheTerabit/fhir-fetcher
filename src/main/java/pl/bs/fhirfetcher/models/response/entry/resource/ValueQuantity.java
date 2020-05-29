package pl.bs.fhirfetcher.models.response.entry.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValueQuantity {

    private final Double value;
    private final String unit;

    public ValueQuantity(@JsonProperty("value") Double value,
                         @JsonProperty("unit") String unit) {
        this.value = value;
        this.unit = unit;
    }
}
