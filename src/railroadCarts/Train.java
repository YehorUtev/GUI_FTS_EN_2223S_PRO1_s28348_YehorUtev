package railroadCarts;

import exceptions.RailRoadHazardException;
import exceptions.TooMuchCartsException;
import objects.Station;
import objects.StationCollection;

import java.util.*;

public class Train implements Runnable{
    private Locomotive locomotive;
    private List<RailroadCart> railroadCarts;
    private int id;
    private List<Station> route;
    private double speed;
    private double distanceCovered;
    private int amountOfRailroadCarts;
    private int countOfElecCarts;
    private int totalDistance;
    private double percentsCovered;
    private double percentsCoveredBetweenTwo;

    public Train(int id) {
        this.railroadCarts = generateRailroadCarts();
        this.locomotive = new Locomotive();
        this.route = new ArrayList<>();
        this.id = id;
        this.speed = 120;
        this.percentsCovered = 0;
        this.distanceCovered = 0;
        this.totalDistance = 0;
        this.percentsCoveredBetweenTwo = 0;
        this.amountOfRailroadCarts = railroadCarts.size();
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void detachRailroadCart(int userChoice){
        railroadCarts.remove(userChoice);
    }
    public void sort(){
        Collections.sort(railroadCarts, (r1,r2) -> Integer.compare(r1.getWeight(), r2.getWeight()));
    }

    public void attachRailroadCart(int id, int userChoice) {
        if(railroadCarts.size() >= 10){
            try {
                throw new TooMuchCartsException(this);
            } catch (TooMuchCartsException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        switch (userChoice) {
            case (1):
                PassengerRailroadCart passengerRailroadCart = new PassengerRailroadCart(id);
                passengerRailroadCart.load();
                railroadCarts.add(passengerRailroadCart);
                break;
            case (2):
                RailroadBaggageCart railroadBaggageCart = new RailroadBaggageCart(id);
                railroadBaggageCart.load();
                railroadCarts.add(railroadBaggageCart);
                break;
            case (3):
                RefrigiratorRailroadCart refrigiratorRailroadCart = new RefrigiratorRailroadCart(id);
                refrigiratorRailroadCart.load();
                railroadCarts.add(refrigiratorRailroadCart);
                break;
            case (4):
                RailroadMailCart railroadMailCart = new RailroadMailCart(id);
                railroadMailCart.load();
                railroadCarts.add(railroadMailCart);
                break;
            case (5):
                ExplosivesRailroadCart explosivesRailroadCart = new ExplosivesRailroadCart(id);
                explosivesRailroadCart.load();
                railroadCarts.add(explosivesRailroadCart);
                break;
            case (6):
                GaseousMatRailroadCar gaseousMatRailroadCar = new GaseousMatRailroadCar(id);
                gaseousMatRailroadCar.load();
                railroadCarts.add(gaseousMatRailroadCar);
                break;
            case (7):
                PostOfficeRailroadCart postOfficeRailroadCart = new PostOfficeRailroadCart(id);
                postOfficeRailroadCart.load();
                railroadCarts.add(postOfficeRailroadCart);
                break;
            case (8):
                RestaurantRailroadCart restaurantRailroadCart = new RestaurantRailroadCart(id);
                restaurantRailroadCart.load();
                railroadCarts.add(restaurantRailroadCart);
                break;
            case (9):
                ToxicMatRailroadCart toxicMatRailroadCart = new ToxicMatRailroadCart(id);
                toxicMatRailroadCart.load();
                railroadCarts.add(toxicMatRailroadCart);
                break;
            case (10):
                LiquidMatRailroadCart liquidMatRailroadCart = new LiquidMatRailroadCart(id);
                liquidMatRailroadCart.load();
                railroadCarts.add(liquidMatRailroadCart);
                break;
            case (11):
                LiquidToxicMatRailroadCart liquidToxicMatRailroadCart = new LiquidToxicMatRailroadCart(id);
                liquidToxicMatRailroadCart.load();
                railroadCarts.add(liquidToxicMatRailroadCart);
        }
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }
    public List<RailroadCart> getRailroadCarts() {
        return railroadCarts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public List<RailroadCart> generateRailroadCarts() {
        railroadCarts = new ArrayList<>();
        int randomAmountOfCarts = (int)Math.ceil(Math.random()*(10 - 5) + 5);
        for (int i = 0; i < randomAmountOfCarts; i++) {
            int random = (int) Math.ceil(Math.random() * 11);
            switch (random) {
                case (1):
                    railroadCarts.add(new PassengerRailroadCart(i + 1));
                    break;
                case (2):
                    railroadCarts.add(new RailroadBaggageCart(i + 1));
                    break;
                case (3):
                    railroadCarts.add(new RefrigiratorRailroadCart(i+1));
                    break;
                case (4):
                    railroadCarts.add(new RailroadMailCart(i+1));
                    break;
                case (5):
                    railroadCarts.add(new ExplosivesRailroadCart(i+1));
                    break;
                case (6):
                    railroadCarts.add(new GaseousMatRailroadCar(i+1));
                    break;
                case (7):
                    railroadCarts.add(new PostOfficeRailroadCart(i+1));
                    break;
                case (8):
                    railroadCarts.add(new RestaurantRailroadCart(i+1));
                    break;
                case (9):
                    railroadCarts.add(new ToxicMatRailroadCart(i+1));
                    break;
                case (10):
                    railroadCarts.add(new LiquidMatRailroadCart(i+1));
                    break;
                case(11):
                    railroadCarts.add(new LiquidToxicMatRailroadCart(i+1));
                    break;
            }if(railroadCarts.get(i).connectedToElectricalGrid == true){
                countOfElecCarts++;
            }
        }
        return railroadCarts;
    }
    public void loadAll(){
        for(RailroadCart railroadCart : railroadCarts){
            railroadCart.load();
        }
    }

    public void generateRoute(StationCollection stationCollection) {
        int firstStationId = (int) Math.floor(Math.random() * 100);
        List<Station> stations = stationCollection.getStationList();
        Station currentStation = stations.get(firstStationId);
        route.add(currentStation);
        for (int i = 0; i < 9; i++) {
            int random = (int) Math.floor(Math.random() * 10);
            Map<Station, Integer> availableStation = currentStation.getStationMap();
            int j = 0;
            for (Station key : availableStation.keySet()) {
                if (j == random) {
                    route.add(key);
                    totalDistance += availableStation.get(key);
                    currentStation = key;
                }
                j++;
            }
        }
    }

    @Override
    public void run() {
        while(true) {
            int currentStation = 0;
            double distance = 0;
            double finalDistance = 0;
            while (currentStation < route.size() - 1) {
                try {
                    Thread.sleep(2000);
                    route.get(currentStation).setAvailable(true);
                    distance = route.get(currentStation).getStationMap().get(route.get(currentStation + 1));
                    finalDistance = route.get(currentStation).getStationMap().get(route.get(currentStation + 1));
                    System.out.println("Train with id -> " + id + " is on station -> " + currentStation);
                    while (distance >= 0) {
                        double recentDistance = distance;
                        distance -= speed;
                        int randomNumber = (int) Math.ceil(Math.random() * 2);
                        if (distance >= 0) {
                            distanceCovered += speed;
                            percentsCovered = distanceCovered/(totalDistance/100.);
                            percentsCoveredBetweenTwo = (finalDistance - distance)/(finalDistance/100.);
                            Thread.sleep(1000);
                        }else{
                            distanceCovered = distanceCovered + recentDistance;
                        }
                        if (randomNumber == 1) {
                            speed = speed * 1.03;
                        } else if (randomNumber == 2) {
                            speed = speed * 0.97;
                        }
                        if (speed > 200) {
                            throw new RailRoadHazardException(this);
                        }
                        System.out.println("His speed right now is -> " + speed);
                    }
                    currentStation++;
                    if (route.get(currentStation).isAvailable()) {
                        route.get(currentStation).setAvailable(false);
                    } else {
                        Thread.sleep(2000);
                        route.get(currentStation).setAvailable(false);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (RailRoadHazardException e) {
                    System.out.println(e.getMessage());
                }catch (Exception e){
                    System.out.println("Unknown error occurred, please restart application");
                }
            }
            System.out.println("Train with id -> " + id + " ,got to the last station");
            Collections.reverse(route);
            try {
                Thread.sleep(5000);
                System.out.println("Stations swapped");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public int getWeightOfTrain(){
        int totalWeight = 0;
        for(int i = 0; i < railroadCarts.size(); i++){
            totalWeight += railroadCarts.get(i).getWeight();
        }
        return totalWeight + locomotive.getWeight();
    }

    @Override
    public String toString() {
        return "\n Id of train is -> " + id + "\n " +
                locomotive.toString() +
                "\n,total weight of train is -> " + getWeightOfTrain() +
                "\n, speed -> " + speed +
                "\n, amount of railroad carts is -> " + railroadCarts.size() +
                "\n, amount of railroad carts that need electricity -> " + countOfElecCarts +
                "\n, total distance is -> " + totalDistance +
                "\n, total percents covered -> " + percentsCovered +
                "\n, percents covered between two closest stations -> " + percentsCoveredBetweenTwo +
                "\n";
    }
}
