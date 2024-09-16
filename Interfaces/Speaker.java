package Interfaces;

public interface Speaker {

    // Static methods: Factory are common
    public static Speaker getGabbler() {
        return () -> {return "Gabble-Gabble";};
    }

    // Default Get Volume

    // Private methods
    private String amplify(String speech) {
        String amplified = "";
        // (int i = 0; i < getVolume(); i++)
            amplified += speech + "\n";
        return amplified;
    }

    public  String speak() ;
}
