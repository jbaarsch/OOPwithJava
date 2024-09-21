import Interfaces.Animal;
import Interfaces.Dog;

import javax.swing.*;
import java.awt.*;

public class AddAnimalModal extends JFrame {

    private AnimalListPanel animalListPanel;
    AddAnimalModal modal;

    public AddAnimalModal(AnimalListPanel animalListPanel) {
        modal = this;
        this.animalListPanel = animalListPanel;

        this.setTitle("Add Animal");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(new AddAnimalPanel());

        this.pack();
        this.setVisible(true);

    }

    private class AddAnimalPanel extends JPanel {

        public AddAnimalPanel (){
            JTextField nameField = new JTextField(10);
            JButton addAnimalButton = new JButton("Submit");
            addAnimalButton.addActionListener(e -> {
                Animal newAnimal = new Dog(nameField.getText());
                animalListPanel.addAnimal(newAnimal);
                modal.dispose();
            });
            this.setPreferredSize(new Dimension(500, 500));
            this.add(nameField);
            this.add(addAnimalButton);
        }






    }



}
