package Objects;

public class Food {
    private int id;
    private final int weight;

    public Food(int id) {
        this.id = id;
        this.weight = 1000;
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }
}
