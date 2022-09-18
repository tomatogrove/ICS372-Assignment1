package car.inventory;

import java.util.List;
import java.util.Map.Entry;

import iabGUI.Vehicle;
import org.json.*;

public class DealerGroup {

	private Dealership[] dealers;

	public JSONObject exportDealerVehicles() {
		JSONObject file = new JSONObject();

		for (Dealership dealer : dealers) {
			for (Entry<Integer, Vehicle> vehicle : dealer.getVehicleInventory().entrySet()) {
				try {
					file.put("dealership_id", vehicle.getValue().getDealershipID());
					file.put("vehicle_type", vehicle.getValue().getVehicleType());
					file.put("vehicle_manufacturer", vehicle.getValue().getVehicleManufacturer());
					file.put("vehicle_model", vehicle.getValue().getVehicleModel());
					file.put("vehicle_id", vehicle.getValue().getVehicleID());
					file.put("price", vehicle.getValue().getPrice());
					file.put("acquisition_date", vehicle.getValue().getAcquisitionDate());
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		return file;
	}

	public String displayDealerVehicles() {
		for (Dealership dealer : dealers) {
			for (Vehicle vehicle : dealer.getVehicleInventory().values()) {
				System.out.println(vehicle);
			}
		}
		return null;
	}

	public Dealership getDealer() {
		Dealership getDealer = new Dealership("");
		for (Dealership dealer : dealers) {
			getDealer = dealer;
		}
		return getDealer;
	}


	//methods that need to be implemented
	public Dealership getDealer(String dealerID) {
		return null;
	}

	public void addIncomingVehicles(List<Vehicle> vehicles) {

	}

}
