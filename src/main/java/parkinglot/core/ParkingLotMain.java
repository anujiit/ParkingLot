package parkinglot.core;

import parkinglot.utils.Commands;
import parkinglot.models.Car;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ParkingLotMain {
    private static Scanner sc;
    private static ParkingLotSystem parkingLot;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        try {
            if (args.length > 0) {
                String fileName = args[0];
                File f = new File(fileName);
                sc = new Scanner(f);
            }

            parkingLot = new ParkingLotSystem();

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                executeCommand(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
            e.printStackTrace();
        }
    }

    public static boolean executeCommand(String line){
        String[] commandLine = line.split(" ");
        String command = commandLine[0];
        boolean commandExecuted = true;
        switch (Commands.getCommand(command)) {
            case CREATE_PARKINGLOT:
                int numSlots = Integer.parseInt(line.split(" ")[1]);
                parkingLot = new ParkingLotSystem(numSlots);
                System.out.println("Created a parking lot with " + numSlots + " slots");
                break;
            case LEAVE:
                int num = Integer.parseInt(commandLine[1]);
                boolean status = parkingLot.deallocateSlot(num);
                if(status) {
                    System.out.println("Slot number " + num + " is free");
                }
                else {
                    System.out.println("Invalid Slot number");
                }
                break;
            case PARK:
                String regNum = commandLine[1];
                String colour = commandLine[2];
                int parkingSlot = parkingLot.allocateSlot(new Car(regNum, colour));
                if (parkingSlot != -1) {
                    System.out.println("Allocated slot number: " + parkingSlot);
                } else {
                    System.out.println("Sorry, parking lot is full");
                }
                break;
            case REGNUMS_COLOR:
                colour = commandLine[1];
                List<String> list = parkingLot.getRegNumsForCarColor(colour);
                if(list.isEmpty()){
                    System.out.println("Not Found");
                }
                else {
                    System.out.println(list.toString().replace("[", "").replace("]", ""));
                }
                break;
            case SLOTNUM_REGNUM:
                colour = commandLine[1];
                int slot = parkingLot.getSlotForRegNum(colour);
                if (slot == -1) {
                    System.out.println("Not found");
                } else {
                    System.out.println(slot);
                }
                break;
            case SLOTNUMS_COLOR:
                regNum = commandLine[1];
                List<Integer> listSlots = parkingLot.getSlotsForCarColor(regNum);
                if(listSlots.isEmpty()){
                    System.out.println("Not Found");
                } else {
                    System.out.println(listSlots.toString().replace("[", "").replace("]", ""));
                }
                break;
            case STATUS:
                Set<Map.Entry<Integer, Car>> parkingLotStatus = parkingLot.getParkingLotStatus();
                System.out.println("Slot No.    Registration No    Colour");
                for (Map.Entry<Integer, Car> entry : parkingLotStatus) {
                    System.out.println(entry.getKey() + "           " + entry.getValue().getRegNum() + "      " + entry.getValue().getColor());
                }
                break;
            case EXIT:
                System.exit(0);
            default:
                commandExecuted = false;
                break;
        }
        return commandExecuted;
    }
}
