package GUI_Swing;

import java.awt.*;
import javax.swing.*;


public class FramesDemo {

    public static void main(String[] args) {


        //  PLAY WITH JFRAME HERE!!!!!!

        // TITLES
        // You can add a title to the JFrame by sending it as a parameter to the JFrame Constructor.
        JFrame frame = new JFrame("Frames and Panels");
        // title is an instance variable of JFrame, so you can also change the title later by using the
        // setTitle(String title) function.
        frame.setTitle("Frames Demo");
        // If, for some reason, you need to get the title in your application, you can get it, too.
        String frameTitle = frame.getTitle();

        // CLOSE OPERATIONS
        // You can change the close operation for the JFrame by using one of the JFrame constants.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Note: these are merely integer values that have been given names so that they make sense to someone reading
        // the code.  It is just as possible to send in a number to have the same effect.
        //  0 = do nothing on close
        //  1 = hide on close
        //  2 = dispose on close
        //  3 = exit on close
        //  Using class constants to distinguish between different options is a technique to keep in mind.
        // try it out:
        frame.setDefaultCloseOperation(0);  // Sabotage!
        // defaultCloseOperation is just another instance variable in JFrame that is an int
        // When the button is clicked, that int is used in a switch statement to determine what code to execute.
        int whatToDoOnClose = frame.getDefaultCloseOperation();

        // SIZE
        // Size in the standard Java library is determined by a class in the awt package called Dimension.
        // Dimension is a good name, because it literally just keeps track of a box with certain dimensions.
        Dimension size = new Dimension(100, 500);
        // if you use the dot operator after the size variable now, you will see there isn't a lot to the Dimension
        // class.  A height and a width is about it.  You can get them and set them as you like after you create
        // the dimension.

        // You can use Dimension objects, to customize and standardize sizes of components in your GUI.
        // 100 by 500 is a strange size, let's make that more standard by making the dimension
        // 500 by 500.
        size.setSize(500, 500);
        // Note that you cannot change the width and height individually.  Why?  I haven't been able to find the
        // answer.

        // After your Dimension has been created, you can use it to set the preferred size of the Frame.
        // Note for later: Yes, "preferred" is an important qualifier here.  There are layout managers that
        // we may get to later that can size your component to their wishes.  This is just sort of setting the
        // default size of your component if there are no other constraints on it.
        frame.setPreferredSize(size);

        // COLOR
        frame.getContentPane().setBackground(Color.BLUE);
        // See the ColorDemo.java file for more information about colors.  Here, we are merely concerned with the
        // fact that you can set the color of the frame's content pane, if you like.
        // let's change the background color of the frame to RED
        frame.getContentPane().setBackground(Color.RED);

        // There are many, many other features of the JFrame--and you can experiment with them--many of which
        // use other GUI concepts that we'll cover later in this tutorial.
        // However, these are really all you need to know to get started.

        frame.pack();
        frame.setVisible(true);


    }


}
