package RailroadCarts;

import Exceptions.TooMuchWeightException;
import Objects.People;

import java.util.ArrayList;
import java.util.List;

public class PassengerRailroadCart extends RailroadCart {
    private int maxWeight;
    private final int maxAmountOfSeats;
    private int amountOfPeople;
    List<People> passengerArrayList;
    private int totalWeight;
    private final String[] names;

    public PassengerRailroadCart(int id) {
        super(id);
        this.amountOfPeople = (int)Math.ceil(Math.random()*(195-100) + 100);
        this.maxWeight = 30000;
        this.passengerArrayList = new ArrayList<>();
        this.maxAmountOfSeats = 200;
        this.names = new String[]{"Max", "Alice", "Bob",
                "Charlie", "David", "Eve", "Frank",
                "Grace", "Hank", "Ivy", "Jack", "Kate",
                "Luke", "Mary", "Nathan", "Olivia", "Paul",
                "Quincy", "Rachel", "Sam", "Tom", "Uma",
                "Victor", "Wendy", "Xander", "Yara", "Zane"};
        name = "Passenger railroad cart";
    }
    private void getPassengersInfo(){
        System.out.println("Passenger info: ");
        for(int i = 0; i < passengerArrayList.size(); i++){
            System.out.println("Name -> " + passengerArrayList.get(i).getName() + " ,age -> " + passengerArrayList.get(i).getAge());
        }
    }

    @Override
    public boolean isConnectedToElectricalGrid() {
        return true;
    }

    @Override
    public int getWeight() {
        totalWeight = 0;
        for(int i = 0; i < amountOfPeople; i++){
            totalWeight += passengerArrayList.get(i).getWeight();
        }
        return totalWeight + weight;
    }

    @Override
    public void load() {
        try {
            for (int i = 0; i < amountOfPeople; i++) {
                int randomNumber = (int) (Math.random() * names.length);
                String randomName = names[randomNumber];
                int randomWeight = (int) Math.floor(Math.random() * (100 - 50) + 50);
                int randomAge = (int) Math.floor(Math.random() * (100 - 1) + 1);
                if (totalWeight > maxWeight) {
                    throw new TooMuchWeightException(this);
                }
                passengerArrayList.add(new People(i, randomWeight, randomAge, randomName));
            }
        }catch (TooMuchWeightException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getInfoAboutCargo() {
        return "Amount of people on board is " + amountOfPeople;
    }

    @Override
    public void getMethods(int userChoice) {
        if(userChoice == 1){
            getPassengersInfo();
        }else {
            System.out.println("No such option!\n");
        }
    }

    @Override
    public String toString() {
        return "PassengerRailroadCart has: " +
                "\n, total weight is " + getWeight() +
                "\n, connected to electrical grid " + connectedToElectricalGrid;
    }
}
