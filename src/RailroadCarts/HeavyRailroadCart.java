package RailroadCarts;

public abstract class HeavyRailroadCart extends RailroadCart{
    protected int maxWeight;
    protected int maxVolume;
    public HeavyRailroadCart(int id) {
        super(id);
        this.maxVolume = 40000;
        this.maxWeight = 60000;
        this.weight = 15000;
    }
}
