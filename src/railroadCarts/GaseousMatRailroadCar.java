package railroadCarts;

import exceptions.TooMuchWeightException;

public class GaseousMatRailroadCar extends BasicRailroadCart {
    private int weightOfGas;
    private int volumeOfGas;
    private int percentage;
    private int totalWeight;
    private int pressure;

    public GaseousMatRailroadCar(int id) {
        super(id);
        this.pressure = (int)(Math.random()*(40 - 6) + 6);
        name = "Railroad cart for gas";
    }
    public void checkPressure(){
        System.out.println("Pressure inside tank is -> " + this.pressure);
    }
    @Override
    public boolean isConnectedToElectricalGrid() {
        return false;
    }

    @Override
    public int getWeight() {
        return weightOfGas + weight;
    }

    @Override
    public void load() {
        try {
            percentage = (int) (Math.random() * 100);
            volumeOfGas = (int) (maxVolume * (percentage / 100.));
            this.weightOfGas = 400 * (volumeOfGas / 1000);
            this.totalWeight = getWeight();
            if (totalWeight > maxWeight) {
                throw new TooMuchWeightException(this);
            }
        } catch (TooMuchWeightException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getInfoAboutCargo() {
        return "Weight of gas inside: " + weightOfGas +
                "\n, volume of gas inside is: " + volumeOfGas +
                "\n, percentage of gas tank used is " + percentage;
    }

    @Override
    public void getMethods(int userChoice) {
        if(userChoice == 1){
            checkPressure();
        }else{
            System.out.println("No such option!");
        }
    }

    @Override
    public String toString() {
        return "GaseousMatRailroadCar has: " +
                "\n, total weight is " + totalWeight +
                "\n,volume of tank is " + maxVolume +
                "\n, connected to electrical grid " + connectedToElectricalGrid;
    }
}
