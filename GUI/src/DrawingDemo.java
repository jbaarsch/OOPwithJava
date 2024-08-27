import jdk.jfr.SettingControl;

import javax.swing.*;
import java.awt.*;
import java.net.CacheRequest;

public class DrawingDemo {

    private final static int WIDTH = 500;
    private final static int HEIGHT = 500;

    public static void main(String[] args) {

        // Setting up the Frame and Panel
        JFrame frame = new JFrame("Trying out drawing");
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

            // Setting parameters.
            // It is often easier to set a few points as reference points in the graphics context, and then
            // draw with respect to those.
            final int squareX = 20, ovalX = 140, arcX = 260, triangleX = 380;
            final int shapeSize = 100;
            final int row1Y = 20, row2Y = 140, row3Y = 260, row4Y = 380;


                // set the background white in order to see what we draw.
            this.setBackground(Color.white);

            // Our panel is WIDTH (x-length) by HEIGHT (y-length);
            // Coordinates start at 0, 0 in the upper left corner and go up in the x direction to the right, and up in
            // the y direction down.  Every component has its own coordinate system, so be sure you are drawing on the
            // correct component.

                // When drawing, it is necessary to first choose a color for your drawing.
                // We choose a color by calling the setColor method of the Graphics class.
            graphics.setColor(Color.BLACK);

                // Let's start by drawing filled shapes:
                // A rectangle is defined by the X, Y coordinate of its upper right corner, and a width and a height in pixels.
            graphics.fillRect(squareX, row1Y, shapeSize, shapeSize);
                // An oval is defined by the rectangle that surrounds it.  (It's "bounding" rectangle.)
            graphics.fillOval(ovalX, row1Y, shapeSize,  shapeSize);
                // An arc is defined by the oval it is part of + the angle where it starts (from 0),
                // and the angle of the arc itself.
            graphics.fillArc(arcX, row1Y, shapeSize, shapeSize, 90, 90);
                // A Polygon can be defined with a number of points, where the X-coordinates are in one int array, and
                // the Y-coordinates are in another.
                // It's often easier to draw them out first, and then assign the values.
                // Let's make a simple triangle:
                        //  top:  triangleX + .5 * shapeSize, row1Y
                        //  bottom left:  triangleX, row1Y + shapeSize
                        //  bottom right:  triangleX + shapeSize, row1Y + shapeSize
                int[] Xs = {triangleX + (int) (.5 * shapeSize), triangleX, triangleX + shapeSize};
                int[] Ys = {row1Y, row1Y + shapeSize, row1Y + shapeSize};
                int numPts = 3;
            graphics.fillPolygon(Xs, Ys, numPts);
                // Alternatively, you can create a Polygon separately add the points individually, and then use it as a
                // parameter to the fillPolygon method.
                // There are some pre-built methods in the Polygon class related to the shape's bounds
                // and whether the shape contains a point, that might be useful for other applications.
                    Polygon shape = new Polygon();
                    // shape.addPoint(triangleX + (int) (.5 * shapeSize), row2Y);
                    //shape.addPoint(triangleX, row2Y + shapeSize);
                    //shape.addPoint(triangleX + shapeSize, row2Y + shapeSize);
                    //graphics.fillPolygon(shape);

                // In addition to filled shapes, you can just draw the outline of the shape.
                //graphics
                // Here, I merely copy the code from above, but change the "fill" functions to
                // "draw" functions.  Then I change all the row1Y variables to row2.
            graphics.drawRect(squareX, row2Y, shapeSize, shapeSize);
            graphics.drawOval(ovalX, row2Y, shapeSize,  shapeSize);
            graphics.drawArc(arcX, row2Y, shapeSize, shapeSize, 90, 90);
            int[] poly2Xs = {triangleX + (int) (.5 * shapeSize), triangleX, triangleX + shapeSize};
            int[] poly2Ys = {row2Y, row2Y + shapeSize, row2Y + shapeSize};
            graphics.drawPolygon(poly2Xs, poly2Ys, numPts);

                // Finally, we can also draw lines.  A line is defined by two points--each an end
                // of the line.
                // The following draws a line across the panel between the two rows of shapes.
            graphics.drawLine(1, row2Y - 10, DrawingDemo.WIDTH - 1, row2Y -10 );
                // You can also draw a Polyline, which is a line with multiple points, but the
                // beginning and the end are not connected.  Polyline takes the same arguments as
                // the Polygon.  Again, the only difference is that the first and last points are
                // not connected.
            int[] poly3Xs = {triangleX + (int) (.5 * shapeSize), triangleX, triangleX + shapeSize};
            int[] poly3Ys = {row3Y, row3Y + shapeSize, row3Y + shapeSize};
            graphics.drawPolyline(poly3Xs, poly3Ys, 3);

                // It is also possible to draw text:
            graphics.drawString("This text is too small", squareX, row3Y);
                // Just as it is possible to set the drawing color of the graphics object,
                // we can also set the Font.
                // Font objects can be created with a font name, font style, and size--or you can
                // use a preset.
            Font font = new Font(Font.SERIF, Font.BOLD, 40);
            graphics.setFont(font);
            graphics.drawString("This is easier to read", squareX, row3Y + 30);

        }
    }




}
