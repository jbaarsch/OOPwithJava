package Interfaces;

public class Kennel {

    public static void main(String[] args) {

        Speaker[] objects =  new Speaker[5];
        Dog myDog = new Dog();
        objects[0] = myDog;
        objects[1] = new Cat();
        objects[2] = new Dog();
        objects[3] = new Rooster();
        objects[4] = new Car();

        for (Speaker o : objects)
            System.out.println(o.speak());


        System.out.println(myDog.speak());

    }

}
