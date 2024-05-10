import javax.swing.*;
import java.awt.*;

public class DrawingDemo {

    private final static int WIDTH = 500;
    private final static int HEIGHT = 500;

    public static void main(String[] args) {

        // Setting up the Frame and Panel
        JFrame frame = new JFrame("Trying out colors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel drawingPanel = new DrawingPanel();
        drawingPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        // finish initializing frame and panel.
        frame.getContentPane().add(drawingPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private static class DrawingPanel extends JPanel {
        public void paintComponent (Graphics graphics) {
            super.paintComponent(graphics);

            //  PLAY WITH DRAWING HERE!!!!!!


                // set the background white in order to see what we draw.
            setBackground(Color.white);

            // Our panel is WIDTH (x-length) by HEIGHT (y-length);
            // Coordinates start at 0, 0 in the upper left corner and go up in the x direction to the right, and up in
            // the y direction down.  Every component has its own coordinate system, so be sure you are drawing on the
            // correct component.

                // When drawing, it is necessary to first choose a color for your drawing.
                // We choose a color by calling the setColor method of the Graphics class.
            graphics.setColor(Color.BLACK);

                // Let's start by drawing filled shapes:
                // A rectangle is defined by the X, Y coordinate of its upper right corner, and a width and a height in pixels.
            graphics.fillRect(20, 20, 100, 100);
                // An oval is defined by the rectangle that surrounds it.  (It's "bounding" rectangle.)
            graphics.fillOval(150, 20, 100, 100);
                // An arc is defined by the oval it is part of + the angle where it starts (from 0),
                // and the angle of the arc itself.
            graphics.fillArc(270, 20, 100, 100, 90, 90);
                // A Polygon can be defined with a number of points, where the X-coordinates are in one int array, and
                // the Y-coordinates are in another.
                // It's often easier to draw them out first, and then assign the values.
                // Let's make a simple triangle: top 440, 20; bottom left 390, 120; bottom right 490, 120
                int[] Xs = {440, 390, 490};
                int[] Ys = {20, 120, 120};
                int numPts = 3;
            graphics.fillPolygon(Xs, Ys, numPts);
                // Alternatively, you can create a Polygon separately add the points individually, and then use it as a
                // parameter to the fillPolygon method.
            Polygon shape = new Polygon();
            shape.addPoint(440, 150);
            shape.addPoint(390, 230);
            shape.addPoint(490, 230);
            graphics.fillPolygon(shape);




        }
    }




}
