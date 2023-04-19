package railroadCarts;

public abstract class RailroadCart {
    protected int id;
    protected String name;
    protected int weight;
    protected boolean connectedToElectricalGrid;

    public RailroadCart(int id) {
        this.weight = 5000;
        this.id = id;
    }

    public abstract boolean isConnectedToElectricalGrid();

    public abstract int getWeight();

    public abstract void load();

    public abstract String getInfoAboutCargo();

    public abstract void getMethods(int userChoice);

    public int getId(int id) {
        return id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "RailroadCart{" +
                "id=" + id +
                ", name='" + name +
                ", weight=" + weight +
                ", connectedToElectricalGrid=" + connectedToElectricalGrid +
                '}';
    }
}
