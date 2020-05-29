package pl.bs.fhirfetcher.models.response.entry.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Code {

    private final String text;

    public Code(@JsonProperty("text") String text) {
        this.text = text;
    }

}
