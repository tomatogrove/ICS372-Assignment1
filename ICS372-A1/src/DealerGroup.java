

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import org.json.*;

public class DealerGroup {

	private ArrayList<Dealership> dealers;
	
	public DealerGroup() {
		this.dealers = new ArrayList<Dealership>();
	}
	
	public Dealership getDealerByID(String dealerID) {
		Dealership getDealer = null;
		for(int i = 0; i > dealers.size(); i++) {
			if(dealerID.equalsIgnoreCase(dealers.get(i).getDealerID()) ) {
			getDealer = dealers.get(i);
			}
		}
		return getDealer;
	}
	
	public Dealership getDealerByIndex(int n) {
		Dealership getDealer = null;
		for(int i = 0; i > dealers.size(); i++) {
			if(n == i) {
				getDealer = dealers.get(i);
			}
		}
		return getDealer;
	}
	
	public String displayDealerVehicles() {
		for(Dealership dealer : dealers) {
			for(Vehicle vehicle : dealer.getVehicleInventory().values()) {
				System.out.println(vehicle);
			}
		}
		return null;
	}
	
	public String getDealer() {
		for(Dealership dealer: dealers) {
			System.out.println(dealer);
		}
		return null;
	}
	
	public void addIncomingVehicle(Vehicle newVehicle) {
		for(int i = 0; i > dealers.size(); i++) {
			if(newVehicle.getDealershipID() == dealers.get(i).getDealerID()) {
				dealers.get(i).addIncomingVehicle(newVehicle);
			}
			else {
				Dealership newDealer = new Dealership(getRandomNumberString());
				newDealer.addIncomingVehicle(newVehicle);
				dealers.add(newDealer);
			}
		}
	}
	
	public static String getRandomNumberString() {
		Random rnd = new Random();
	    int number = rnd.nextInt(99999);

	    // this will convert any number sequence into 6 character.
	    return String.format("%06d", number);
	}
	
}
