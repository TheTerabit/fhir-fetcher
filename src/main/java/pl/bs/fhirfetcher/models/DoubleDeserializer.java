package pl.bs.fhirfetcher.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import pl.bs.fhirfetcher.models.response.entry.resource.Name;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DoubleDeserializer extends JsonDeserializer<List<Name>> {

    @Override
    public List<Name> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
            System.out.println("deserializuję!!!");
        try {
            List<Name> nameValues = jsonParser.readValueAs(ArrayList.class);
            return nameValues;
        } catch (Exception ne) {
            System.out.println("Default value is set as the value in json is not compatible with double value");
            return null;
        }

    }
}
