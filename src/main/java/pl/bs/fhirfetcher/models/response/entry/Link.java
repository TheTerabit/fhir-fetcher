package pl.bs.fhirfetcher.models.response.entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Link {

    private final String relation;
    private final String url;

    public Link(@JsonProperty("relation") String relation,
                @JsonProperty("url") String url) {
        this.relation = relation;
        this.url = url;
    }
}
