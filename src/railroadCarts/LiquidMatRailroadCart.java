package railroadCarts;

import enums.Liquid;
import exceptions.TooMuchWeightException;

public class LiquidMatRailroadCart extends BasicRailroadCart{
    private int volumeOfLiquid;
    private final int volumeOfTank;
    private int percentage;
    private int weightOfCargo;
    private Liquid liquid;
    private int totalWeight;
    private int temperature;

    public LiquidMatRailroadCart(int id) {
        super(id);
        this.temperature = (int)(Math.random()*30);
        this.volumeOfTank = 20000;
        this.liquid = generateTypeOfLiquid();
        name = "Railroad cart for liquid materials";
    }
    public void decreaseTemperature(){
        temperature = temperature - 5;
        System.out.println("Temperature right now is -> " + temperature);
    }
    public void checkTemperature(){
        if(liquid == Liquid.DIESEL){
            if(temperature < 15){
                System.out.println("Everything alright!");
            }else{
                System.out.println("Please decrease temperature!");
            }
        } else if (liquid == Liquid.GASOLINE) {
            if(temperature < 20){
                System.out.println("Everything alright!");
            }else{
                System.out.println("Please decrease temperature!");
            }
        } else if (liquid == Liquid.OIL) {
            if(temperature < 10){
                System.out.println("Everything alright!");
            }else{
                System.out.println("Please decrease temperature!");
            }
        } else if (liquid == Liquid.WATER) {
            System.out.println("Everything alright!");
        }

    }
    public Liquid generateTypeOfLiquid(){
        int randomNumber = (int)Math.ceil(Math.random()*4);
        switch (randomNumber){
            case (1):
                liquid = Liquid.OIL;
                break;
            case(2):
                liquid = Liquid.WATER;
                break;
            case (3):
                liquid = Liquid.GASOLINE;
                break;
            case (4):
                liquid = Liquid.DIESEL;
                break;
        }
        return liquid;
    }

    @Override
    public boolean isConnectedToElectricalGrid() {
        return false;
    }

    @Override
    public int getWeight() {
        return weightOfCargo + weight;
    }

    @Override
    public void load() {
        try {
            percentage = (int) (Math.random() * 100);
            volumeOfLiquid = (int) (volumeOfTank * (percentage / 100.));
            weightOfCargo = volumeOfLiquid;
            this.totalWeight = getWeight();
            if(totalWeight > maxWeight){
                throw new TooMuchWeightException(this);
            }
        }catch (TooMuchWeightException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getInfoAboutCargo() {
        return "Volume of liquid transporting is " + volumeOfLiquid +
                "\n, percentage of tank used is " + percentage +
                "\n, weight of cargo being transported is " + weightOfCargo +
                "\n, liquid type is " + liquid;
    }

    @Override
    public void getMethods(int userChoice) {
        if(userChoice == 1){
            checkTemperature();
        } else if (userChoice == 2) {
            decreaseTemperature();
        }else {
            System.out.println("No such option!");
        }
    }

    @Override
    public String toString() {
        return "LiquidMatRailroadCart has: " +
                "\n, total weight is " + totalWeight +
                "\n, volume of tank for liquid is " + volumeOfTank +
                "\n, connected to electrical grid " + connectedToElectricalGrid;
    }
}
