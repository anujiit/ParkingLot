package parkinglot.models;

public class Car {
    private String regNum;
    private String color;

    public Car(String regNum, String color)
    {
        this.regNum = regNum;
        this.color = color;
    }

    public String getRegNum()
    {
        return regNum;
    }

    public String getColor()
    {
        return color;
    }
}
