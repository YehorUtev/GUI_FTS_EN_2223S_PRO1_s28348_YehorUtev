package exceptions;

import railroadCarts.Train;

public class RailRoadHazardException extends Exception{
    private Train train;
    public RailRoadHazardException(Train train){
        this.train = train;
    }
    @Override
    public String getMessage(){
        return "Speed exceed 200 km/h! " + train.toString();
    }
}
