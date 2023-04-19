package railroadCarts;

import objects.StationCollection;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

public class TrainSet implements Runnable {
    private List<Train> trainSet;

    public TrainSet() {
        this.trainSet = new ArrayList<>();
    }

    public int size() {
        return trainSet.size();
    }

    public Train getTrainById(int id) {
        for (Train train : trainSet) {
            if (train.getId() == id) {
                return train;
            }
        }
        return null;
    }

    public List<Train> getTrainSet() {
        return trainSet;
    }

    public void sortAll() {
        for (Train train : trainSet) {
            train.sort();
        }
    }

    public void sortTrains() {
        Collections.sort(trainSet, (t1, t2) -> Integer.compare(t2.getTotalDistance(), t1.getTotalDistance()));
    }

    public void generateTrains() {
        //change from 1 to 25
        for (int i = 1; i <= 1; i++) {
            trainSet.add(new Train(i));
        }
    }

    public void loadAllTrains() {
        for (Train train : trainSet) {
            train.loadAll();
        }
    }

    public void generateRoads(StationCollection stationCollection) {
        for (Train train : trainSet) {
            train.generateRoute(stationCollection);
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try (
                    BufferedWriter writer = new BufferedWriter(new FileWriter("AppState.txt", true));
            ) {
                for (Train train : trainSet) {
                    writer.write(train.toString());
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
