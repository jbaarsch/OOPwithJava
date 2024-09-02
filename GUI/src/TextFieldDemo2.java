import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldDemo2 extends JPanel {

    // Instance variables for the TextFieldDemo2 Panel--so that the action listener has access to them.
    JTextField textField;
    DisplayPanel displayPanel;

    // Constructor for TextFieldDemo2
    public TextFieldDemo2() {
        // Set dimensions for the main panel
        this.setPreferredSize(new Dimension(1000, 1000));
        this.setBackground(Color.BLUE);

        // Create Upper panel that holds the text field.
        JPanel upperPanel = new JPanel();
        upperPanel.setBackground(Color.PINK);
        upperPanel.setPreferredSize(new Dimension(970, 300));

        // Set up the TextField.  Make it bigger, add the action listener so that it can respond to events.  Add it
        // to the upper panel
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 50));
        textField.setFont(new Font("sansserif", Font.PLAIN, 40));
        textField.addActionListener(new TextListener());
        upperPanel.add(textField);

        // Add the upper panel to the main panel.
        this.add(upperPanel);

        // Create the Display Panel and add it to the main panel.
        // This is the panel that should update when the event fires.
        displayPanel = new DisplayPanel();
        this.add(displayPanel);
    }

    //  This is an inner class that represents the Listener/Responder to changes in the
    // textfield.
    private class TextListener implements ActionListener {
        // The function that gets called when the enter key is hit.
        public void actionPerformed(ActionEvent e) {
            displayPanel.setText(textField.getText());
            revalidate();
            repaint();
        }
    }

    // This is an inner class only because I want the demo in one file.  Normally, This would absolutely
    // be in its own file.
    private class DisplayPanel extends JPanel {

        JPanel innerDisplayPanel;

        // Constructor for the DisplayPanel.  Just set the dimensions and color
        public DisplayPanel() {
            this.setBackground(Color.CYAN);
            this.setPreferredSize(new Dimension(970, 400));
            innerDisplayPanel = new JPanel();
            innerDisplayPanel.setBackground(Color.CYAN);
            this.add(innerDisplayPanel);
        }

        // This function will get called to set the text on the panel--it will get called from
        // the actionPerformed function.
        public void setText(String text) {
            this.remove(innerDisplayPanel);
            innerDisplayPanel = new JPanel();
            innerDisplayPanel.setBackground(Color.magenta);

            JLabel displayLabel = new JLabel(text);
            displayLabel.setFont(new Font("sansserif", Font.PLAIN, 40));
            innerDisplayPanel.add(displayLabel);
            this.add(innerDisplayPanel);
        }

        // This is the paint command.  Not doing anything special with this at the moment.
        // Probably don't even need to override it.
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

        }
    }

    // This main function is just to test the demo.
    public static void main(String[] args) {

        // Create a frame and add a TextFieldDemo2 panel to it.
        JFrame frame = new JFrame("TextFieldDemo2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TextFieldDemo2 demo = new TextFieldDemo2();
        frame.getContentPane().add(demo);
        frame.pack();
        frame.setVisible(true);


    }




}
