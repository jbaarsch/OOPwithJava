package GUI_Swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("TextField Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new TextFieldPanel());

        frame.pack();
        frame.setVisible(true);


    }

    public static class TextFieldPanel extends JPanel {

        private JTextField textField;

        private JLabel label;


        public TextFieldPanel() {
            this.setPreferredSize(new Dimension(700, 700));
            this.setBackground(Color.WHITE);

            textField = new JTextField();
            textField.setPreferredSize(new Dimension(300, 50));
            textField.setFont(new Font("sansserif", Font.PLAIN, 40));
            textField.addActionListener(new CoinListener());

            label = new JLabel("Nothing yet");
            label.setFont(new Font("sansserif", Font.PLAIN, 40));

            this.add(textField);
            this.add(label);
        }

        private class CoinListener implements ActionListener {

            public void actionPerformed(ActionEvent e) {
                //label.setText("Something Happened!");

                String text = textField.getText();
                double amt = Double.parseDouble(text);

                System.out.println(text);


                label.setText("$" + amt);

                label.setIcon(new ImageIcon("penny.jfif"));


            }

        }




    }




}
