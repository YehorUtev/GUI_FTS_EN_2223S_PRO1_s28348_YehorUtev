package Objects;

public class Baggage {
    private int id;
    private int weight;
    private int volume;

    public Baggage(int id, int weight, int volume) {
        this.id = id;
        this.weight = weight;
        this.volume = volume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
