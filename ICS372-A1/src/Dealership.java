

import java.util.Map;
import java.util.HashMap;

public class Dealership {
    private String dealerID;
    private boolean vehicleAcquisition;
    private Map<Integer, Vehicle> vehicleInventory;
    private int vehicleKey = 0;

    
    //getters
    public String getDealerID() {
        return dealerID;
    }

    public boolean isVehicleAcquisition() {
        return vehicleAcquisition;
    }

    public Map<Integer, Vehicle> getVehicleInventory() {
        return vehicleInventory;
    }

    public Dealership(String newDealer) {
        dealerID = newDealer;
        vehicleAcquisition = true;
        vehicleInventory = new HashMap<>();
    }
    //constructors
    public Dealership(String dealerID, boolean vehicleAcquisition, HashMap<Integer, Vehicle> vehicleInventory) {
        this.dealerID = dealerID;
        this.vehicleAcquisition = vehicleAcquisition;
        this.vehicleInventory = vehicleInventory;
    }
    //methods
    public void addIncomingVehicle(Vehicle car) {
        if(vehicleAcquisition == true){
        this.vehicleInventory.put(vehicleKey, car);
        vehicleKey++;
        } else {
            System.out.println("This dealer is not allowed to add additional vehicles to their inventory");
        }
    }

    public void enableDealerVehicleAcquisition(Dealership dealer) {
        dealer.vehicleAcquisition = true;
    }

    public void disableDealerVehicleAcquisition(Dealership dealer) {
        dealer.vehicleAcquisition = false;
    }

    @Override
    public String toString() {
        String inventory = "";
        for( Map.Entry<Integer, Vehicle> car : this.vehicleInventory.entrySet()) {
            inventory += car.getKey() + "\n_______________\nVehicle ID: " + car.getValue().getVehicleID() + "\nDealership ID: " + car.getValue().getDealershipID() + "\nVehicle Type: " + car.getValue().getVehicleType() + "\nVehicle Model: " + car.getValue().getVehicleModel() + "\nVehicle Manufacturer: " + car.getValue().getVehicleManufacturer() + "\nPrice: $" + car.getValue().getPrice() + "\nAcquisition Date: " + car.getValue().getAcquisitionDate() + "\n";
        }
        return inventory;
    }
}