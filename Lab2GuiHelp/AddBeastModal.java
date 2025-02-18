package Lab2GuiHelp;

import Interfaces.Animal;
import Interfaces.Cat;
import Interfaces.Dog;
import Interfaces.Rooster;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddBeastModal extends JFrame {

    private AnimalListPanel animalListPanel;
    private JButton addAnimalButton;
    private AddBeastModal myself;
    private String[] animals = {"Dog", "Cat", "Rooster"};
    private JComboBox<String> animalSelector;
    private JPanel infoCollectionPanel;
    private record Attribute(String name, JComponent component){} // name = name of the attribute, component is how the
    // attribute will be collected.
    private ArrayList<Attribute> attributes;
    private Color[] dogColors = {Color.BLACK, Color.GRAY, Color.WHITE, Color.YELLOW};


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
            setPreferredSize(new Dimension(500, 500));
            setBackground(Color.CYAN);
            //attributes = new ArrayList<>();

            animalSelector = new JComboBox<>(animals);

            add(animalSelector);


            infoCollectionPanel = new JPanel();
            infoCollectionPanel.setBackground(Color.WHITE);
            infoCollectionPanel.setPreferredSize(new Dimension(480, 400));
            animalSelector.addActionListener(e -> {
                infoCollectionPanel.removeAll();
                attributes = new ArrayList<>();
                switch(animalSelector.getSelectedIndex()) {
                    case 0:
                        attributes.add(new Attribute("Name", new JTextField(9)));
                        attributes.add(new Attribute("Age", new JTextField(9)));
                        attributes.add(new Attribute("Red", new JTextField(9)));
                        attributes.add(new Attribute("Green", new JTextField(9)));
                        attributes.add(new Attribute("Blue", new JTextField(9)));
                        attributes.add(new Attribute("Size", new JComboBox<Dog.DogSize>(Dog.DogSize.values())));
                        break;
                    case 1:
                        attributes.add(new Attribute("Name", new JTextField(9)));
                        attributes.add(new Attribute("Hair Length", new JComboBox<Cat.HairLength>(Cat.HairLength.values())));
                        break;
                    case 2:
                        attributes.add(new Attribute("Name", new JTextField(9)));
                        break;
                }
                infoCollectionPanel.setLayout(new GridLayout(attributes.size(), 2 ));
                for (Attribute attribute : attributes) {
                    infoCollectionPanel.add(new JLabel(attribute.name));
                    infoCollectionPanel.add(attribute.component);
                }
                revalidate();
                repaint();
            });
            animalSelector.setSelectedIndex(0);


            add(infoCollectionPanel);

            addAnimalButton = new JButton("Add Animal");
            addAnimalButton.addActionListener(e -> {
                Animal animal = new Dog();
                switch(animalSelector.getSelectedIndex()) {
                    case 0: animal = new Dog(
                            ((JTextField)(attributes.get(0).component())).getText(),
                            Integer.parseInt(((JTextField)(attributes.get(1).component())).getText()),
                            new Color (Integer.parseInt(((JTextField)(attributes.get(2).component())).getText()),
                                    Integer.parseInt(((JTextField)(attributes.get(3).component())).getText()),
                                    Integer.parseInt(((JTextField)(attributes.get(4).component())).getText())
                            ),
                            (Dog.DogSize) ((JComboBox<Dog.DogSize>)(attributes.get(5).component())).getSelectedItem());
                    break;
                    case 1: animal = new Cat(
                            ((JTextField)(attributes.get(0).component())).getText(),
                            (Cat.HairLength) ((JComboBox<Cat.HairLength>)(attributes.get(1).component())).getSelectedItem());
                    break;
                    case 2: animal = new Rooster(
                            ((JTextField)(attributes.get(0).component())).getText());
                    break;
                }

                animalListPanel.addAnimal(animal);
                myself.dispose();
            });


            add(addAnimalButton);




        }
    }




}
