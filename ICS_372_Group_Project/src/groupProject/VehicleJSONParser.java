package groupProject;

import java.nio.file.Files;
import java.nio.file.Path;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class vehicleJSONParser {
	
	public static void main(String[] args) throws Exception {
		
		Path file = Path.of("C:\\Users\\eric_\\Downloads\\Project1_input.json");
		String fileString = Files.readString(file);
		System.out.println(fileString);
        
        Object obj = new JSONParser().parse(fileString);
          
        JSONObject jo = (JSONObject) obj;
          
        // create JSON array
        JSONArray jsonArray = new JSONArray();
        jsonArray = (JSONArray) jo.get("car_inventory");
        
        // get the first object of the JSON array
        jsonArray.get(0);
        System.out.println(jsonArray.get(0));
        JSONObject jo1 = (JSONObject) obj;
        jo1 = (JSONObject) jsonArray.get(0);
        
        // get the fields of the JSON array object
        String type = (String) jo1.get("vehicle_type");
        System.out.println("The type of vehicle is: " + type);
        //String dealership_id = (String) jo.get("car_inventory");
        String vehicle_type = (String) jo.get("vehicle_type");
//          
        //System.out.println(dealership_id);
        System.out.println(vehicle_type);

        
    }

}
