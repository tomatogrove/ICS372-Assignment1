package car.inventory;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum VehicleTypeEnum {
    @JsonProperty("suv")
    SUV("suv"),
    @JsonProperty("sedan")
    SEDAN("sedan"),
    @JsonProperty("pickup")
    PICKUP("pickup"),
    @JsonProperty("sports car")
    SPORTS_CAR("sports car");

    private String vehicle;

    private VehicleTypeEnum(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }
}
