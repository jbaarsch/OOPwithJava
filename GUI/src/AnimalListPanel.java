import Interfaces.Animal;
import Interfaces.Dog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;


public class AnimalListPanel extends JPanel{

    ArrayList<Animal> animals;
    JPanel controlPanel;
    JPanel displayPanel;
    JComboBox<String> animalComboBox;
    final String[] SORT_OPTIONS = {"ALPHABETICAL", "REVERSE ALPHABETICAL"};
    final String[] DOG_NAMES = {"Fido", "Spot", "Lassie", "Bud", "Snoopy"};
    final String[] FILTERS = {"S-Dogs", "Long Names", "4-Letter Words"};
    JButton addAnimalButton;
    ArrayList<JCheckBox> filters;

    public AnimalListPanel() {
        setPreferredSize(new Dimension(750, 1000));
        setBackground(Color.BLACK);
        animals = new ArrayList<>();

        //******* Control Panel
        controlPanel = new JPanel();
        controlPanel.setPreferredSize(new Dimension(700, 300));

        //******* Add Animal Button -------SIMPLE VERSION------
        addAnimalButton = new JButton("Add Animal");
        addAnimalButton.setFont(new Font("Arial", Font.BOLD, 30));
        addAnimalButton.addActionListener(e -> {
            addAnimal(new Dog(DOG_NAMES[animals.size() % DOG_NAMES.length]));
            });
        controlPanel.add(addAnimalButton);

        //******** JComboBox Demo--for Sorting
        animalComboBox = new JComboBox(SORT_OPTIONS);
        animalComboBox.setFont(new Font("Arial", Font.BOLD, 30));
        animalComboBox.addActionListener(e -> {
            if (animalComboBox.getSelectedItem().equals(SORT_OPTIONS[0]))
                Collections.sort(animals);
            if (animalComboBox.getSelectedItem().equals(SORT_OPTIONS[1]))
                animals.sort((a1, a2) -> a1.getName().compareToIgnoreCase(a2.getName()) * -1);
            updateDisplay();
        });
        controlPanel.add(animalComboBox);

        //******** JCheckBox demo  Used for filtering here.
        // instantiate the list--use a list so it is easier to manage
        filters = new ArrayList<>();
        // initialize individual Checkboxes and add to ArrayList
        for (String filter : FILTERS) {
            JCheckBox box = new JCheckBox(filter);
            box.setFont(new Font("Arial", Font.BOLD, 30));
            box.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    updateDisplay();
                }
            });
            filters.add(box);
        }
        // Add each checkbox to the controlPanel
        for (JCheckBox filter : filters)
            controlPanel.add(filter);
        add(controlPanel);

        // The DisplayPanel just displays the Animals.
        displayPanel = new JPanel();
        displayPanel.setPreferredSize(new Dimension(700, 650));

        add(displayPanel);
    }

    // Adds an animal to the animals array and calls updateDisplay
    public void addAnimal(Animal animal) {
        animals.add(animal);
        updateDisplay();
    }

    // checks the animal against all the filters and returns true if any apply to the animal (This design could be
    // improved.  I don't like how the filters are hard-coded into the implementation here.  I think they should
    // be more modular.)
    public boolean isFiltered(Animal animal)  {
        for (JCheckBox filter : filters) {
            if (filter.isSelected())
                switch(filter.getText()) {
                    case "S-Dogs":
                        if( animal.getName().startsWith("S") && animal instanceof Dog)
                            return true;
                        break;
                    case "Long Names":
                        if (animal.getName().length() >= 6)
                            return true;
                        break;
                    case "4-Letter Words":
                        if (animal.getName().length() == 4)
                            return true;
                }
        }
        return false;
    }

    // Just adds all the animals to the display panel unless they are filtered.
    public void updateDisplay() {
        displayPanel.removeAll();
        for (Animal animal : animals) {
            if (!isFiltered(animal))
                displayPanel.add(new AnimalPanel(animal));
        }
        revalidate();
        repaint();
    }
}
