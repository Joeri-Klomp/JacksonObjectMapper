package be.joeri.jacksonobjectmapper.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private String color;
    private String type;

    @JsonCreator
    public Car(@JsonProperty("color") String color,@JsonProperty("type") String type) {
        this.color = color;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }
}
