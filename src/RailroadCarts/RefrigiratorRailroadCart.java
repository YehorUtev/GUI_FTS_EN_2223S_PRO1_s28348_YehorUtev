package RailroadCarts;

import Exceptions.TooMuchWeightException;
import Objects.Food;

import java.util.ArrayList;
import java.util.List;

public class RefrigiratorRailroadCart extends BasicRailroadCart{
    private List<Food> foods;
    private int foodToGenerate;
    private int totalWeight;
    private int temperature;
    public RefrigiratorRailroadCart(int id) {
        super(id);
        this.foods = new ArrayList<>();
        this.temperature = -10;
        this.foodToGenerate = 10;
        this.connectedToElectricalGrid = true;
        name = "Refrigerator railroad cart";
    }
    public int decreaseTemperature(){
        temperature = temperature - 5;
        System.out.println("Temperature is -> " + temperature);
        return temperature;
    }
    public int increaseTemperature(){
        temperature = temperature + 5;
        System.out.println("Temperature is -> " + temperature);
        return temperature;
    }
    @Override
    public boolean isConnectedToElectricalGrid() {
        return true;
    }

    @Override
    public int getWeight() {
        totalWeight = 0;
        for(int i = 0; i < foods.size(); i++){
            totalWeight += foods.get(i).getWeight();
        }
        return totalWeight + weight;
    }

    @Override
    public void load() {
        try{
            for (int i = 0; i < foodToGenerate; i++){
                foods.add(new Food(i));
            }
            if (totalWeight > maxWeight){
                throw new TooMuchWeightException(this);
            }
        }catch (TooMuchWeightException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String getInfoAboutCargo() {
        return "Amount of food stacks is " + foods.size() +
                "\n, temperature inside is " + temperature;
    }

    @Override
    public void getMethods(int userChoice) {
        if(userChoice == 1){
            increaseTemperature();
        }else if(userChoice == 2){
            decreaseTemperature();
        }else {
            System.out.println("No such action!");
        }
    }

    @Override
    public String toString() {
        return "RefrigeratorRailroadCart has: " +
                "\n, total weight is " + getWeight() +
                "\n, connected to electrical grid " + connectedToElectricalGrid;
    }
}
