package Exceptions;

import RailroadCarts.Train;
import RailroadCarts.TrainSet;

public class TooMuchCartsException extends Exception{
    private Train train;
    public TooMuchCartsException(Train train){
        this.train = train;
    }
    public String getMessage(){
        return "Too much railroad carts -> " + train.getRailroadCarts();
    }
}
