package car.functionality;

import car.inventory.DealerGroup;
import car.inventory.Dealership;
import car.inventory.Vehicle;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.ParseException;
import java.io.IOException;

import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[]args) {
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

            keepRunning = checkCommand(command, dealerGroup);
            System.out.println("------------------------------------------------\n");
        }
    }

    private static boolean checkCommand(String command, DealerGroup dealerGroup) {
        String[] commandAndParameter = command.split(" ", 2);
        Dealership dealer;

        switch (commandAndParameter[0]) {
            case "addIncomingVehicles":
                Main.tryAddVehicles(commandAndParameter, dealerGroup);
                break;
            case "exportDealerVehicles":
                dealer = getDealer(dealerGroup, commandAndParameter);
                if (dealer != null) {
                    new VehicleJSONParser().write(dealer);
                    System.out.println("Dealer " + dealer.getDealerID() + " vehicle's exported successfully!");
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
    
    private static void tryAddVehicles(String[] commandAndParameter, DealerGroup dealerGroup) {
        if (commandAndParameter.length > 1) {
            try {
                VehicleJSONParser simpleParser = new VehicleJSONParser(commandAndParameter[1]);
                ObjectMapper mapper = new ObjectMapper();

                List<Vehicle> simpleVehicles = mapper.convertValue(simpleParser.buildMap().get("car_inventory"), new TypeReference<>() {
                });

                simpleVehicles.toString();
                dealerGroup.addIncomingVehicles(simpleVehicles);
            } catch (IOException | ParseException e) {
                System.out.println("Input file is invalid or inaccessible");
            }
        } else {
            System.out.println("Enter a file");
        }
    }

    private static Dealership getDealer(DealerGroup dealerGroup, String[] commandAndParameter) {
        if (commandAndParameter.length > 1) {
            Dealership dealer = dealerGroup.getDealerByID(commandAndParameter[1]);
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