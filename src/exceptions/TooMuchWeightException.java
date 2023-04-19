package exceptions;

import railroadCarts.RailroadCart;

public class TooMuchWeightException extends Exception{
    private RailroadCart railroadCart;
    public TooMuchWeightException(RailroadCart railroadCart){
        this.railroadCart = railroadCart;
    }
    public String getMessage(){
        return "Too much weight -> " + railroadCart.toString();
    }
}
