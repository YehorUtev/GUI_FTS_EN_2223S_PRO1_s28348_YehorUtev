package objects;


public class People{
    private int id;
    private int weight;
    private int age;
    private String name;
    public People(int id, int weight, int age, String name) {
        this.id = id;
        this.weight = weight;
        this.age = age;
        this.name = name;
    }
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
