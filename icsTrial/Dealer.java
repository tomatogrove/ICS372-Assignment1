
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Dealer {
	private int dealerID;
	private boolean vehicleAcquisition;
	
	public Dealer() {
		this.dealerID = 0;
		this.vehicleAcquisition = true;
	}
	public Dealer(int dealerid) {
		this.dealerID = dealerid;
		this.vehicleAcquisition = true;
	}
	public Dealer(int dealerID, boolean vehicleAcquisition) {
		this.dealerID = dealerID;
		this.vehicleAcquisition = true;
	}

	public boolean isVehicleAcquisition() {
		return vehicleAcquisition;
	}

	public void setVehicleAcquisition(boolean vehicleAcquisition) {
		this.vehicleAcquisition = vehicleAcquisition;
	}

	public int getDealerID() {
		return dealerID;
	}

	public void setDealerID(int dealerID) {
		this.dealerID = dealerID;
	}

	public void addIncomingVehicle(Vehicle vehicleToAdd) {
		if (vehicleAcquisition) {
			JSONParser parser = new JSONParser();
			JSONObject vehicleList = null;
			try {
				vehicleList = (JSONObject) parser.parse(new FileReader("src/Project1_input.json"));
			} catch (ParseException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			JSONArray arrayVehicle = (JSONArray) vehicleList.get("car_inventory");

			JSONObject newVehicle = new JSONObject();
			newVehicle.put("dealership_id", vehicleToAdd.getDealershipID());
			newVehicle.put("vehicle_type", vehicleToAdd.getVehicleType());
			newVehicle.put("vehicle_manufacturer", vehicleToAdd.getVehicleManufacturer());
			newVehicle.put("vehicle_model", vehicleToAdd.getVehicleModel());
			newVehicle.put("vehicle_id", vehicleToAdd.getVehicleID());
			newVehicle.put("price", vehicleToAdd.getPrice());
			newVehicle.put("acquisition_date", String.valueOf(vehicleToAdd.getAcquisitionDate()));
			arrayVehicle.add(newVehicle);
			try (FileWriter file = new FileWriter("src/Project1_input.json")) {
				file.write(vehicleList.toJSONString());
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		} else {
			System.out.println("Vehicle acquisition disabled.");
		}
	}
	public String getVehicleList() {
		String summary = "Vehicle List\n";
		String heading = String.format("%5s %20s %20s %20s %25s %20s %20s \n", "Dealership ID","Vehicle ID", 
				"Vehicle Type", "Vehicle Model", "Vehicle Manufacturer", "Price", "Acquisition Date");


		String info = "";
		if(dealerID != 0) {
			try {
				Path file = Path.of("src/Project1_input.json");
				
				String fileString = Files.readString(file);
				
		        
		        Object obj;
				obj = new JSONParser().parse(fileString);
				  JSONObject firstValue = (JSONObject) obj;
		          
			        // create JSON array
			        JSONArray jsonArray = new JSONArray();
			        jsonArray = (JSONArray) firstValue.get("car_inventory");
			        for(int i =0;i< jsonArray.size();i++) {
						 JSONObject arrayValue = (JSONObject) obj;
						   arrayValue = (JSONObject) jsonArray.get(i);
						   String idValue = String.valueOf(dealerID).trim();
						 
						   if(arrayValue.get("dealership_id").equals(idValue) ){
	                           info += String.format("%-30s %-22s %-24s %-20s %-40s %-14s %-14s",
	                                          arrayValue.get("dealership_id"),
	                                          arrayValue.get("vehicle_id"), 
	                                          arrayValue.get("vehicle_type"),
	                                          arrayValue.get("vehicle_model"),
	                                          arrayValue.get("vehicle_manufacturer"),
	                                          arrayValue.get("price"),
	                                          arrayValue.get("acquisition_date" )); 	
						
						}
						     }
				
			} catch (ParseException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
		

		try {
			Path file = Path.of("src/Project1_input.json");
			
			String fileString = Files.readString(file);
			
	        
	        Object obj;
			obj = new JSONParser().parse(fileString);
			  JSONObject jo = (JSONObject) obj;
	          
		        // create JSON array
		        JSONArray jsonArray = new JSONArray();
		        jsonArray = (JSONArray) jo.get("car_inventory");
		        
		     
			for(int i =0;i< jsonArray.size();i++) {
				 JSONObject jo2 = (JSONObject) obj;
				   jo2 = (JSONObject) jsonArray.get(i);
				     
				info += String.format("%-30s %-22s %-24s %-20s %-40s %-14s %-14s\n", jo2.get("dealership_id"),jo2.get("vehicle_id"), 
						jo2.get("vehicle_type"),
						jo2.get("vehicle_model"),jo2.get("vehicle_manufacturer"), jo2.get("price"),jo2.get("acquisition_date" )); 	
				
				}
			
		} catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return summary + heading + info;
	}
}
