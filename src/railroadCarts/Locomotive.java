package railroadCarts;

import enums.Source;

public class Locomotive {
    private Source source;
    private int weight;
    private final int maximumNumberOfCarts;
    private final int maximumWeightOfTransportedLoad;
    private final int maximumNumberOfElecCarts;

    public Locomotive() {
        this.weight = 10000;
        this.maximumNumberOfCarts = 10;
        this.maximumWeightOfTransportedLoad = 300000;
        this.maximumNumberOfElecCarts = 4;
        this.source = generateSource();
    }

    public int getWeight() {
        return weight;
    }

    public Source generateSource(){
        int randomNumber = (int)Math.ceil(Math.random()*3);
        switch (randomNumber){
            case(1) :
                source = Source.CHARCOAL;
                break;
            case(2) :
                source = Source.ELECTRICAL;
                break;
            case(3) :
                source = Source.DIESEL;
                break;
        }
        return source;
    }

    @Override
    public String toString() {
        return " Locomotive has: " +
                "\n, source which is " + source +
                "\n, maximum number of connected carts connected to power grid is " + maximumNumberOfElecCarts +
                "\n, maximum number of connected railroad carts is " + maximumNumberOfCarts +
                "\n, maximum amount of transported load is " + maximumWeightOfTransportedLoad;
    }
}
