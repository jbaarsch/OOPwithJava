import javax.swing.*;
import java.awt.*;

public class FrameDemo {

    public static void main(String[] args) {

        // A JFrame is a heavyweight container that is used to display GUI-based Java applications.
        // A Frame is managed by the operating system--so some of the details will look different depending on
        // the environment on which you run the frame.

        // If you think of a GUI as a series of nested containers, the JFrame is the outermost container.  It has the
        // operations related to minimizing, and closing the GUI.

        // This simple frame demonstrates its most basic features.
        // Text appears at the top.
        JFrame frame = new JFrame("Frame Demo");
        // the close operation is what happens when the X on the window is clicked.  This makes the most sense,
        // but other nasty options include JFrame.DO_NOTHING_ON_CLOSE
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // sets the size of the frame.  This can be changed through mouse interaction.
        frame.setSize(300, 300);
        // Sets the visibility to true.  This begins the execution of the GUI.
        frame.setVisible(true);



        JFrame frame2 = new JFrame("Frame Demo2");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(300, 300);
        // It is possible to set the location.  Location relative to null puts the container in the middle.
        // Location relative to frame, would place it immediately on top of the frame object.
        frame2.setLocationRelativeTo(null);
            // Alternatively, you can specify where in the window, you wish the frame to appear:
            // frame2.setLocation(400, 0);
        frame2.setVisible(true);

        // The current DefaultCloseOperation Exits the program when the window is closed.
        // Change one of the DefaultCloseOperations to JFrame.DISPOSE_ON_CLOSE, and then test what happens
        // when you close it.

        // There are many, many different methods you can call on the JFrame, but oftentimes, the primary
        // purpose of the frame is merely to hold Panels.





    }



}
