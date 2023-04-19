package RailroadCarts;

import Enums.Explosive;
import Exceptions.TooMuchWeightException;

public class ExplosivesRailroadCart extends HeavyRailroadCart {
    private int weightOfCargo;
    private int volumeOfCargo;
    private int temperature;
    private Explosive explosive;
    private int randomNumber;
    private int totalWeight;

    public ExplosivesRailroadCart(int id) {
        super(id);
        name = "Railroad Cart fo explosives";
    }
    public int decreaseTemperature(){
        return temperature - 5;
    }
    public void checkTemperature() {
            switch (randomNumber) {
                case (1):
                    if (temperature < 25) {
                        System.out.println("Temperature is okay");
                    } else {
                        System.out.println("Decrease temperature!");
                    }
                    break;
                case (2):
                    if (temperature < 30) {
                        System.out.println("Temperature is okay");
                    } else {
                        System.out.println("Decrease temperature!");
                    }
                case (3):
                    if (temperature < 25) {
                        System.out.println("Temperature is okay");
                    } else {
                        System.out.println("Decrease temperature!");
                    }
            }

    }
    public int getWeight() {
        return weightOfCargo + weight;
    }

    @Override
    public void load() {
        try {
            this.weightOfCargo = (int) Math.ceil(Math.random() * 30000);
            this.volumeOfCargo = (int) Math.ceil(Math.random() * 40000);
            this.temperature = (int) Math.ceil(Math.random() * 31);
            this.randomNumber = (int) Math.ceil(Math.random() * 3);
            switch (randomNumber) {
                case (1):
                    explosive = Explosive.C4;
                    break;
                case (2):
                    explosive = Explosive.TNT;
                    break;
                case (3):
                    explosive = Explosive.PROXIMITYMINE;
                    break;
            }
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
        return "Weight of cargo is " + weightOfCargo +
                "\n, volume of cargo inside is " + volumeOfCargo +
                "\n, temperature is " + temperature +
                "\n, explosive type is " + explosive;
    }

    @Override
    public void getMethods(int userChoice) {
        if(userChoice == 1){
            checkTemperature();
        } else if (userChoice == 2) {
            decreaseTemperature();
        }else{
            System.out.println("No such option!");
        }
    }

    @Override
    public boolean isConnectedToElectricalGrid() {
        return false;
    }

    @Override
    public String toString() {
        return "ExplosivesRailroadCart has: " +
                "\n, total weight is " + totalWeight +

                "\n, connected to electrical grid " + connectedToElectricalGrid;
    }
}
