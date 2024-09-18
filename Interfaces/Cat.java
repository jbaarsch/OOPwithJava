package Interfaces;

public class Cat extends Animal implements Speaker, Comparable<Cat> {

    public enum HairLength { HAIRLESS, SHORT_HAIR, MEDIUM_HAIR, LONG_HAIR}

    private HairLength hair;

    public String speak() {
        return "Meow";
    }

    public Cat(String n, HairLength h) {
        super(n);
        hair = h;
    }

    public Cat() {
        super("Garfield");
        hair = HairLength.MEDIUM_HAIR;
    }

    public HairLength getHair() {
        return hair;
    }

    public void setHair(HairLength hair) {
        this.hair = hair;
    }

    public int compareTo(Cat otherCat) {
        return hair.ordinal() - otherCat.hair.ordinal();
    }

}
