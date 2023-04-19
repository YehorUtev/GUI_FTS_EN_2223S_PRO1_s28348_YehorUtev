package presentation;

import enums.Liquid;
import menu.Menu;
import objects.StationCollection;
import railroadCarts.*;

public class Presentation {
    public static void main(String[] args) {
        //overall look at program
        StationCollection stationCollection = new StationCollection();
        TrainSet trainSet = new TrainSet();
        stationCollection.generateRandomStation();
        stationCollection.generateConnections();
        trainSet.generateTrains();
        trainSet.loadAllTrains();
        trainSet.generateRoads(stationCollection);
        trainSet.sortAll();
        trainSet.sortTrains();
        //Menu menu1 = new Menu(trainSet);
        for(int i = 1; i <= 1; i++){
            Thread thread = new Thread(trainSet.getTrainById(i));
            thread.start();
        }
        //Thread menu = new Thread(menu1);
        //menu.start();
        Thread appState = new Thread(trainSet);
        appState.start();
        //more specific look at program

        //explosives
        /*ExplosivesRailroadCart explosivesRailroadCart = new ExplosivesRailroadCart(1);*/
        /*explosivesRailroadCart.load();
        explosivesRailroadCart.checkTemperature();
        explosivesRailroadCart.getInfoAboutCargo();
        explosivesRailroadCart.decreaseTemperature();
        explosivesRailroadCart.toString();*/

        //gas
        /*GaseousMatRailroadCar gaseousMatRailroadCar = new GaseousMatRailroadCar(1);*/
        //gaseousMatRailroadCar.load();
        //gaseousMatRailroadCar.checkPressure();
        //gaseousMatRailroadCar.getInfoAboutCargo();
        //gaseousMatRailroadCar.toString();

        //liquid
        /*LiquidMatRailroadCart liquidMatRailroadCart = new LiquidMatRailroadCart(1);*/
        //liquidMatRailroadCart.load();
        //liquidMatRailroadCart.checkTemperature();
        //liquidMatRailroadCart.decreaseTemperature();
        //liquidMatRailroadCart.generateTypeOfLiquid();
        //liquidMatRailroadCart.toString();

        //toxic liquid
        /*LiquidToxicMatRailroadCart liquidToxicMatRailroadCart = new LiquidToxicMatRailroadCart(1);*/
        //liquidToxicMatRailroadCart.load();
        //liquidToxicMatRailroadCart.increaseTemperature();
        //liquidToxicMatRailroadCart.generateToxicLiquid();
        //liquidToxicMatRailroadCart.decreaseTemperature();
        //liquidToxicMatRailroadCart.toString();

        //passenger railroad cart
        /*PassengerRailroadCart passengerRailroadCart = new PassengerRailroadCart(1);*/
        //passengerRailroadCart.load();
        //passengerRailroadCart.getInfoAboutCargo();
        //passengerRailroadCart.toString();

        //PostOffice cart
        /*PostOfficeRailroadCart postOfficeRailroadCart = new PostOfficeRailroadCart(1);
        postOfficeRailroadCart.load();*/
        //postOfficeRailroadCart.generateMailCompany();
        //postOfficeRailroadCart.getWorkersInfo();
        //postOfficeRailroadCart.toString();

        //Baggage railroad cart
        /*RailroadBaggageCart railroadBaggageCart = new RailroadBaggageCart(1);
        railroadBaggageCart.load();*/
        //railroadBaggageCart.getInfoAboutCargo();
        //railroadBaggageCart.unloadBaggage();
        //railroadBaggageCart.loadExtraBaggage();
        //railroadBaggageCart.toString();

        //mailRailroadCart
        /*RailroadMailCart railroadMailCart = new RailroadMailCart(1);*/
        //railroadMailCart.load();
        //railroadMailCart.getInfoAboutCargo();
        //railroadMailCart.unloadMail();
        //railroadMailCart.loadBack();
        //railroadMailCart.toString();

        //Refrigerator
        /*RefrigiratorRailroadCart refrigiratorRailroadCart = new RefrigiratorRailroadCart(1);*/
        //refrigeratorRailroadCart.load();
        //refrigeratorRailroadCart.getInfoAboutCargo();
        //refrigeratorRailroadCart.decreaseTemperature();
        //refrigeratorRailroadCart.increaseTemperature();
        //refrigeratorRailroadCart.toString();

        //Restaurant railroadCart
        /*RestaurantRailroadCart restaurantRailroadCart = new RestaurantRailroadCart(1);*/
        //restaurantRailroadCart.load();
        //restaurantRailroadCart.getInfoAboutCargo();
        //restaurantRailroadCart.getGuestsInfo();
        //restaurantRailroadCart.getAmountOfFreeSeats();
        //restaurantRailroadCart.toString();

        //ToxicMaterials railroad cart
        /*ToxicMatRailroadCart toxicMatRailroadCart = new ToxicMatRailroadCart(1);*/
        //toxicMatRailroadCart.load();
        //toxicMatRailroadCart.getInfoAboutCargo();
        //toxicMatRailroadCart.neutralizeToxicWaste();
        //toxicMatRailroadCart.toString();

        //locomotive
        /*Locomotive locomotive = new Locomotive();*/
        //locomotive.generateSource();
        //locomotive.toString();

        //train
        /*Train train = new Train(1);*/
        //train.getRailroadCarts();
        //train.attachRailroadCart();
        //train.loadAll();
        //train.detachRailroadCart();
        //train.toString();

        //trainset
        /*TrainSet trainSet = new TrainSet();*/
        //trainSet.loadAllTrains();
        //trainSet.generateTrains();
        //trainSet.sortTrains();
        //trainSet.generateRoads();
        //trainSet.sortAll();

        //objects
        /*StationCollection stationCollection = new StationCollection();*/
        //stationCollection.generateRandomStation();
        //stationCollection.generateConnections();
    }
}
