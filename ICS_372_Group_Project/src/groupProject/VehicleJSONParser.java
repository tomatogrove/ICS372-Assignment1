package groupProject;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.nio.file.Path;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/*
 * The VehicleJSONParser class has one constructor 
 * that takes in the file location of a JSON file as a String. 
 * The file is parsed into a JSONArray.
 * The class contains a method that creates a map from the JSONObject.
 * Additionally, the JSONObject / JSONArray can be queried directly 
 * to get it's contents.
 */
public class VehicleJSONParser {
	
	private Path file;
	private String fileString;
	private Object obj;
	private JSONObject jo;
	private JSONArray jsonArray = new JSONArray();
	
	VehicleJSONParser(String filePath) throws IOException, ParseException{
		this.file = Path.of(filePath);
		this.fileString = Files.readString(file);
		this.obj = new JSONParser().parse(fileString);
		this.jo = (JSONObject) obj;
		this.jsonArray = (JSONArray) jo.get("car_inventory");
	}

	public JSONArray getJSONArray() {
		return jsonArray;
	}

	/*
	 * The buildMap method builds a map from the 
	 * JSONObject in the JSONParser class. 
	 * The map that is returned can be used to 
	 * get vehicle and dealer information to build 
	 * vehicle and dealer classes.
	 */
	public Map<String, Object> buildMap() {
		JSONObject jo2 = (JSONObject) obj;
		Map<String, Object> map = null;
		try {
			@SuppressWarnings("unchecked")
			Map<String, Object> map1 = new ObjectMapper().readValue(jo2.toJSONString(), Map.class);
			map = map1;
		} catch(Exception e) {
			System.out.println(e);
		}
		return map;
	}
	
    /*
     * Alternative to using the map to build 
     * vehicle and dealer objects, the JSON array can 
     * be queried directly with it's inherent methods (two examples) 
     * shown below.
     * 
     * The JSONArray can contain multiple vehicles (JSONObjects).
     * Therefore, the JSONObjects are referenced via index.
     * The example below gets vehicle information from the 
     * first vehicle in the array and returns 
     * the "vehicle_type" and "vehicle_model" 
     * fields of the JSON array object as one string.
     */
	public String getVehicleTypeAndModel() {
		jsonArray.get(0);
	    JSONObject jo1 = (JSONObject) obj;
	    jo1 = (JSONObject) jsonArray.get(0);
	    String type = (String) jo1.get("vehicle_type");
	    String model = (String) jo1.get("vehicle_model");
	    
	    return type + ", " + model;
	}

}