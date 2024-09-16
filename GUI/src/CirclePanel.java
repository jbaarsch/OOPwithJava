import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class CirclePanel extends JPanel {

    private Circle[] circles;

    public CirclePanel() {
        this.setPreferredSize(new Dimension(500, 500));
        circles = new Circle[5];
        circles[0] = new Circle(0, 0 );
        circles[1] = new Circle(150, 0 );
        circles[2] = new Circle(0, 150 );
        circles[3] = new Circle(150, 150 );
        circles[4] = new Circle(200, 200 );

    }

    public void paint(Graphics g) {
        Arrays.sort(circles);
        int x = 0;

        for (Circle circle : circles) {
            circle.setX(x);
            circle.setY(0);
            circle.draw(g);
            x += circle.getRadius() * 2;

        }

    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Circle Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new CirclePanel());
        frame.pack();
        frame.setVisible(true);
    }



}
