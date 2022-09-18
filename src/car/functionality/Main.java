package car.functionality;

import car.inventory.Dealer;
import car.inventory.DealerGroup;
import car.inventory.Vehicle;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[]args) {
        VehicleJSONParser json = new VehicleJSONParser();
        DealerGroup dealerGroup = new DealerGroup();
        boolean keepRunning = true;
        String command;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Car Inventory Program. \n"
                + "When entering functions with parameters, follow this format: function parameter");
        while (keepRunning) {
            System.out.println("Choose one of the following commands:"
            + "\naddIncomingVehicles filePath"
            + "\nexportDealerVehicles dealerShipID"
            + "\ndisplayDealerVehicles"
            + "\nenableDealerVehicleAcquisition dealerShipID"
            + "\ndisableDealerVehicleAcquisition dealerShipID"
            + "\nquit");

            command = scanner.nextLine();

            keepRunning = checkCommand(command, json, dealerGroup);
            System.out.println("------------------------------------------------");
        }
    }

    private static boolean checkCommand(String command, VehicleJSONParser json, DealerGroup dealerGroup) {
        String[] commandAndParameter = command.split(" ", 2);
        Dealer dealer;

        switch (commandAndParameter[0]) {
            case "addIncomingVehicles":
                List<Vehicle> vehicles = json.read(commandAndParameter[1]);
                dealerGroup.addIncomingVehicles(vehicles);
                break;
            case "exportDealerVehicles":
                dealer = getDealer(dealerGroup, commandAndParameter);
                if(dealer != null) {
                    json.write(dealer);
                }
                break;
            case "displayDealerVehicles":
                dealerGroup.displayDealersVehicles();
                break;
            case "enableDealerVehicleAcquisition":
                dealer = getDealer(dealerGroup, commandAndParameter);
                if(dealer != null) {
                    dealer.enableDealerVehicleAcquisition();
                }
                break;
            case "disableDealerVehicleAcquisition":
                dealer = getDealer(dealerGroup, commandAndParameter);
                if (dealer != null) {
                    dealer.disableDealerVehicleAcquisition();
                }
                break;
            case "quit":
                return false;
            default:
                System.out.println("Command invalid. Check Spelling.");
                break;
        }
        return true;
    }

    private static Dealer getDealer(DealerGroup dealerGroup, String[] commandAndParameter) {
        if (commandAndParameter.length > 1) {
            Dealer dealer = dealerGroup.getDealer(commandAndParameter[1]);
            if (dealer != null) {
                return dealer;
            } else {
                System.out.println("Dealer " + commandAndParameter[1] + " does not exist. Please choose an existing dealer");
            }
        } else {
            System.out.println("Enter a dealerShipID");
        }
        return null;
    }
}