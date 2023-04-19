package objects;

import java.util.*;

public class Station{
    private Map<Station, Integer> stationMap;
    private int id;
    private boolean available;
    public Station(int id) {
        this.stationMap = new HashMap();
        this.id = id;
        this.available = true;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean addStation(Station station){
        if(stationMap.size() == 10){
            return false;
        }
        if(!stationMap.containsKey(station) && (station.getId() != this.id) && station.getStationMap().size() < 10){
            int distance = (int)(Math.random()*(800 - 300) + 300);
            stationMap.put(station, distance);
        }
        return true;
    }

    public Map<Station, Integer> getStationMap() {
        return stationMap;
    }

    public boolean isAvailable() {
        return available;
    }
}
