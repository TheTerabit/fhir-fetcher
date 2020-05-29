package pl.bs.fhirfetcher.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import pl.bs.fhirfetcher.models.response.Entry;

import java.util.List;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FhirResponse {

    private final List<Entry> entries;

    public FhirResponse(@JsonProperty("entry") List<Entry> entries) {
        this.entries = entries;
    }
}
