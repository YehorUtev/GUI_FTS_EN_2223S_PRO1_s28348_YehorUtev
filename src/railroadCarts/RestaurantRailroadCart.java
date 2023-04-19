package railroadCarts;

import exceptions.TooMuchWeightException;
import objects.People;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRailroadCart extends RailroadCart {
    private int maxWeigth;
    private int numberOfGuests;
    private final int maxAmountOfSeats;
    private List<People> guests;
    private int totalWeight;
    private final String[] names;

    public RestaurantRailroadCart(int id) {
        super(id);
        this.maxWeigth = 30000;
        this.numberOfGuests = (int) Math.floor(Math.random() * 50);
        this.maxAmountOfSeats = 50;
        this.guests = new ArrayList<>();
        this.names = new String[]{"Max", "Alice", "Bob",
                "Charlie", "David", "Eve", "Frank",
                "Grace", "Hank", "Ivy", "Jack", "Kate",
                "Luke", "Mary", "Nathan", "Olivia", "Paul",
                "Quincy", "Rachel", "Sam", "Tom", "Uma",
                "Victor", "Wendy", "Xander", "Yara", "Zane"};
        name = "Restaurant railroad cart";
    }

    @Override
    public boolean isConnectedToElectricalGrid() {
        return true;
    }

    @Override
    public int getWeight() {
        int cargoWeight = 0;
        for (int i = 0; i < numberOfGuests; i++) {
            cargoWeight += guests.get(i).getWeight();
        }
        return cargoWeight + weight;
    }

    @Override
    public void load() {
        try {
            for (int i = 0; i < numberOfGuests; i++) {
                int randomNumber = (int)(Math.random() * names.length);
                String randomName = names[randomNumber];
                int randomWeight = (int) Math.floor(Math.random() * (100 - 50) + 50);
                int randomAge = (int) Math.floor(Math.random() * (100 - 1) + 1);
                guests.add(new People(i, randomWeight, randomAge, randomName));
            }
            this.totalWeight = getWeight();
            if (totalWeight > maxWeigth) {
                throw new TooMuchWeightException(this);
            }
        } catch (TooMuchWeightException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getGuestsInfo() {
        System.out.println("Guests precise info: ");
        for (int i = 0; i < guests.size(); i++) {
            System.out.println("Name -> " + guests.get(i).getName() + " ,age -> " + guests.get(i).getAge() + "\n");
        }
    }

    public int getAmountOfFreeSeats() {
        return maxAmountOfSeats - guests.size();
    }

    @Override
    public String getInfoAboutCargo() {
        return "Number of guests is " + numberOfGuests;
    }

    @Override
    public void getMethods(int userChoice) {
        if (userChoice == 1) {
            System.out.println("Seats available -> " + getAmountOfFreeSeats());
        } else if (userChoice == 2) {
            getGuestsInfo();
        } else {
            System.out.println("No such action!");
        }
    }

    @Override
    public String toString() {
        return "RestaurantRailroadCart has: " +
                "\n, total weight is " + totalWeight +
                "\n, connected to electrical grid " + connectedToElectricalGrid;
    }
}
