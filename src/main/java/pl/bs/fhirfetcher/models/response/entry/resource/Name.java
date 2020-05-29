package pl.bs.fhirfetcher.models.response.entry.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Name {
    private final String use;
    private final String family;
    private final List<String> given;
    private final List<String> prefix;

    public Name(@JsonProperty("use") String use,
                @JsonProperty("family") String family,
                @JsonProperty("given") List<String> given,
                @JsonProperty("prefix") List<String> prefix) {
        this.use = use;
        this.family = family;
        this.given = given;
        this.prefix = prefix;
    }
}