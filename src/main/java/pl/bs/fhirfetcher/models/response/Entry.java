package pl.bs.fhirfetcher.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import pl.bs.fhirfetcher.models.response.entry.Resource;

import java.util.List;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Entry {

    private final Resource resource;

    public Entry(@JsonProperty("resource") Resource resource) {
        this.resource = resource;
    }

}
