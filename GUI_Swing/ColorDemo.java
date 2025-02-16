package GUI_Swing;

import java.awt.*;
import javax.swing.*;

public class ColorDemo {

    // This function just displays the square of whatever color colorPlay determines.
    public static void main(String[] args) {

        // Setting up the Frame and Panel
        JFrame frame = new JFrame("Trying out colors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel colorPanel = new JPanel();
        colorPanel.setPreferredSize(new Dimension(500, 500));

        // Get color from the colorPlay method.
        Color panelColor = colorPlay();
        colorPanel.setBackground(panelColor);

        // finish initializing frame and panel.
        frame.getContentPane().add(colorPanel);
        frame.pack();
        frame.setVisible(true);
    }

    // This function provides an opportunity to try out three different ways of getting colors.
    public static Color colorPlay() {
            // EXPERIMENT WITH COLORS HERE!!!
        Color panelColor;

            // 1. Use a pre-defined constant Color:
            // There are several constants defined in the Color class representing common colors: red, green, blue, black,
            // white, green, yellow, cyan, dark_gray, gray, magenta, orange, and pink
        panelColor = Color.BLUE;

            // OR 2. we can customize a Color based on the rgb color-space
            // Color vectors can be represented as rgb values; integers from 0 to 255;
        int red = 122, green = 25, blue = 155;
        panelColor = new Color(red, green, blue);

            // ALTERNATIVELY, 3. we can create our own static Color constants in a separate class and import
            // them when we want.
        panelColor = Palette.BROWN;

            // There are several other methods associated with the Color class--try them out and see what they do!!!
            // Once a Color is defined, it is closed to being modified.  Instead, any changes will have to be saved as
            // a new Color object.  You can get the rgb values, but not set them directly.
        Color brighter = panelColor.brighter();
            // Alternatively, make the original color brighter by "saving" over it.
        //panelColor = panelColor.brighter();

        return panelColor;
    }

}
