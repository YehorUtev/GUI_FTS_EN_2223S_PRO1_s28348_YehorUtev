package RailroadCarts;

import Enums.States;
import Exceptions.TooMuchWeightException;
import Objects.MailStuck;

import java.util.ArrayList;
import java.util.List;

public class RailroadMailCart extends RailroadCart{
    private final int maxWeight;
    private List<MailStuck> mailCargo;
    private States state;
    private int totalWeight;
    public RailroadMailCart(int id){
        super(id);
        this.state = generateState();
        this.maxWeight = 30000;
        this.mailCargo = new ArrayList<>();
        name = "Mail cart";
    }
    public void unloadMail(){
        mailCargo.clear();
        getWeight();
        System.out.println("Mail stuck amount is -> " + mailCargo.size());
    }
    public void loadBack(){
        try{
            int generatablePayload1 = (int)(Math.random()*5);
            for(int i = 0; i < generatablePayload1; i++){
                mailCargo.add(new MailStuck(i));
            }
            this.totalWeight = getWeight();
            if(totalWeight > maxWeight){
                throw new TooMuchWeightException(this);
            }
        }catch (TooMuchWeightException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Mail stuck amount is -> " + mailCargo.size());
    }
    public States generateState(){
        int randomNumber = (int)Math.ceil(Math.random()*5);
        switch (randomNumber){
            case (1):
                state = States.NEWYORK;
                break;
            case (2):
                state = States.NEWORLEAN;
                break;
            case (3):
                state = States.WASHINGTON;
                break;
            case (4):
                state = States.NORTHCAROLINA;
                break;
            case(5):
                state = States.TEXAS;
                break;
        }
        return state;
    }
    @Override
    public boolean isConnectedToElectricalGrid() {
        return false;
    }

    @Override
    public int getWeight() {
        totalWeight = 0;
        for(int i = 0; i < mailCargo.size(); i++){
            totalWeight += mailCargo.get(i).getMailWeight();
        }
        return totalWeight + weight;
    }

    @Override
    public void load() {
        try{
            int generatablePayload = (int)(Math.random()*20);
            for(int i = 0; i < generatablePayload; i++){
                mailCargo.add(new MailStuck(i));
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
        return "Amount of mail cargo is " + mailCargo.size() +
                "\n, destination state is " + state;
    }

    @Override
    public void getMethods(int userChoice) {
        if(userChoice == 1){
            unloadMail();
            System.out.println("Mail unloaded");
        } else if (userChoice == 2) {
            loadBack();
            System.out.println("Mail loaded");
        }else {
            System.out.println("No such option!");
        }
    }

    @Override
    public String toString() {
        return "RailroadMailCart has: " +
                "\n, total weight is " + getWeight() +
                "\n, connected to electrical grid " + connectedToElectricalGrid;
    }

}
