package Interfaces;

public abstract class Animal implements Comparable<Animal>{

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

    @Override
    public int compareTo(Animal o) {
        return name.compareTo(o.getName());
    }
}
