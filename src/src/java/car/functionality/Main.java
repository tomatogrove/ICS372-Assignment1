package java.car.functionality;

import java.car.inventory.Dealer;
import java.car.inventory.DealerGroup;
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
        }
    }

    private static boolean checkCommand(String command, VehicleJSONParser json, DealerGroup dealerGroup) {
        String[] commandAndParameter = command.split(" ");

        if (commandAndParameter[0].equals("addIncomingVehicles")) {
            json.read(commandAndParameter[2]);
        } else if (commandAndParameter[0].equals("exportDealerVehicles")) {
            Dealer dealer = dealerGroup.getDealer(Integer.parseInt(commandAndParameter[1]));
            if (dealer != null) {
                json.write(dealer);
            } else {
                System.out.println("Dealer " + dealer.getDealershipID() + " does not exist. Please choose an existing dealer");
            }
        } else if (commandAndParameter[0].equals("displayDealerVehicles")) {
            dealerGroup.displayDealersVehicles();
        } else if (commandAndParameter[0].equals("enableDealerVehicleAcquisition")) {
            dealerGroup.getDealer(Integer.parseInt(commandAndParameter[1])).enableDealerVehicleAcquisition();
        } else if (commandAndParameter[0].equals("disableDealerVehicleAcquisition")) {
            dealerGroup.getDealer(Integer.parseInt(commandAndParameter[1])).disableDealerVehicleAcquisition();
        } else if (commandAndParameter[0].equals("quit")) {
            return false;
        }  else {
            System.out.println("Command invalid. Check Spelling.");
        }
        return true;
    }
}