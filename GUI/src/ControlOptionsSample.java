import Interfaces.Animal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class ControlOptionsSample {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setTitle("Control Options");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AnimalListPanel animalListPanel = new AnimalListPanel();
        frame.getContentPane().add(animalListPanel);

        frame.pack();
        frame.setVisible(true);






    }




}
