package RailroadCarts;

import Enums.TypeOfToxicMat;
import Exceptions.TooMuchWeightException;

public class ToxicMatRailroadCart extends HeavyRailroadCart {
    private int weightOfCargo;
    private int volumeOfCargo;
    private TypeOfToxicMat typeOfToxicMaterial;
    private int levelOfDanger;
    private int totalWeight;

    public ToxicMatRailroadCart(int id) {
        super(id);
        name = "Railroad cart for toxic materials";
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
            int random = (int) Math.ceil(Math.random() * 1);
            switch (random) {
                case (1):
                    typeOfToxicMaterial = TypeOfToxicMat.RADIOACTIVE;
                    levelOfDanger = 5;
                    break;
                case (2):
                    typeOfToxicMaterial = TypeOfToxicMat.CHEMICAL;
                    levelOfDanger = 3;
                    break;
            }
            this.totalWeight = getWeight();
            this.weightOfCargo = (int)(Math.random()*45000);
            this.volumeOfCargo = (int)(Math.random()*40000);
            if(totalWeight > maxWeight){
                throw new TooMuchWeightException(this);
            }
        }catch (TooMuchWeightException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getInfoAboutCargo() {
        return " Weight of transported cargo is " + weightOfCargo +
                "\n, volume of transported cargo is " + volumeOfCargo +
                "\n, type of toxic material is " + typeOfToxicMaterial +
                "\n, level of danger is " + levelOfDanger;
    }

    @Override
    public void getMethods(int userChoice) {
        if(userChoice == 1) {
            neutralizeToxicWaste();
            System.out.println("Level of danger now is -> " + levelOfDanger);
        }else {
            System.out.println("No such action!");
        }
    }

    public int neutralizeToxicWaste() {
        if (levelOfDanger > 5) {
            System.out.println("Impossible to neutralize, too high toxicity!");
        } else {
            levelOfDanger--;
        }
        return levelOfDanger;
    }

    @Override
    public String toString() {
        return "ToxicMatRailroadCart has: " +
                "\n, total weight is " + totalWeight +
                "\n, connected to electrical grid " + connectedToElectricalGrid;
    }
}
