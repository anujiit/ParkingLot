package parkinglot.core;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ParkingLotMainTest {
    @Test
    public void testExecuteCommand_CreateParkingLot(){
        assertEquals(ParkingLotMain.executeCommand("create_parking_lot 6"), true);
    }

    @Test
    public void testExecuteCommand_Park(){
        ParkingLotMain.executeCommand("create_parking_lot 6");
        assertEquals(ParkingLotMain.executeCommand("park KA-01-HH-1234 White"), true);
    }

    @Test
    public void testExecuteCommand_Leave(){
        ParkingLotMain.executeCommand("create_parking_lot 6");
        assertEquals(ParkingLotMain.executeCommand("leave 4"), true);
    }

    @Test
    public void testExecuteCommand_RegNumsForCarColor(){
        ParkingLotMain.executeCommand("create_parking_lot 6");
        assertEquals(ParkingLotMain.executeCommand("registration_numbers_for_cars_with_colour White"), true);
    }

    @Test
    public void testExecuteCommand_SlotsForCarColor(){
        ParkingLotMain.executeCommand("create_parking_lot 6");
        assertEquals(ParkingLotMain.executeCommand("slot_numbers_for_cars_with_colour White"), true);
    }

    @Test
    public void testExecuteCommand_SlotForRegNum(){
        ParkingLotMain.executeCommand("create_parking_lot 6");
        assertEquals(ParkingLotMain.executeCommand("slot_number_for_registration_number KA-01-HH-3141"), true);
    }

    @Test
    public void testExecuteCommand_UnknownCommand(){
        ParkingLotMain.executeCommand("create_parking_lot 6");
        assertEquals(ParkingLotMain.executeCommand("unknown KA-01-HH-3141"), false);
    }

    @Test
    public void testMain_InputFileNotFound(){
        String[] args = new String[1];
        args[0]="inputFile.txt";
        ParkingLotMain.main(args);
        //Handled Exception
    }
}
