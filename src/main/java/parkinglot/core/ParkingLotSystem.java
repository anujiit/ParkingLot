package parkinglot.core;

import parkinglot.models.Car;

import java.util.*;

public class ParkingLotSystem implements ParkingLotSlotManagement, ParkingLotQueryManagement {
    private int maxSlotsAvailable;
    private int availableSlots;
    private PriorityQueue<Integer> pq;
    private TreeMap<Integer, Car> parkingSlotToCarMap;

    public ParkingLotSystem()
    {
        pq = new PriorityQueue<Integer>();
        parkingSlotToCarMap = new TreeMap<Integer, Car>();
        availableSlots = 0;
        maxSlotsAvailable = 0;
    }

    public ParkingLotSystem(int n)
    {
        pq = new PriorityQueue<Integer>();
        parkingSlotToCarMap = new TreeMap<Integer, Car>();
        availableSlots = n;
        maxSlotsAvailable = n;
        for(int i=1;i<=n;i++)
        {
            pq.add(i);
        }
    }

    public int allocateSlot(Car c)
    {
        if(availableSlots == 0)
            return -1;
        int slot = pq.poll();
        parkingSlotToCarMap.put(slot, c);
        availableSlots--;
        return slot;
    }

    public boolean deallocateSlot(int slot)
    {
        if(slot<1 || slot>maxSlotsAvailable){
            return false;
        }
        availableSlots++;
        pq.add(slot);
        parkingSlotToCarMap.remove(slot);
        return true;
    }

    public List<String> getRegNumsForCarColor(String color)
    {
        List<String> list = new ArrayList<String>();
        for(Map.Entry<Integer, Car> entry: parkingSlotToCarMap.entrySet())
        {
            if(entry.getValue().getColor().equals(color))
            {
                list.add(entry.getValue().getRegNum());
            }
        }

        return list;
    }

    public List<Integer> getSlotsForCarColor(String color)
    {
        List<Integer> list = new ArrayList<Integer>();
        for(Map.Entry<Integer, Car> entry: parkingSlotToCarMap.entrySet())
        {
            if(entry.getValue().getColor().equals(color))
            {
                list.add(entry.getKey());
            }
        }

        return list;
    }

    public int getSlotForRegNum(String regNum)
    {
        int slotNum = -1;
        for(Map.Entry<Integer, Car> entry: parkingSlotToCarMap.entrySet())
        {
            if(entry.getValue().getRegNum().equals(regNum))
            {
                slotNum = entry.getKey();
                break;
            }
        }

        return slotNum;
    }

    public Set<Map.Entry<Integer, Car>> getParkingLotStatus() {
        return parkingSlotToCarMap.entrySet();
    }
}
