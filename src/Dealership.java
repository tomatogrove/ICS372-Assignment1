package src;
import java.util.ArrayList;

public class Dealership {
    private int dealerID;
    private boolean vehicleAcquisition;
    private ArrayList<Vehicle> vehicleInventory;

    public Dealership(int newDealer) {
        dealerID = newDealer;
        vehicleAcquisition = true;
        vehicleInventory = new ArrayList<Vehicle>();
    }

    public Dealership(int dealerID, boolean vehicleAcquisition, ArrayList<Vehicle> vehicleInventory) {
        this.dealerID = dealerID;
        this.vehicleAcquisition = vehicleAcquisition;
        this.vehicleInventory = vehicleInventory;
    }

    public void addIncomingVehicle(Vehicle car) {
        if(vehicleAcquisition == true){
        this.vehicleInventory.add(car);
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
        for (Vehicle automobile : vehicleInventory) {
            inventory += "\n" + automobile.toString();
        }
        return inventory;
    }
}
