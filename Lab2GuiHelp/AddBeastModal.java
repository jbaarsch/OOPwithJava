package Lab2GuiHelp;

import Interfaces.Dog;

import javax.swing.*;
import java.awt.*;

public class AddBeastModal extends JFrame {

    private AnimalListPanel animalListPanel;
    private JButton addAnimalButton;
    AddBeastModal myself;

    public AddBeastModal(AnimalListPanel animalListPanel) {

        myself = this;
        this.animalListPanel = animalListPanel;
        this.setTitle("Add Beast");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(new AddAnimalPanel());
        this.pack();
        this.setVisible(true);



    }


    private class AddAnimalPanel extends JPanel {
        public AddAnimalPanel() {
            addAnimalButton = new JButton("Add Animal");
            addAnimalButton.addActionListener(e -> {
                Dog dog = new Dog();
                animalListPanel.addAnimal(dog);
                myself.dispose();
            });


            add(addAnimalButton);

            setPreferredSize(new Dimension(500, 500));
            setBackground(Color.CYAN);
        }
    }


}
