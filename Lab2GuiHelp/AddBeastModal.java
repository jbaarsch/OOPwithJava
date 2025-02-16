package Lab2GuiHelp;

import Interfaces.Animal;
import Interfaces.Cat;
import Interfaces.Dog;
import Interfaces.Rooster;

import javax.swing.*;
import java.awt.*;

public class AddBeastModal extends JFrame {

    private AnimalListPanel animalListPanel;
    private JButton addAnimalButton;
    private AddBeastModal myself;
    private String[] animals = {"Dog", "Cat", "Rooster"};
    private JComboBox<String> animalSelector;
    private JPanel infoCollectionPanel;


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


            animalSelector = new JComboBox<>(animals);
            //animalSelector.addActionListener( e -> {

            //});
            add(animalSelector);


            infoCollectionPanel = new JPanel();
            infoCollectionPanel.setBackground(Color.WHITE);
            infoCollectionPanel.setPreferredSize(new Dimension(480, 400));
            add(infoCollectionPanel);

            addAnimalButton = new JButton("Add Animal");
            addAnimalButton.addActionListener(e -> {
                Animal animal = new Dog();
                switch(animalSelector.getSelectedIndex()) {
                    case 0: animal = new Dog(); break;
                    case 1: animal = new Cat(); break;
                    case 2: animal = new Rooster(); break;
                }

                animalListPanel.addAnimal(animal);
                myself.dispose();
            });


            add(addAnimalButton);




        }
    }


}
