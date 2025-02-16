package GUI_Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class CirclePanel extends JPanel {

    private Circle[] circles;

    private JButton button;


    public CirclePanel() {
        this.setPreferredSize(new Dimension(500, 500));
        circles = new Circle[5];
        circles[0] = new Circle(0, 0 );
        circles[1] = new Circle(150, 0 );
        circles[2] = new Circle(0, 150 );
        circles[3] = new Circle(150, 150 );
        circles[4] = new Circle(200, 200 );
        button = new JButton("Click Me");
        button.addActionListener(e -> {
            for (Circle c : circles)
                c.setColor(Color.cyan);
            revalidate();
            repaint();
        });

        this.add(button);

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

    private class ClickListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            for (Circle c : circles)
                c.setColor(Color.cyan);
            revalidate();
            repaint();
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
