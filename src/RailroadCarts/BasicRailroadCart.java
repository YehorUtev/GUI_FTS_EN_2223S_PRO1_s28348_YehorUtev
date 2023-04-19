package RailroadCarts;

public abstract class BasicRailroadCart extends RailroadCart{
    protected int maxWeight;
    protected int maxVolume;
    public BasicRailroadCart(int id) {
        super(id);
        this.maxVolume = 20000;
        this.maxWeight = 40000;
    }
}
