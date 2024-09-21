package Interfaces;

public class Rooster extends Animal implements Speaker{


    public Rooster(){
        super("FogHorn LegHorn");
    }

    public Rooster(String name) {
        super(name);
    }

    public String speak() {
        return "Cock-a-doodle-doo!";
    }
}
