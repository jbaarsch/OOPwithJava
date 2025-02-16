package Lab2GuiHelp;

import Interfaces.Animal;
import Interfaces.AnimalFilter;
import Interfaces.Dog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.util.function.Predicate;


public class AnimalListPanel extends JPanel{

    ArrayList<Animal> animals;
    JPanel controlPanel;
    JPanel displayPanel;
    JComboBox<String> animalComboBox;
    final String[] SORT_OPTIONS = {"ALPHABETICAL", "REVERSE ALPHABETICAL"};
    final String[] DOG_NAMES = {"Fido", "Spot", "Lassie", "Bud", "Snoopy"};
    JButton addAnimalButton;
    Map<String, Predicate<Animal>> filters;
    ArrayList<JCheckBox> filterBoxes;


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

        /*
        addAnimalButton.addActionListener(e -> {
            addAnimal(new Dog(DOG_NAMES[animals.size() % DOG_NAMES.length]));
            });

        */
        addAnimalButton.addActionListener(e -> {
            new AddBeastModal(this);
        });

        controlPanel.add(addAnimalButton);

        /*
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
        // instantiate the list--use a Map so it is easy to connect the title of the filter to the predicate function.
        filters = new HashMap<>();
        // Adding the AnimalFilters pre-mades to the list--could add more.
        filters.putAll(AnimalFilter.getAnimalFilters());
        filterBoxes = new ArrayList<>();
        // initialize individual Checkboxes and add to ArrayList
        // for (String filter : FILTERS) {
        for ( String filter : filters.keySet()){
            JCheckBox box = new JCheckBox(filter);
            box.setFont(new Font("Arial", Font.BOLD, 30));
            box.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    updateDisplay();
                }
            });
            filterBoxes.add(box);
        }
        // Add each checkbox to the controlPanel
        for (JCheckBox filter : filterBoxes)
            controlPanel.add(filter);
        */

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
        boolean result = false;
        for (JCheckBox filter : filterBoxes)
            if (filter.isSelected()) {
                Predicate<Animal> pred = filters.get(filter.getText());
                if (pred.test(animal))
                    result = true;
            }
        return result;
    }

    // Just adds all the animals to the display panel unless they are filtered.
    public void updateDisplay() {
        displayPanel.removeAll();
        for (Animal animal : animals) {
           // if (!isFiltered(animal))
                displayPanel.add(new AnimalPanel(animal));
        }
        revalidate();
        repaint();
    }


}
