package presentation;

import menu.Menu;
import objects.StationCollection;
import railroadCarts.TrainSet;

public class Presentation {
    public static void main(String[] args) {
        StationCollection stationCollection = new StationCollection();
        TrainSet trainSet = new TrainSet();
        stationCollection.generateRandomStation();
        stationCollection.generateConnections();
        trainSet.generateTrains();
        trainSet.loadAllTrains();
        trainSet.generateRoads(stationCollection);
        trainSet.loadAllTrains();
        trainSet.sortAll();
        trainSet.sortTrains();
        Menu menu1 = new Menu(trainSet);
        for(int i = 1; i <= 1; i++){
            Thread thread = new Thread(trainSet.getTrainById(i));
            thread.start();
        }
        Thread menu = new Thread(menu1);
        menu.start();
        Thread appState = new Thread(trainSet);
        appState.start();
    }
}
