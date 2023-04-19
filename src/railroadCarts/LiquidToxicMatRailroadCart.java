package railroadCarts;

import enums.ToxicLiquid;
import exceptions.TooMuchWeightException;

public class LiquidToxicMatRailroadCart extends BasicRailroadCart{
    private int volumeOfToxicMaterials;
    private int weightOfCargo;
    private final int volumeOfTank;
    private int percentage;
    private ToxicLiquid toxicLiquid;
    private int temperature;
    private int totalWeight;
    public LiquidToxicMatRailroadCart(int id) {
        super(id);
        this.volumeOfTank = 20000;
        this.toxicLiquid = generateToxicLiquid();
        name = "Railroad cart for toxic liquid materials";
    }
    public int decreaseTemperature(){
        temperature = temperature - 5;
        return temperature;
    }
    public int increaseTemperature(){
        temperature = temperature + 5;
        return temperature;
    }

    public ToxicLiquid generateToxicLiquid(){
        int randomNumber = (int)Math.ceil(Math.random()*2);
        switch (randomNumber){
            case (1):
                toxicLiquid = ToxicLiquid.ACID;
                break;
            case(2):
                toxicLiquid = ToxicLiquid.ALKALIS;
                break;
        }
        return toxicLiquid;
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
        try{
            final int minTemperatureOfLiquid = 10;
            final int maxTemperatureOfLiquid = 30;
            this.temperature = (int)(Math.random()*(maxTemperatureOfLiquid - minTemperatureOfLiquid)+minTemperatureOfLiquid);
            this.percentage = (int)(Math.random()*100);
            this.volumeOfToxicMaterials = (int) (volumeOfTank*(percentage/100.));
            this.weightOfCargo = volumeOfToxicMaterials;
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
        return " VolumeOfToxicMaterials is" + volumeOfToxicMaterials +
                "\n, weight of cargo is " + weightOfCargo +
                "\n, percentage of tank used " + percentage +
                "\n, toxic liquid type is " + toxicLiquid +
                "\n, temperature of liquid is " + temperature;
    }

    @Override
    public void getMethods(int userChoice) {
        if(userChoice == 1){
            decreaseTemperature();
        } else if (userChoice == 2) {
            increaseTemperature();
        }else {
            System.out.println("No such option!");
        }
    }

    @Override
    public String toString() {
        return " LiquidToxicMatRailroadCart has: " +
                "\n, total weight is " + totalWeight +
                "\n, volume of tank is " + volumeOfTank +
                "\n, connected to electrical grid " + connectedToElectricalGrid;
    }
}
