package car.functionality;

import car.inventory.DealerGroup;
import car.inventory.Dealership;
import iabGUI.Vehicle;

import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[]args) {
        JacksonVehicleJSONParser json = new JacksonVehicleJSONParser();
        DealerGroup dealerGroup = new DealerGroup();
        boolean keepRunning = true;
        String command;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Car Inventory Program. \n"
                + "When entering functions with parameters, follow this format: function parameter");
        while (keepRunning) {
            System.out.println("""
                    Choose one of the following commands:
                    addIncomingVehicles filePath
                    exportDealerVehicles dealerShipID
                    displayDealerVehicles
                    enableDealerVehicleAcquisition dealerShipID
                    disableDealerVehicleAcquisition dealerShipID
                    quit""");

            command = scanner.nextLine();

            keepRunning = checkCommand(command, json, dealerGroup);
            System.out.println("------------------------------------------------");
        }
    }

    private static boolean checkCommand(String command, JacksonVehicleJSONParser json, DealerGroup dealerGroup) {
        String[] commandAndParameter = command.split(" ", 2);
        Dealership dealer;

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
                dealerGroup.displayDealerVehicles();
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

    private static Dealership getDealer(DealerGroup dealerGroup, String[] commandAndParameter) {
        if (commandAndParameter.length > 1) {
            Dealership dealer = dealerGroup.getDealer(Integer.parseInt(commandAndParameter[1]));
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