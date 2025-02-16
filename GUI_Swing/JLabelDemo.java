package GUI_Swing;

import java.awt.*;
import javax.swing.*;

public class JLabelDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("JLabel Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new JLabelPanel());
        frame.pack();
        frame.setVisible(true);
    }

    private static class JLabelPanel extends JPanel {
        public JLabelPanel(){
            this.setPreferredSize(new Dimension(700, 700));
            this.setBackground(Color.WHITE);

            JLabel label = new JLabel("Hello World");

            label.setFont(new Font("Serif", Font.BOLD, 50));
            label.setForeground(Color.BLUE);
            //label.setBackground(Color.magenta);
            //label.setOpaque(true);

            String text = label.getText();
            label.setText("Good Morning");

            //this.add(label);

            ImageIcon img = new ImageIcon("penny.jfif");

            JLabel imgLabel = new JLabel(img);
            this.add(imgLabel);
            //label.setIcon(img);
            //label.setHorizontalTextPosition(SwingConstants.LEFT);











        }






    }




}
