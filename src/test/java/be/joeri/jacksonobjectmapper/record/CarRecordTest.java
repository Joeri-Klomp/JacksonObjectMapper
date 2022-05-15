package be.joeri.jacksonobjectmapper.record;

import be.joeri.jacksonobjectmapper.dto.Car;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class CarRecordTest {
    @Test
    void serializeJSON() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        CarRecord car = new CarRecord("yellow", "renault");
        String s = objectMapper.writeValueAsString(car);
        assertThat(s).isEqualTo("{\"color\":\"yellow\",\"type\":\"renault\"}");
    }

    @Test
    void deserializeJSON() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        CarRecord car = objectMapper.readValue(json, CarRecord.class);
        assertThat(car.color()).isEqualTo("Black");
        //the readValue() function also accepts other forms of input (like file containing JSON String, or a URL)
    }

}