package Collections;

import java.util.BitSet;

public class BitSetExample {

    final static BitSet noLimits = new BitSet(3);
    final static BitSet readOnly = new BitSet(3);

    public static void main(String[] args) {
        noLimits.set(0); // permission to read
        noLimits.set(1); // permission to write
        noLimits.set(2); // permission to execute

        readOnly.set(0);  // permission to read

        BitSet myPermissions = noLimits;

        BitSet yourPermissions = new BitSet(3);
        System.out.println("Do I have permission to read?");
        System.out.println((myPermissions.get(0))? "yes": "no");
        System.out.println("Do you have permission to read?");
        System.out.println((yourPermissions.get(0))? "yes": "no");

        System.out.println("I give you permission to read");
        yourPermissions.set(0);  // you have permission to read


        System.out.println("Do you have permission to read?");
        System.out.println((yourPermissions.get(0))? "yes": "no");
        System.out.println("Do you have permission to write?");
        System.out.println((yourPermissions.get(1))? "yes": "no");
        System.out.println("Do you have permission to execute?");
        System.out.println((yourPermissions.get(2))? "yes": "no");

    }


}
