package Interfaces;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Kennel {

    public static void main(String[] args) {

        //demoSpeaker();
        //demoComparisons();
        demoSuperSubComparisons();

    }

    public static void demoSpeaker() {

        Speaker[] noiseMakers =  new Speaker[5];
        Dog myDog = new Dog();
        noiseMakers[0] = myDog;
        noiseMakers[1] = new Cat();
        noiseMakers[2] = new Rooster();
        noiseMakers[3] = Speaker.getGabbler();
        noiseMakers[4] = new Car();

        for (Speaker s: noiseMakers)
            System.out.println(s.getVolume());

    }

    public static void demoComparisons() {

        // Declare a collection of Dogs
        Dog[] dogs =  new Dog[5];
        Dog myDog = new Dog();
        dogs[0] = myDog;
        dogs[1] = new Dog("Spot", 5, Color.GRAY, Dog.DogSize.SMALL_DOG);
        dogs[2] = new Dog("Fi-Fi", 7, Color.WHITE, Dog.DogSize.LAP_DOG);
        dogs[3] = new Dog("Brutus", 3, Color.BLACK, Dog.DogSize.GUARD_DOG);
        dogs[4] = new Dog("Zeus", 2,Color.GRAY, Dog.DogSize.RESCUE_DOG);

        // print the dogs in their order:
        for (Dog d : dogs)
            System.out.println(d);
        // Alterantively:
        //Stream.of(dogs).forEach(System.out::println);
        System.out.println("\n\n");


        //  Sort the dogs:  Arrays.sort will sort any collection that implements the Comparable Interface.
        Arrays.sort(dogs);
        System.out.println("Dogs, alphabetically:");
        for (Dog d : dogs)
            System.out.println(d);
        System.out.println("\n\n");


        // But let's sort by size!
        // compareTo in Dog, sorted alphabetically by name.  Sort will also accept a parameter of type
        // Comparator, which can be used to pass in a custom sort function.
        Comparator<Dog> dogSizer = new Comparator<Dog>() {
            @Override
            public int compare(Dog dog1, Dog dog2) {
                return dog1.getSize().ordinal()-dog2.getSize().ordinal();
            }
        };
        // Pass the list of dogs as well as the Comparator
        Arrays.sort(dogs, dogSizer);
        // Demonstrate the new sort order
        System.out.println("Dogs, by size:");
        for (Dog d : dogs)
            System.out.println(d);
        System.out.println("\n\n");


        // Meh, now I want them arranged by age!
        // So, I just create a new comparator based on the age field.
        //Comparator<Dog> dogsByAge = new Comparator<Dog>() {
          //  public int compare(Dog dog1, Dog dog2) {

            //    return dog1.getAge() - dog2.getAge();
           // }
        //};
        Arrays.sort(dogs, Comparator.comparingInt(Dog::getAge));
        System.out.println("Dogs, by Age:");
        for (Dog d : dogs)
            System.out.println(d);
    }

    public static void demoSuperSubComparisons() {
        Animal[] animals = {
                new Cat(),
                new Dog(),
                new Cat("Shadow", Cat.HairLength.SHORT_HAIR),
                new Dog( "Spenser", 4, Color.WHITE, Dog.DogSize.SMALL_DOG),
                new Cat("Levin", Cat.HairLength.LONG_HAIR),
                new Dog("Zeus", 2, Color.GRAY, Dog.DogSize.RESCUE_DOG)
        };

        Arrays.sort(animals);

        for (Animal a : animals)
            System.out.println(a.getName());


        System.out.println(Cat.HairLength.SHORT_HAIR.getDisplayName());



    }

}
