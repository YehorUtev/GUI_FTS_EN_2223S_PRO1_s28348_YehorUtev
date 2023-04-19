package Objects;

import java.util.ArrayList;
import java.util.List;

public class MailStuck {
    private List<Mail> mailStuck;
    private int id;

    public MailStuck(int id) {
        this.id = id;
        generateMailStuck();
    }
    public void generateMailStuck() {
        this.mailStuck = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            this.mailStuck.add(new Mail(i));
        }
    }
    public int getMailWeight(){
        int weight = 0;
        for(int i = 0; i < 1000; i++){
            weight += mailStuck.get(i).getWeight();
        }
        return weight;
    }
}
