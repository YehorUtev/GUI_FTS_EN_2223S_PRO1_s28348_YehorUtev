package Menu;

import RailroadCarts.RailroadCart;
import RailroadCarts.Train;
import RailroadCarts.TrainSet;

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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                System.out.println();
                System.out.println("Railroad menu:");
                System.out.println("1.Display information of trains");
                System.out.println("2.Select train");
                System.out.println("3.Terminate program");
                int action = Integer.parseInt(reader.readLine());
                switch (action) {
                    case (1):
                        for (int i = 0; i < trainSet.size(); i++) {
                            System.out.println(trainSet.getTrainById(i) + "\n");
                        }
                        break;
                    case (2):
                        System.out.println("Enter train id:");
                        int trainId = Integer.parseInt(reader.readLine());
                        System.out.println("Train:");
                        System.out.println("1.Info");
                        System.out.println("2.Locomotive");
                        System.out.println("3.Railroad carts");
                        int subMenuAction = Integer.parseInt(reader.readLine());
                        switch (subMenuAction) {
                            case (1):
                                System.out.println("Info:");
                                System.out.println("Enter train id:");
                                int id = Integer.parseInt(reader.readLine());
                                Train foundTrain = trainSet.getTrainById(id);
                                System.out.println(foundTrain);
                                break;
                            case (2):
                                System.out.println("Locomotive info:");
                                System.out.println("Enter train id to show its locomotive information:");
                                int idForLoc = Integer.parseInt(reader.readLine());
                                String locomotiveInfo = trainSet.getTrainById(idForLoc).getLocomotive().toString();
                                System.out.println(locomotiveInfo);
                                break;
                            case (3):
                                System.out.println("Railroad carts");
                                System.out.println("1.Display info or interact");
                                System.out.println("2.Attach railroad carts");
                                System.out.println("3.Detach railroad carts");
                                int subMenuActionA = Integer.parseInt(reader.readLine());
                                switch (subMenuActionA) {
                                    case (1):
                                        System.out.println("1.Railroad carts stuck info");
                                        System.out.println("2.Particular railroad cart info or interaction");
                                        int subMenuActionB = Integer.parseInt(reader.readLine());
                                        switch (subMenuActionB) {
                                            case (1):
                                                System.out.println("Enter train id to display its railroad carts and their info: ");
                                                int idForTrain = Integer.parseInt(reader.readLine());
                                                int a = 0;
                                                System.out.println("Railroad carts for train with id: " + idForTrain + "\n");
                                                for (RailroadCart railroadCarts : trainSet.getTrainById(idForTrain).getRailroadCarts()) {
                                                    a++;
                                                    System.out.println("ID of railroad cart " + (a - 1) + " , " + railroadCarts.getName() + "\n");
                                                }
                                                break;
                                            case (2):
                                                System.out.println("Info and interaction");
                                                System.out.println("1.Info");
                                                System.out.println("2.Interaction");
                                                int subMenuActionC = Integer.parseInt(reader.readLine());
                                                switch (subMenuActionC) {
                                                    case (1):
                                                        System.out.println("Info");
                                                        System.out.println("Enter train id: ");
                                                        int i = 0;
                                                        for (RailroadCart railroadCarts : trainSet.getTrainById(trainId).getRailroadCarts()) {
                                                            i++;
                                                            System.out.println("ID of railroad cart " + (i - 1) + " , " + railroadCarts.getName() + "\n");
                                                        }
                                                        System.out.println("Enter id of railroad cart(among those that are listed): ");
                                                        int idOfdRailroadCart = Integer.parseInt(reader.readLine());
                                                        if (idOfdRailroadCart == trainSet.getTrainById(trainId).getRailroadCarts().get(idOfdRailroadCart).getId(idOfdRailroadCart)) {
                                                            RailroadCart railroadCart = trainSet.getTrainById(trainId).getRailroadCarts().get(idOfdRailroadCart);
                                                            System.out.println("Info for: " + railroadCart.getName());
                                                            System.out.println(railroadCart);
                                                            while (true) {
                                                                System.out.println("Do you want more information?");
                                                                System.out.println("1.Show detail information about cargo");
                                                                System.out.println("2.Exit");
                                                                int action2 = Integer.parseInt(reader.readLine());
                                                                if (action2 == 1) {

                                                                } else if (action2 == 2) {
                                                                    break;
                                                                }
                                                            }
                                                        }
                                                        break;
                                                    case (2):
                                                        System.out.println("Interaction");
                                                        System.out.println("Enter train id: ");
                                                        int j = 0;
                                                        int trainID = Integer.parseInt(reader.readLine());
                                                        for (RailroadCart railroadCarts : trainSet.getTrainById(trainID).getRailroadCarts()) {
                                                            j++;
                                                            System.out.println(j + " " + railroadCarts.getName() + "\n");
                                                        }
                                                        System.out.println("Enter id of railroad cart(among those that are listed: ");
                                                        int userChoice = Integer.parseInt(reader.readLine());
                                                        if (userChoice == trainSet.getTrainById(trainID).getRailroadCarts().get(userChoice).getId(userChoice)) {
                                                        }
                                                        break;
                                                    default:
                                                        System.out.println("No such action! Enter those that have been mentioned (1-2)");
                                                        break;
                                                }
                                                break;
                                            default:
                                                System.out.println("No such action! Enter those that have been mentioned (1-2)");
                                                break;
                                        }
                                        break;
                                    case (2):
                                        System.out.println("Enter train id:");
                                        int idForRailroadCart = Integer.parseInt(reader.readLine());
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
                                        int railroadCartType = Integer.parseInt(reader.readLine());
                                        System.out.println("Attaching railroad cart...");
                                        Thread.sleep(2000);
                                        trainSet.getTrainById(idForRailroadCart).attachRailroadCart(idForRailroadCart, railroadCartType);
                                        System.out.println("Done!");
                                        break;
                                    case (3):
                                        System.out.println("Enter train id:");
                                        int idOfTrain = Integer.parseInt(reader.readLine());
                                        int i = 0;
                                        System.out.println("Choose one of those listed to detach: ");
                                        for (RailroadCart railroadCarts : trainSet.getTrainById(idOfTrain).getRailroadCarts()) {
                                            i++;
                                            System.out.println("ID of railroad cart " + (i - 1) + " , " + railroadCarts.getName() + "\n");
                                        }
                                        int userChoice = Integer.parseInt(reader.readLine());
                                        System.out.println("Detaching railroad cart...");
                                        Thread.sleep(2000);
                                        if (userChoice == trainSet.getTrainById(idOfTrain).getRailroadCarts().get(userChoice).getId(userChoice)) {
                                            trainSet.getTrainById(idOfTrain).detachRailroadCart(userChoice);
                                        }
                                        System.out.println("Done!");
                                        break;
                                    default:
                                        System.out.println("No such action! Enter those that have been mentioned (1-3)");
                                        break;
                                }
                                break;
                        }
                        break;
                }
                if (action == 3) {
                    System.out.println("Terminating program...");
                    System.out.println("Program successfully terminated!");
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);

        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
