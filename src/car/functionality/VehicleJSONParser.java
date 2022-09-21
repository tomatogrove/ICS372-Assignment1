package car.functionality;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Map;
import java.nio.file.Path;

import car.inventory.Dealership;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * The car.functionality.VehicleJSONParser class has one constructor
 * that takes in the file location of a JSON file as a String. 
 * The file is parsed into a JSONArray.
 * The class contains a method that creates a map from the JSONObject.
 */
public class VehicleJSONParser {
	
	private Path file;
	private String fileString;
	private Object obj;

	VehicleJSONParser() {}
	
	VehicleJSONParser(String filePath) throws IOException, ParseException{
		this.file = Path.of(filePath);
		this.fileString = Files.readString(file);
		this.obj = new JSONParser().parse(fileString);
	}

	/*
	 * The buildMap method builds a map from the fileString.
	 * The map that is returned can be used to 
	 * get vehicle and dealer information to build 
	 * vehicle and dealer classes.
	 */
	public Map<String, Object> buildMap() {
		Map<String, Object> map = null;
		try {
			@SuppressWarnings("unchecked")
			Map<String, Object> map1 = new ObjectMapper().readValue(fileString, Map.class);
			map = map1;
		} catch(Exception e) {
			System.out.println(e);
		}
		return map;
	}


	public void write(Dealership dealer) {
		ObjectMapper mapper = new ObjectMapper();
		String filePath = "./dealer" + dealer.getDealerID() + "Inventory.json";
		File file = new File(filePath);
		try {
			file.createNewFile();

			VehicleWrapper wrapper = new VehicleWrapper();
			wrapper.setCar_inventory(new ArrayList<>(dealer.getVehicleInventory().values()));

			mapper.writerWithDefaultPrettyPrinter().writeValue(file, wrapper);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}