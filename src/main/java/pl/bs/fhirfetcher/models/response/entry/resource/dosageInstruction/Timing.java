package pl.bs.fhirfetcher.models.response.entry.resource.dosageInstruction;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Timing {

    private final Repeat repeat;

    public Timing(@JsonProperty("repeat") Repeat repeat) {
        this.repeat = repeat;
    }
}
