package Interfaces;

public abstract class Animal {

    private String name;

    public Animal(String n) {
        name = n;
    }

    public String getName(){
        return name;
    }
    public void setname(String n) {
        name = n;
    }

}
