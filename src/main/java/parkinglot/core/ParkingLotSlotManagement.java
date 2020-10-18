package parkinglot.core;

import parkinglot.models.Car;

public interface ParkingLotSlotManagement {
    /**
     *
     * @param car instance
     * @return Allocated slot number
     */
    int allocateSlot(Car car);

    /**
     *
     * @param slot number
     * @return status whether slot is deallocated
     */
    boolean deallocateSlot(int slot);
}
