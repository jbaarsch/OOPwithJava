package logging;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.*;
import static java.util.logging.Level.*;  // FINER, FINE, INFO, WARNING, SEVERE
//import static java.lang.System.Logger.Level.*;  // TRACE, DEBUG, INFO, WARNING, ERROR

public class LoggingDemo {
    private static final String logName = "%h/Documents/Work/UCA/CSCI 3381/githubrepo/loggingDemo.log";

    public static void main(String[] args) throws IOException {

        Scanner in, fileScan = null, lineScan;
        in = new Scanner(System.in);
        // initialize Logger
        Logger logger = Logger.getLogger("OOPWithJava.logging");
        // Add a file handler to send log messages to file as well as console.
        // logName is name of path and file (begging with home dir); boolean is whether to append to existing file
        var handler = new FileHandler(logName, true);
        // Set the minimum level of severity of messages that will be sent to this handler.
        handler.setLevel(INFO);
        logger.addHandler(handler);

        // Get file name from user.  If file is not found, ask for a new name.
        boolean fileNotFound = true;
        do {
            System.out.println("Please enter a file name and/or path to open: ");
            String fileName = in.nextLine();
            logger.log(INFO, "File name entered by user: " + fileName);
            try {
                fileScan = new Scanner(new File(fileName));
                fileNotFound = false;
                logger.log(INFO, "File Found!");
            } catch (FileNotFoundException e) {
                System.out.println("That file could not be found!");
                logger.log(WARNING, "File Not Found:" + fileName);
            }
        } while (fileNotFound);

        // Iterate through the file, line by line
        while (fileScan.hasNext()) {
            String line = fileScan.nextLine();
            lineScan = new Scanner(line);

            // Iterate through the line, item by item
            short num = 0;
            while (lineScan.hasNext()) {
                try {
                    String item = lineScan.next();
                    num = Short.parseShort(item);
                    if (num * num > Short.MAX_VALUE)
                        throw new SquareOutOfBoundsException(num + " cannot be squared in a short");
                    num = (short) (num * num);

                } catch (NumberFormatException e) {
                    logger.log(SEVERE, "Could not parse item into Short! \n Replacing with zero." );
                    num = 0;
                } catch (SquareOutOfBoundsException e) {
                    logger.log(SEVERE, e.getMessage() + "\n Replacing with " + Short.MAX_VALUE);
                    num = Short.MAX_VALUE;
                }
                System.out.print(num + "\t");

            }
            System.out.println();
        }

    }


}
