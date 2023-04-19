package menu;

import railroadCarts.RailroadCart;
import railroadCarts.Train;
import railroadCarts.TrainSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu implements Runnable {
    private TrainSet trainSet;

    public Menu(TrainSet trainSet) {
        this.trainSet = trainSet;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("Railroad menu:");
                System.out.println("1.Display information of trains");
                System.out.println("2.Select train");
                System.out.println("3.Terminate program");
                int action = -1;
                try{
                action = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException e){
                }
                if (action == 1) {
                    for (int i = 0; i < trainSet.size(); i++) {
                        System.out.println(trainSet.getTrainById(i) + "\n");
                    }
                } else if (action == 2) {
                    System.out.println("Enter train id:");
                    int trainId = -1;
                    try{
                        trainId = Integer.parseInt(reader.readLine());
                    }catch (NumberFormatException e){
                    }
                    while (true) {
                        System.out.println("Train:");
                        System.out.println("1.Info");
                        System.out.println("2.Locomotive");
                        System.out.println("3.Railroad carts");
                        System.out.println("4.Exit");
                        int subMenuAction = 0;
                        try {
                            subMenuAction = Integer.parseInt(reader.readLine());
                        }catch (NumberFormatException e){
                        }
                        if (subMenuAction == 1) {
                            System.out.println("Info:");
                            Train foundTrain = trainSet.getTrainById(trainId);
                            System.out.println(foundTrain);
                        } else if (subMenuAction == 2) {
                            System.out.println("Locomotive info:");
                            String locomotiveInfo = trainSet.getTrainById(trainId).getLocomotive().toString();
                            System.out.println(locomotiveInfo);
                        } else if (subMenuAction == 3) {
                            while (true) {
                                System.out.println("Railroad carts");
                                System.out.println("1.Display info or interact");
                                System.out.println("2.Attach railroad carts");
                                System.out.println("3.Detach railroad carts");
                                System.out.println("4.Exit");
                                int subMenuActionA = 0;
                                try {
                                    subMenuActionA = Integer.parseInt(reader.readLine());
                                }catch (NumberFormatException e){
                                }
                                if (subMenuActionA == 1) {
                                    System.out.println("1.Railroad carts stuck info");
                                    System.out.println("2.Particular railroad cart info or interaction");
                                    int subMenuActionB = 0;
                                    try {
                                        subMenuActionB = Integer.parseInt(reader.readLine());
                                    }catch (NumberFormatException e){
                                    }
                                    if (subMenuActionB == 1) {
                                        int a = 0;
                                        System.out.println("Railroad carts for train with id: " + trainId + "\n");
                                        for (RailroadCart railroadCarts : trainSet.getTrainById(trainId).getRailroadCarts()) {
                                            a++;
                                            System.out.println("ID of railroad cart " + (a - 1) + " , " + railroadCarts.getName() + "\n");
                                        }
                                    } else if (subMenuActionB == 2) {
                                        System.out.println("Info and interaction");
                                        System.out.println("1.Info");
                                        System.out.println("2.Interaction");
                                        System.out.println("3.Exit");
                                        int subMenuActionC = 0;
                                        try {
                                            subMenuActionC = Integer.parseInt(reader.readLine());
                                        }catch (NumberFormatException e){
                                        }
                                        if (subMenuActionC == 1) {
                                            System.out.println("Info");
                                            int i = 0;
                                            for (RailroadCart railroadCarts : trainSet.getTrainById(trainId).getRailroadCarts()) {
                                                i++;
                                                System.out.println("ID of railroad cart " + (i - 1) + " , " + railroadCarts.getName() + "\n");
                                            }
                                            System.out.println("Enter id of railroad cart(among those that are listed): ");
                                            int idOfdRailroadCart = 0;
                                            try{
                                            idOfdRailroadCart = Integer.parseInt(reader.readLine());
                                            } catch (NumberFormatException e){
                                            }
                                            if (idOfdRailroadCart == trainSet.getTrainById(trainId).getRailroadCarts().get(idOfdRailroadCart).getId(idOfdRailroadCart)) {
                                                RailroadCart railroadCart = trainSet.getTrainById(trainId).getRailroadCarts().get(idOfdRailroadCart);
                                                System.out.println("Info for: " + railroadCart.getName());
                                                System.out.println(railroadCart);
                                                while (true) {
                                                    System.out.println("Do you want more information?");
                                                    System.out.println("1.Show detail information about cargo");
                                                    System.out.println("2.Exit");
                                                    int action2 = 0;
                                                    try {
                                                        action2 = Integer.parseInt(reader.readLine());
                                                    }catch (NumberFormatException e){
                                                    }
                                                    if (action2 == 1) {
                                                        System.out.println(trainSet.getTrainById(trainId).getRailroadCarts().get(idOfdRailroadCart).getInfoAboutCargo());
                                                    } else if (action2 == 2) {
                                                        break;
                                                    }
                                                }
                                            }
                                        } else if (subMenuActionC == 2) {
                                            System.out.println("Interaction");
                                            int j = 0;
                                            for (RailroadCart railroadCarts : trainSet.getTrainById(trainId).getRailroadCarts()) {
                                                j++;
                                                System.out.println("ID of railroad cart " + (j - 1) + " , " + railroadCarts.getName() + "\n");
                                            }
                                            System.out.println("Enter id of railroad cart(among those that are listed): ");
                                            int userChoice = 0;
                                            try {
                                                userChoice = Integer.parseInt(reader.readLine());
                                            }catch (NumberFormatException e){
                                            }
                                            if (userChoice == trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getId(userChoice)) {
                                                if(trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getName().equals("Railroad cart for toxic materials")){
                                                    System.out.println("1.Neutralize toxic waste");
                                                    int userChoice2 = Integer.parseInt(reader.readLine());
                                                    trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getMethods(userChoice2);
                                                }else if(trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getName().equals("Restaurant railroad cart")){
                                                    System.out.println("1.Show free seats left");
                                                    System.out.println("2.Get guest information");
                                                    int userChoice3 = Integer.parseInt(reader.readLine());
                                                    trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getMethods(userChoice3);
                                                }else if(trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getName().equals("Passenger railroad cart")){
                                                    System.out.println("1.Show passengers info");
                                                    int userChoice4 = Integer.parseInt(reader.readLine());
                                                    trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getMethods(userChoice4);
                                                } else if (trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getName().equals("Refrigerator railroad cart")) {
                                                    System.out.println("1.Increase storage temperature");
                                                    System.out.println("2.Decrease storage temperature");
                                                    int userChoice5 = Integer.parseInt(reader.readLine());
                                                    trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getMethods(userChoice5);
                                                } else if (trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getName().equals("Mail cart")) {
                                                    System.out.println("1.Unload mail");
                                                    System.out.println("2.Load mail");
                                                    int userChoice6 = Integer.parseInt(reader.readLine());
                                                    trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getMethods(userChoice6);
                                                } else if (trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getName().equals("Baggage railroad cart")){
                                                    System.out.println("1.Unload baggage");
                                                    System.out.println("2.Load baggage");
                                                    int userChoice7 = Integer.parseInt(reader.readLine());
                                                    trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getMethods(userChoice7);
                                                } else if (trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getName().equals("Post office railroad cart")) {
                                                    System.out.println("1.Get workers info");
                                                    int userChoice8 = Integer.parseInt(reader.readLine());
                                                    trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getMethods(userChoice8);
                                                } else if (trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getName().equals("Railroad cart for toxic liquid materials")) {
                                                    System.out.println("1.Decrease temperature");
                                                    System.out.println("2.Increase temperature");
                                                    int userChoice9 = Integer.parseInt(reader.readLine());
                                                    trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getMethods(userChoice9);
                                                } else if (trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getName().equals("Railroad cart for gas")) {
                                                    System.out.println("1.Check pressure");
                                                    int userChoice10 = Integer.parseInt(reader.readLine());
                                                    trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getMethods(userChoice10);
                                                } else if (trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getName().equals("Railroad cart for liquid materials")) {
                                                    System.out.println("1.Check temperature");
                                                    System.out.println("2.Decrease temperature");
                                                    int userChoice11 = Integer.parseInt(reader.readLine());
                                                    trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getMethods(userChoice11);
                                                } else if (trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getName().equals("Railroad Cart fo explosives")) {
                                                    System.out.println("1.Check temperature");
                                                    System.out.println("2.Decrease temperature");
                                                    int userChoice12 = Integer.parseInt(reader.readLine());
                                                    trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getMethods(userChoice12);
                                                }else{
                                                    System.out.println("No such option!");
                                                }
                                            }
                                        } else if (subMenuActionC == 3) {
                                            break;
                                        } else {
                                            System.out.println("No such action! Enter those that have been mentioned (1-2)");
                                        }
                                    }
                                } else if (subMenuActionA == 2) {
                                    System.out.println("Choose type:");
                                    System.out.println("1.PassengerRailroadCart");
                                    System.out.println("2.RailroadBaggageCart");
                                    System.out.println("3.RefrigeratorRailroadCart");
                                    System.out.println("4.RailroadMailCart");
                                    System.out.println("5.ExplosivesRailroadCart");
                                    System.out.println("6.GaseousMatRailroadCar");
                                    System.out.println("7.PostOfficeRailroadCart");
                                    System.out.println("8.RestaurantRailroadCart");
                                    System.out.println("9.ToxicMatRailroadCart");
                                    System.out.println("10.LiquidMatRailroadCart");
                                    System.out.println("11.LiquidToxicMatRailroadCart");
                                    int railroadCartType = 0;
                                    try{
                                    railroadCartType = Integer.parseInt(reader.readLine());
                                    }catch (NumberFormatException e){
                                    }
                                    System.out.println("Attaching railroad cart...");
                                    trainSet.getTrainById(trainId).attachRailroadCart(trainId, railroadCartType);
                                    System.out.println("Done!");
                                } else if (subMenuActionA == 3) {
                                    int i = 0;
                                    System.out.println("Choose one of those listed to detach: ");
                                    for (RailroadCart railroadCarts : trainSet.getTrainById(trainId).getRailroadCarts()) {
                                        i++;
                                        System.out.println("ID of railroad cart " + (i - 1) + " , " + railroadCarts.getName() + "\n");
                                    }
                                    int userChoice = 0;
                                    try {
                                        userChoice = Integer.parseInt(reader.readLine());
                                    }catch (NumberFormatException e){
                                    }
                                    System.out.println("Detaching railroad cart...");
                                    if (userChoice == trainSet.getTrainById(trainId).getRailroadCarts().get(userChoice).getId(userChoice)) {
                                        trainSet.getTrainById(trainId).detachRailroadCart(userChoice);
                                    }
                                    System.out.println("Done!");
                                } else if (subMenuActionA == 4) {
                                    break;
                                }
                            }
                        } else if (subMenuAction == 4) {
                            break;
                        } else {
                            System.out.println("No such action!");
                        }
                }
            } else if (action == 3) {
                    System.exit(0);
                }else {
                    System.out.println("No such action!");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
