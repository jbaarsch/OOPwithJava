import Interfaces.Animal;

import javax.swing.*;
import java.awt.*;

public class AnimalPanel extends JPanel {
    Animal animal;

    public AnimalPanel(Animal animal) {
        setPreferredSize(new Dimension(670, 50));
        this.animal = animal;
        setBackground(new Color (150, 150, 50));

        JLabel nameLabel = new JLabel("Animal: " + animal.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 30));
        add(nameLabel);
    }




}
