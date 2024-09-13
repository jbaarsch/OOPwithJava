package Interfaces;

/*
Dog should have instance variables:
name:String
age:int
color:Color (from the java.awt library)
size:int. // in comments you can indicate the size is in pounds.
Dog should have the following methods:
A constructor that accepts all instance data
A default constructor that sets all instance data to some default: "Fido", 2, Color.WHITE, 30
Getters and setters for all instance variables.
getAgeInHumanYears(): int       // should return the age * 7;
toString(): String      // should override toString() and return a string representation of the dog.
speak():String          // should return "Yip-Yip" if the dog is under 15 pounds, "Bark-Bark" if the dog is between 16 and 45 pounds, and "Woof-Woof" if the dog is over 40 pounds
The driver should create a few dogs and add them to an ArrayList<Dog> called dogs.
It should also test some of the functions.
 */


import java.awt.*;

public class Dog implements Speaker{
    private String name;
    private int age;
    private Color color;
    private int size;

    public Dog (String n, int a, Color c, int s) {
        name = n;
        age = a;
        color = c;
        size = s;
    }

    public Dog () {
        name = "Fido";
        age = 2;
        color = Color.WHITE;
        size = 30;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String speak(){
        return "Bow-wow";
    }
}
