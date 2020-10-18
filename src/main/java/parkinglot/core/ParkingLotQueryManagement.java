package parkinglot.core;

import parkinglot.models.Car;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ParkingLotQueryManagement {
    /**
     *
     * Get registration numbers of all cars of a particular colour
     * @param color of the car to be searched
     * @return list of registration numbers
     */
    List<String> getRegNumsForCarColor(String color);

    /**
     *
     * Get slot number in which a car with a given registration number is parked.
     * @param regNum of the car
     * @return slot number where car is parked
     */
    int getSlotForRegNum(String regNum);

    /**
     *
     * Get slot numbers of all slots where a car of a particular colour is parked.
     * @param color of the car to be searched
     * @return list of slots
     */
    List<Integer> getSlotsForCarColor(String color);

    /**
     *
     * Get parking lot status
     * @return Current status of parking lot in terms of set.
     */
    Set<Map.Entry<Integer, Car>> getParkingLotStatus();
}
