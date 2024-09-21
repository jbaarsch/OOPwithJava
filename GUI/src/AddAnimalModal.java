import Interfaces.Animal;
import Interfaces.Dog;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class AddAnimalModal extends JFrame {

    private AnimalListPanel animalListPanel;
    AddAnimalModal modal;
    // passes the list of strings into an abstract List, which is then used to build a concrete ArrayList.
    // Represents the different types of Animals I want to create.
    public static final ArrayList<String> animalTypes =  new ArrayList<>(Arrays.asList("Dog", "Rooster", "Cat"));

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

        private record Attribute( String name, JComponent value){};

        private ArrayList<Attribute> attributes;

        public AddAnimalPanel (){
            attributes = new ArrayList<>();
            JPanel infoCollectorPanel = new JPanel();
            infoCollectorPanel.setPreferredSize(new Dimension(600, 400));
            infoCollectorPanel.setBackground(Color.magenta);

            JComboBox<String> animalTypeComboBox = new JComboBox<String>(animalTypes);
            animalTypeComboBox.addActionListener(e -> {
                attributes.clear();
                infoCollectorPanel.removeAll();
                switch (animalTypeComboBox.getSelectedIndex()) {
                    case : {
                        attributes.add(new Attribute("Name", new JTextField(10)));
                        attributes.add(new Attribute("Age", new JTextField(10)));
                        attributes.add(new Attribute("Color", new JColorChooser(Color.WHITE)));
                        attributes.add(new Attribute("Size", new JComboBox<Dog.DogSize>(Dog.DogSize.values())));
                    }
                    case 1: {
                        attributes.add(new Attribute("Name", new JTextField(10)));
                    }








                }

                infoCollectorPanel.add(new Attribute(new JLabel("Name"), new JTextField(10)))

            });


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
