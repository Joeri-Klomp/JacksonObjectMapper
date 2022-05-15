package be.joeri.jacksonobjectmapper.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void serializeJSON() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("yellow", "renault");
        String s = objectMapper.writeValueAsString(car);
        assertThat(s).isEqualTo("{\"color\":\"yellow\",\"type\":\"renault\"}");
    }

    @Test
    void deserializeJSON() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Car car = objectMapper.readValue(json, Car.class);
        assertThat(car.getColor()).isEqualTo("Black");
        //the readValue() function also accepts other forms of input (like file containing JSON String, or a URL)
    }
}