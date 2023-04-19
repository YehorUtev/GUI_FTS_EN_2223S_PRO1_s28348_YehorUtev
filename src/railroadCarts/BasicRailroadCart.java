package railroadCarts;

public abstract class BasicRailroadCart extends RailroadCart{
    protected int maxWeight;
    protected int maxVolume;
    protected int weight;
    public BasicRailroadCart(int id) {
        super(id);
        this.maxVolume = 20000;
        this.maxWeight = 40000;
        this.weight = 8000;
    }
}
