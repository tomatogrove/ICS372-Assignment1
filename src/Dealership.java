package src;
import java.util.Map;
import java.util.HashMap;

public class Dealership {
    private int dealerID;
    private boolean vehicleAcquisition;
    private Map<Integer, Vehicle> vehicleInventory;

    
    //getters
    public int getDealerID() {
        return dealerID;
    }

    public boolean isVehicleAcquisition() {
        return vehicleAcquisition;
    }

    public Map<Integer, Vehicle> getVehicleInventory() {
        return vehicleInventory;
    }

    public Dealership(int newDealer) {
        dealerID = newDealer;
        vehicleAcquisition = true;
        vehicleInventory = new HashMap<>();
    }
    //constructors
    public Dealership(int dealerID, boolean vehicleAcquisition, HashMap<Integer, Vehicle> vehicleInventory) {
        this.dealerID = dealerID;
        this.vehicleAcquisition = vehicleAcquisition;
        this.vehicleInventory = vehicleInventory;
    }
    //methods
    public void addIncomingVehicle(int stockNumber, Vehicle car) {
        if(car.getVehicleType().equalsIgnoreCase("SUV") || car.getVehicleType().equalsIgnoreCase("Sedan") || car.getVehicleType().equalsIgnoreCase("Pickup") || car.getVehicleType().equalsIgnoreCase("Sports Car")) {
            if(vehicleAcquisition == true && this.vehicleInventory.containsKey(stockNumber) == false){
                this.vehicleInventory.put(stockNumber, car);
            } else if(vehicleAcquisition == false){
                System.out.println("This dealer is not allowed to add additional vehicles to their inventory\n");
            } else if(this.vehicleInventory.containsKey(stockNumber) == true) {
                System.out.println("This vehicle is already in this dealer's inventory\n");
            }
        } else {
            System.out.println("Not a valid vehicle type.\n");
        }
    }

    public void enableDealerVehicleAcquisition() {
        this.vehicleAcquisition = true;
    }

    public void disableDealerVehicleAcquisition() {
        this.vehicleAcquisition = false;
    }

    public String inventory() {
        String inventory = "";
        for( Map.Entry<Integer, Vehicle> car : this.vehicleInventory.entrySet()) {
            inventory += car.getValue().toString();
        }
        return inventory;
    }
}
