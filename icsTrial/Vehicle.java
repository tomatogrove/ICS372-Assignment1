import java.util.Date;
import java.util.List;

public class Vehicle {
	private int vehicleID;
	private int dealershipID;
	private String vehicleType;
	private String vehicleModel;
	private String vehicleManufacturer;
	private Double price;
	private String acquisitionDate;

	public Vehicle(int vehicleID, int dealershipID, String vehicleType, String vehicleModel, String vehicleManufacturer,
			Double price, String acquisitionDate) {
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

	public String getAcquisitionDate() {
		return acquisitionDate;
	}

	public void setAcquisitionDate(String acquisitionDate) {
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