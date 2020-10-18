package parkinglot.core;

import org.junit.Test;
import parkinglot.models.Car;
import java.util.List;
import static junit.framework.Assert.assertEquals;

public class ParkingLotSystemTest {
    ParkingLotSystem parkingLotSystem;

    @Test
    public void testAllocateSlot_SlotAvailable(){
        parkingLotSystem = new ParkingLotSystem(1);
        int slot = parkingLotSystem.allocateSlot(new Car("12323", "Red"));
        assertEquals(slot, 1);
    }

    @Test
    public void testAllocateSlot_SlotNotAvailable(){
        parkingLotSystem = new ParkingLotSystem(0);
        int slot = parkingLotSystem.allocateSlot(new Car("12323", "Red"));
        assertEquals(slot, -1);
    }

    @Test
    public void testDeallocateSlot_InvalidSlot(){
        parkingLotSystem = new ParkingLotSystem(1);
        assertEquals(false, parkingLotSystem.deallocateSlot(0));
    }

    @Test
    public void testDeallocateSlot_SlotValid(){
        parkingLotSystem = new ParkingLotSystem(1);
        assertEquals(true, parkingLotSystem.deallocateSlot(1));
    }

    @Test
    public void testGetRegNumsForCarColor_CheckRegNums(){
        parkingLotSystem = new ParkingLotSystem(2);
        parkingLotSystem.allocateSlot(new Car("1234", "Red"));
        parkingLotSystem.allocateSlot(new Car("1256", "Blue"));
        List<String> regNums = parkingLotSystem.getRegNumsForCarColor("Blue");
        assertEquals(regNums.get(0), "1256");
    }

    @Test
    public void testGetSlotForRegNum_CheckSlot(){
        parkingLotSystem = new ParkingLotSystem(2);
        parkingLotSystem.allocateSlot(new Car("1234", "Red"));
        parkingLotSystem.allocateSlot(new Car("1256", "Blue"));
        int slot = parkingLotSystem.getSlotForRegNum("1256");
        assertEquals(slot, 2);
    }

    @Test
    public void testGetSlotsForCarColor_CheckSlots(){
        parkingLotSystem = new ParkingLotSystem(2);
        parkingLotSystem.allocateSlot(new Car("1234", "Red"));
        parkingLotSystem.allocateSlot(new Car("1256", "Blue"));
        List<Integer> slots = parkingLotSystem.getSlotsForCarColor("Red");
        assertEquals((int)slots.get(0), 1);
    }
}
