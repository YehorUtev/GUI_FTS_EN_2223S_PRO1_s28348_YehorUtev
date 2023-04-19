package railroadCarts;

import enums.MailCompany;
import exceptions.TooMuchWeightException;
import objects.People;

import java.util.ArrayList;
import java.util.List;

public class PostOfficeRailroadCart extends RailroadCart {
    private int maxWeight;
    private int amountOfPersonnel;
    private List<People> personnel;
    private MailCompany mailCompany;
    private int totalWeight;
    private String[] names;

    public PostOfficeRailroadCart(int id) {
        super(id);
        this.maxWeight = 30000;
        this.personnel = new ArrayList<>();
        this.amountOfPersonnel = (int) Math.ceil(Math.random() * 20);
        this.mailCompany = generateMailCompany();
        this.names = new String[]{"Max", "Alice", "Bob",
                "Charlie", "David", "Eve", "Frank",
                "Grace", "Hank", "Ivy", "Jack", "Kate",
                "Luke", "Mary", "Nathan", "Olivia", "Paul",
                "Quincy", "Rachel", "Sam", "Tom", "Uma",
                "Victor", "Wendy", "Xander", "Yara", "Zane"};
        name = "Post office railroad cart";
    }

    public MailCompany generateMailCompany() {
        int randomNumber = (int) Math.ceil(Math.random() * 3);
        switch (randomNumber) {
            case (1):
                mailCompany = MailCompany.DHL;
                break;
            case (2):
                mailCompany = MailCompany.FEDEX;
                break;
            case (3):
                mailCompany = MailCompany.USPS;
                break;
        }
        return mailCompany;
    }
    public void getWorkersInfo(){
        System.out.println("Workers info: ");
        for(int i = 0; i < personnel.size(); i++){
            System.out.println("Name -> " + personnel.get(i).getName() + " ,age -> " + personnel.get(i).getAge());
        }
    }

    @Override
    public boolean isConnectedToElectricalGrid() {
        return true;
    }

    @Override
    public int getWeight() {
        int inWeight = 0;
        for(int i = 0; i < amountOfPersonnel; i++){
            inWeight += personnel.get(i).getWeight();
        }
        return inWeight + weight;
    }

    @Override
    public void load() {
        try{
            for (int i = 0; i < amountOfPersonnel; i++) {
                int randomNumber = (int)(Math.random()*names.length);
                String randomName = names[randomNumber];
                int randomWeight = (int) Math.floor(Math.random() * (100 - 50) + 50);
                int randomAge = (int) Math.floor(Math.random() * (60 - 18) + 18);
                personnel.add(new People(i, randomWeight, randomAge, randomName));
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
        return "Amount of personnel on board is " + amountOfPersonnel +
                "\n, mail company is " + mailCompany;
    }

    @Override
    public void getMethods(int userChoice) {
        if(userChoice == 1){
            getWorkersInfo();
        }else{
            System.out.println("No such option!");
        }
    }

    @Override
    public String toString() {
        return "PostOfficeRailroadCart has: " +
                "\n, total weight is " + totalWeight +
                "\n, connected to electrical grid " + connectedToElectricalGrid;
    }
}
