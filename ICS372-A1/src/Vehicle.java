

import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;

public class Vehicle {
	private int vehicleID;
	private int dealershipID;
	private String vehicleType;
	private String vehicleModel;
	private String vehicleManufacturer;
	private Double price;
	private Date acquisitionDate;

	
	public Vehicle(JSONObject vehicleJson) {
		this.vehicleID = (int) vehicleJson.get("vehicleID");
		this.dealershipID = (int) vehicleJson.get("dealershipID");;
		this.vehicleType = (String) vehicleJson.get("vehicleType");;
		this.vehicleModel = (String) vehicleJson.get("vehicleModel");;
		this.vehicleManufacturer = (String) vehicleJson.get("vehicleManufacturer");;
		this.price = (Double) vehicleJson.get("price");;
		this.acquisitionDate = (Date) vehicleJson.get("acquisitionDate");;
	}
	
	public Vehicle(int vehicleID, int dealershipID, String vehicleType, String vehicleModel, String vehicleManufacturer,
			Double price, Date acquisitionDate) {
		this.vehicleID = vehicleID;
		this.dealershipID = dealershipID;
		this.vehicleType = vehicleType;
		this.vehicleModel = vehicleModel;
		this.vehicleManufacturer = vehicleManufacturer;
		this.price = price;
		this.acquisitionDate = acquisitionDate;
	}

	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	public int getDealershipID() {
		return dealershipID;
	}

	public void setDealershipID(int dealershipID) {
		this.dealershipID = dealershipID;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleManufacturer() {
		return vehicleManufacturer;
	}

	public void setVehicleManufacturer(String vehicleManufacturer) {
		this.vehicleManufacturer = vehicleManufacturer;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getAcquisitionDate() {
		return acquisitionDate;
	}

	public void setAcquisitionDate(Date acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}

	@Override
	public String toString() {

		String summary = "Vehicle Information\n" + "---------------------------------------------------\n";
		String heading = String.format("%-16s%-11s%-5s%-12s%-12s%-12s%-12s\n", "Vehicle ID", "Dealership ID",
				"Vehicle Type", "Vehicle Model", "Vehicle Manufacturer", "Price", "Acquisition Date");

		String secondLine = "-----------------------------------------------------------------------------------------\n";

		String info = String.format("%-16s%-11s%-5s%-12s%-12s%-12s%-12s\n", vehicleID, dealershipID, vehicleType,
				vehicleModel, vehicleManufacturer, price, acquisitionDate);

		return summary + heading + secondLine + info;
	}

}