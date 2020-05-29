package pl.bs.fhirfetcher.models.response.entry.resource.dosageInstruction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repeat {
    private final Integer frequency;
    private final Integer period;
    private final String periodUnit;

    public Repeat(@JsonProperty("frequency") Integer frequency,
                  @JsonProperty("period") Integer period,
                  @JsonProperty("periodUnit") String periodUnit) {
        this.frequency = frequency;
        this.period = period;
        this.periodUnit = periodUnit;
    }
}
