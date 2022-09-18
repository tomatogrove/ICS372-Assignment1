package car.functionality;

import car.inventory.Dealership;
import iabGUI.Vehicle;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VehicleJSONParser {
    private ObjectMapper mapper;

    public VehicleJSONParser() {
        mapper = new ObjectMapper();
    }

    public List<Vehicle> read(String filePath) {
        Path path = Paths.get(filePath);
        String json = "";
        List<Vehicle> vehicles = new ArrayList<>();
        try {
            json = Files.readString(path);
            vehicles = mapper.readValue(json, VehicleWrapper.class).getCar_inventory();

        } catch (IOException e) {
            System.out.println("File path not accessible or does not exist.");
        }

        return vehicles;
    }


    public void write(Dealership dealer) {
        String filePath = "./dealer" + dealer.getDealerID() + "Inventory.json";
        File file = new File(filePath);
        try {
            file.createNewFile();

            VehicleWrapper wrapper = new VehicleWrapper();
            wrapper.setCar_inventory(new ArrayList<>(dealer.getVehicleInventory().values()));

            mapper.writeValue(file, wrapper);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}