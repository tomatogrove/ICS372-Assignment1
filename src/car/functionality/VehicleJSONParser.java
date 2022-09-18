package car.functionality;

import car.inventory.Dealer;
import car.inventory.Vehicle;
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

    public void write(Dealer dealer) {
        String filePath = "./dealer" + dealer.getDealershipID() + "Inventory.json";
        File file = new File(filePath);
        try {
            file.createNewFile();

            VehicleWrapper wrapper = new VehicleWrapper();
            wrapper.setCar_inventory(new ArrayList<>(dealer.getVehicles().values()));

            mapper.writeValue(file, wrapper);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}