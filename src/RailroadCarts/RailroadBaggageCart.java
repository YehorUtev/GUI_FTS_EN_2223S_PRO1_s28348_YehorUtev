package RailroadCarts;

import Exceptions.TooMuchWeightException;
import Objects.Baggage;

import java.util.ArrayList;
import java.util.List;

public class RailroadBaggageCart extends RailroadCart{
    private final int maxBaggageWeight;
    private final int maxVolume;
    private final int maxWeight;
    private int amountOfBaggage;
    private int baggageWeight;
    private List<Baggage> baggageList;
    private int totalWeight;

    public RailroadBaggageCart(int id) {
        super(id);
        this.maxVolume = 10000;
        this.maxBaggageWeight = 150;
        this.maxWeight = 30000;
        this.baggageList = new ArrayList<>();
        this.amountOfBaggage = (int)(Math.random()*100);
        this.connectedToElectricalGrid = isConnectedToElectricalGrid();
        name = "Baggage railroad cart";
    }
    public void unloadBaggage(){
        baggageList.clear();
        getWeight();
        System.out.println("Baggage amount is -> " + baggageList.size());
    }
    public void loadExtraBaggage(){
        try{
            int extraAmountOfBaggage = (int)(Math.random()*50);
            for(int i = 0; i < extraAmountOfBaggage; i++){
                int randomWeight = (int)Math.ceil(Math.random()*maxBaggageWeight);
                this.baggageWeight += randomWeight;
                int randomVolume = (int)Math.ceil(Math.random()*maxVolume);
                baggageList.add(new Baggage(i, randomWeight, randomVolume));
            }
            if(totalWeight > maxWeight){
                throw new TooMuchWeightException(this);
            }
        }catch (TooMuchWeightException e){
            System.out.println(e.getMessage());
        }
        getWeight();
    }

    @Override
    public boolean isConnectedToElectricalGrid() {
        return false;
    }

    @Override
    public int getWeight() {
        totalWeight = 0;
        for(int i = 0; i < amountOfBaggage; i++){
            totalWeight += baggageList.get(i).getWeight();
        }
        return totalWeight + weight;
    }

    public void load(){
        try{
            for(int i = 0; i < amountOfBaggage; i++){
                int randomWeight = (int)Math.ceil(Math.random()*maxBaggageWeight);
                this.baggageWeight += randomWeight;
                int randomVolume = (int)Math.ceil(Math.random()*maxVolume);
                baggageList.add(new Baggage(i, randomWeight, randomVolume));
            }
            if(totalWeight > maxWeight){
                throw new TooMuchWeightException(this);
            }
        }catch (TooMuchWeightException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getInfoAboutCargo() {
        return "Amount of baggage is " + amountOfBaggage +
                "\n, baggage weight is " + baggageWeight;
    }

    @Override
    public void getMethods(int userChoice) {
        if(userChoice == 1){
            unloadBaggage();
        } else if (userChoice == 2) {
            loadExtraBaggage();
        }else {
            System.out.println("No such option!");
        }
    }

    @Override
    public String toString() {
        return "RailroadBaggageCart has: " +
                "\n, total weight is " + getWeight() +
                "\n, connected to electrical grid " + connectedToElectricalGrid;
    }
}
