package pl.bs.fhirfetcher.models;

import lombok.Data;
import pl.bs.fhirfetcher.models.response.entry.resource.DosageInstruction;
import pl.bs.fhirfetcher.models.response.entry.resource.MedicationCodeableConcept;

import java.time.ZonedDateTime;
import java.util.List;

@Data
public class MedicationRequest {

    private String name;
    private ZonedDateTime dateTime;
    private Boolean asNeededBoolean;
    private Integer doseQuantity;
    private Integer frequency;
    private Integer period;
    private String periodUnit;

    public MedicationRequest(MedicationCodeableConcept medicationCodeableConcept, String authoredOn, List<DosageInstruction> dosageInstructions) {
        this.name = medicationCodeableConcept.getText();
        this.dateTime = ZonedDateTime.parse(authoredOn);
        if (dosageInstructions != null ) {
            if (dosageInstructions.size() > 0) {
                this.asNeededBoolean = dosageInstructions.get(0).getAsNeededBoolean();
                if (dosageInstructions.get(0).getDoseQuantity() != null)
                    this.doseQuantity = dosageInstructions.get(0).getDoseQuantity().getValue();

                if (dosageInstructions.get(0).getTiming() != null) {
                    this.frequency = dosageInstructions.get(0).getTiming().getRepeat().getFrequency();
                    this.period = dosageInstructions.get(0).getTiming().getRepeat().getPeriod();
                    this.periodUnit = dosageInstructions.get(0).getTiming().getRepeat().getPeriodUnit();
                }
            }
        }
    }
}
