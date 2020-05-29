package pl.bs.fhirfetcher.models;

import lombok.Data;
import pl.bs.fhirfetcher.models.response.entry.resource.Code;
import pl.bs.fhirfetcher.models.response.entry.resource.ValueQuantity;

import java.time.ZonedDateTime;

@Data
public class Observation {

    private String name;
    private ZonedDateTime dateTime;
    private Double value;
    private String unit;

    public Observation(Code code, String effectiveDateTime, ValueQuantity valueQuantity) {
        this.name = code.getText();
        this.dateTime =  ZonedDateTime.parse(effectiveDateTime);
        this.value = valueQuantity.getValue();
        this.unit = valueQuantity.getUnit();
    }
}
