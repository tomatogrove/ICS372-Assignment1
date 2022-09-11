package src;
import java.time.LocalDate;
import java.util.Date;

public class Vehicle {
    private int vehicleID;
    private String manufacturer;
    private LocalDate acquisitionDate;
    private double price;


    public Vehicle(int vehicleID, String manufacturer, LocalDate acquisitionDate, double price) {
        this.vehicleID = vehicleID;
        this.manufacturer = manufacturer;
        this.acquisitionDate = acquisitionDate;
        this.price = price;
    }

    @Override
    public String toString(){
        String factorySticker = "";
        factorySticker = "Vehicle ID: " + vehicleID + "\n" + "Manufacturer: " + manufacturer + "\n" + "Acquisition Date: " +  acquisitionDate + "\n" + "Price: $" + price; 
        return factorySticker;
    }
    
}


