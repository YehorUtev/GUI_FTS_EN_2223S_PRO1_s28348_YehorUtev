package objects;

public class Mail {
    private final int weight = 1;
    private int mailId;

    public Mail(int mailId) {
        this.mailId = mailId;
    }

    public int getWeight() {
        return weight;
    }
}
