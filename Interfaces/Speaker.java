package Interfaces;

public interface Speaker {

    // Static methods: Factory are common
    public static Speaker getGabbler() {
        return () -> {return  "Gabble-Gabble";};
    }

    // Default Get Volume
    public default int getVolume() {
        return 0;
    }

    // Private methods
    private String amplify(String speech) {
        String amplified = "";
        for (int i = 0; i < getVolume() ; i++)
            amplified += speech + "\n";
        return amplified;
    }

    public  String speak() ;
}
