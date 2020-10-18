package parkinglot.utils;

public enum Commands {
    CREATE_PARKINGLOT,
    PARK,
    LEAVE,
    STATUS,
    REGNUMS_COLOR,
    SLOTNUMS_COLOR,
    SLOTNUM_REGNUM,
    UNKNOWN,
    EXIT;

    public static Commands getCommand(String command)
    {
        if(command.equals(Constants.CREATE_PARKINGLOT))
        {
            return CREATE_PARKINGLOT;
        }
        else if(command.equals(Constants.LEAVE))
        {
            return LEAVE;
        }
        else if(command.equals(Constants.PARK))
        {
            return PARK;
        }
        else if(command.equals(Constants.REGNUMS_COLOR))
        {
            return REGNUMS_COLOR;
        }
        else if(command.equals(Constants.SLOTNUM_REGNUM))
        {
            return SLOTNUM_REGNUM;
        }
        else if(command.equals(Constants.SLOTNUMS_COLOR))
        {
            return SLOTNUMS_COLOR;
        }
        else if(command.equals(Constants.STATUS))
        {
            return STATUS;
        }
        else if(command.equals(Constants.EXIT))
        {
            return EXIT;
        }
        else
        {
            return UNKNOWN;
        }
    }
}
