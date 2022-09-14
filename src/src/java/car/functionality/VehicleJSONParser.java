package java.car.functionality;

import java.car.inventory.Dealer;
import java.car.inventory.Vehicle;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
            Path path = Paths.get(filePath);
            Files.writeString(path, "carInventory{\n");

            for (Map.Entry<Integer, Vehicle> vehicle : dealer.getVehicles().entrySet()) {
                mapper.writeValue(file, vehicle);
            }

            Files.writeString(path, "}");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}