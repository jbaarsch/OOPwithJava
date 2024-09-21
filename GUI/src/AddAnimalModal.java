import Interfaces.Animal;
import Interfaces.Cat;
import Interfaces.Dog;
import Interfaces.Rooster;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddAnimalModal extends JFrame {

    private AnimalListPanel animalListPanel;  // This is the listPanel that made this modal
    AddAnimalModal modal;                     // self reference for use in inner classes
    record Attribute(String name, JComponent value){}  // record for associating names with JComponents
    ArrayList<Attribute> attributes;           // will vary depending on the animal
    JPanel infoCollectorPanel;                  // Holds the attribute components
    JComboBox<String> animalTypeComboBox;       // Chooses which animal to create

    // passes the list of strings into an abstract List, which is then used to build a concrete ArrayList.
    // Represents the different types of Animals I want to create.
    public static final String[] animalTypes =  {"Dog", "Rooster", "Cat"};

    // Constructor for the modal: Creates a JFrame and adds content to it.
    public AddAnimalModal(AnimalListPanel animalListPanel) {
        modal = this;                              // Needed so that dispose can be in action Listener.
        this.animalListPanel = animalListPanel;    // Need so Modal can send new Animal back to Animal List.

        this.setTitle("Add Animal");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().add(addAnimalPanel());
        this.pack();
        this.setVisible(true);

    }

    // Creates the panel that will hold all the components in this modal.
    // Should only run once when this Modal is created.
    private JPanel addAnimalPanel() {

        JPanel panel = new JPanel();
        attributes = new ArrayList<>();

        infoCollectorPanel = new JPanel();
        infoCollectorPanel.setPreferredSize(new Dimension(600, 400));
        infoCollectorPanel.setBackground(Color.magenta);

        animalTypeComboBox = new JComboBox<String>(animalTypes);
        animalTypeComboBox.addActionListener(getAnimalChooser());

        panel.add(animalTypeComboBox);
        panel.add(infoCollectorPanel);

        JButton addAnimalButton = new JButton("Submit");
        addAnimalButton.addActionListener(getAnimalCreator());

        panel.setPreferredSize(new Dimension(500, 500));
        panel.add(addAnimalButton);

        return panel;
    }

    // This returns an ActionListener that adds the appropriate fields to the infoCollectorPanel depending on which
    // Animal is selected from the AnimalTypeComboBox
    // This is separate for readability
    private ActionListener getAnimalChooser() {
        return e -> {
            attributes.clear();
            infoCollectorPanel.removeAll();
            switch (animalTypeComboBox.getSelectedIndex()) {
                case 0: {
                    attributes.add(new Attribute("Name", new JTextField(10)));
                    attributes.add(new Attribute("Age", new JTextField(10)));
                    attributes.add(new Attribute("Color", new JColorChooser(Color.WHITE)));
                    attributes.add(new Attribute("Size", new JComboBox<Dog.DogSize>(Dog.DogSize.values())));
                    break;
                }
                case 1: {
                    attributes.add(new Attribute("Name", new JTextField(10)));
                    break;
                }
                case 2: {
                    attributes.add(new Attribute("Name", new JTextField(10)));
                    attributes.add(new Attribute("Hair Length", new JComboBox<Cat.HairLength>(Cat.HairLength.values())));
                    break;
                }
            }
            attributes.forEach(attr -> {
                attr.value.setFont(Palette.getDisplayFont());
                JLabel label = new JLabel(attr.name);
                label.setFont(Palette.getDisplayFont());
                infoCollectorPanel.add(label);
                infoCollectorPanel.add(attr.value);
            });
            infoCollectorPanel.revalidate();
            infoCollectorPanel.repaint();
        };
    }


    // This function returns an ActionLister that creates an animal based on the fields in the InfoCollection Panel
    // It calls the appropriate constructor based on the AnimalTypeComboBox.
    // It then disposes of the creator modal.
    // This is separate for readability
    private ActionListener getAnimalCreator() {
        return e -> {
            Animal newAnimal = new Dog("Error");   // need to initialize abstract Animal Variable
            switch (animalTypeComboBox.getSelectedIndex()) {
                case 0: {
                    JComboBox<Dog.DogSize> sizeChooser = (JComboBox<Dog.DogSize>) (attributes.get(3).value);
                    newAnimal = new Dog(getInput(attributes.get(0).value),
                            Integer.parseInt(getInput(attributes.get(1).value)),
                            ((JColorChooser) (attributes.get(2).value)).getColor(),
                            sizeChooser.getItemAt(sizeChooser.getSelectedIndex()));
                    break;
                }
                case 1: {
                    newAnimal = new Rooster(getInput(attributes.get(0).value));
                    break;
                }
                case 2: {
                    JComboBox<Cat.HairLength> hairChooser = (JComboBox<Cat.HairLength>) (attributes.get(1).value);
                    newAnimal = new Cat(getInput(attributes.get(0).value),
                            hairChooser.getItemAt(hairChooser.getSelectedIndex())
                    );
                    break;
                }
            }
            animalListPanel.addAnimal(newAnimal);
            modal.dispose();
        };
    }

    //  This just helps get Text values from generic Components.
    private String getInput (JComponent c) {
        if (c instanceof JTextComponent) {
            return ((JTextComponent) c).getText();
        }
        return "";
    }

}








