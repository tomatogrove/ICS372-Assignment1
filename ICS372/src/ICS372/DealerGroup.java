package ICS372;

import java.util.Map.Entry;

import org.json.JSONException;
import org.json.JSONObject;

public class DealerGroup {

	private Dealership[] dealers;

	private DealerGroup(Dealership[] dealers) {
		this.dealers = dealers;
	}

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
		Dealership getDealer = new Dealership(0);
		for (Dealership dealer : dealers) {
			getDealer = dealer;
		}
		return getDealer;
	}
}
