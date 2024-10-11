package Collections;

import java.util.BitSet;

public class BitSetExample {
    final static int READ_PERMISSION = 0;
    final static int WRITE_PERMISSION = 1;
    final static int EXECUTE_PERMISSION = 2;
    final static BitSet noLimits = new BitSet(3);
    final static BitSet readOnly = new BitSet(3);

    public static void main(String[] args) {
        noLimits.set(READ_PERMISSION); // permission to read
        noLimits.set(WRITE_PERMISSION); // permission to write
        noLimits.set(EXECUTE_PERMISSION); // permission to execute

        readOnly.set(READ_PERMISSION);  // permission to read

        BitSet myPermissions = noLimits;

        BitSet yourPermissions = new BitSet(3);
        System.out.println("Do I have permission to read?");
        System.out.println((myPermissions.get(READ_PERMISSION))? "yes": "no");
        System.out.println("Do you have permission to read?");
        System.out.println((yourPermissions.get(READ_PERMISSION))? "yes": "no");

        System.out.println("I give you permission to read");
        yourPermissions.set(READ_PERMISSION);  // you have permission to read


        System.out.println("Do you have permission to read?");
        System.out.println((yourPermissions.get(READ_PERMISSION))? "yes": "no");
        System.out.println("Do you have permission to write?");
        System.out.println((yourPermissions.get(WRITE_PERMISSION))? "yes": "no");
        System.out.println("Do you have permission to execute?");
        System.out.println((yourPermissions.get(EXECUTE_PERMISSION))? "yes": "no");

    }


}
