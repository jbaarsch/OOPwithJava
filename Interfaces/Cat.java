package Interfaces;

public class Cat extends Animal implements Speaker {

    public enum HairLength {

        HAIRLESS("Hairless"), SHORT_HAIR("Short Hair"), MEDIUM_HAIR("Medium Hair"),
        LONG_HAIR("Long Hair");
        private String displayName;
        public String getDisplayName() {
            return displayName;
        }
        public static int hairballSize = 30;
        HairLength() {
            displayName = "Undetermined" ;

        }

        HairLength(String dN) {
            displayName = dN;
        }

        }

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

    public int compareTo(Animal otherCat) {
        if (otherCat instanceof Cat) {
            return hair.ordinal() - ((Cat) otherCat).hair.ordinal();
        } else
            return super.compareTo(otherCat);
    }

}
