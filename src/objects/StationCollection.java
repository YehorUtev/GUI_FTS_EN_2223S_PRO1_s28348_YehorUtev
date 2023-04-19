package objects;

import java.util.ArrayList;
import java.util.List;

public class StationCollection {

    private List<Station> stationList;

    public StationCollection() {
        this.stationList = new ArrayList<>();
    }

    public List<Station> getStationList() {
        return stationList;
    }

    public void generateRandomStation() {
        for (int i = 1; i <= 100; i++) {
            stationList.add(new Station(i));
        }
    }

    public void generateConnections() {
        for (int i = 0; i < 93; i++) {
            boolean check = true;
            Station station = stationList.get(i);
            while (check) {
                int random = (int) Math.floor(Math.random() * 100);
                check = station.addStation(stationList.get(random));
                Station station1 = stationList.get(random);
                station1.addStation(stationList.get(i));
                stationList.set(random, station1);
            }
        }
    }
}
