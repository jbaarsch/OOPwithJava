package GUI_Swing;

import java.awt.*;
import javax.swing.*;

public class PanelDemo {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Panel Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DemoPanel panel = new DemoPanel();
        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);
    }

    private static class DemoPanel extends JPanel {

        DemoPanel() {
            super();
            // Because DemoPanel extends JPanel, we want to call the JPanel constructor in the first line
            // of our new constructor in order to perform any set-up functions.  This is not strictly necessary,
            // but is here as a demonstration.


            // PLAY WITH PANELS HERE!!!!!!!!!

            // Creating a Main Panel
            // SIZE
            // Just like a frame, we can control the preferred size of a Panel:
            // The sizes of the dimensions are measured in pixels.
            // The most important factors here are that you want to make sure that it will appear nicely on whatever
            // screen you will be displaying it on.
            // Let's make this panel 500 by 500, which is not tiny, but should fit on most screens.
            this.setPreferredSize(new Dimension(500, 500));
            // Note: like CSS, we can make a Sizer class with static functions that return standardized sizes to all
            // the classes in our program so that sizing concerns can all be handled in one place, and they can be
            // consistent across your application.

            // COLOR
            // Also like the JFrame, we want to set the background color of the Panel to improve its appearance.
            // It can also be helpful to set the background color to something unique while developing your GUI,
            // so that you can recognize the panel when you test it.
            this.setBackground(Color.magenta);

            // Nested Panels
            // A JPanel is a container, and its main function is to hold components.
            // You add components to a panel with the .add(Component c) function, but before you can do that, you
            // need to create the component.  We will explore several different Components through this class, but
            // at the moment, all we really have are panels, so we will create and add those.
            // First, let's create a tall black panel that will sit on the left-hand side.
            JPanel subPanelLeft = new JPanel();
            subPanelLeft.setBackground(Color.BLACK);
            subPanelLeft.setPreferredSize(new Dimension(200, 450));

            // Now let's create a tall white panel that will sit on the right-hand side.
            JPanel subPanelRight = new JPanel();
            subPanelRight.setBackground(Color.WHITE);
            subPanelRight.setPreferredSize(new Dimension(200, 450));

            // Next, let's create a short narrow light blue panel to go on the top of the white panel
            JPanel subSubPanelTop = new JPanel();
            subSubPanelTop.setBackground(Color.CYAN);
            subSubPanelTop.setPreferredSize(new Dimension(190, 210));

            // Now, we'll create a short narrow pink panel to go on the bottom of the white panel.
            JPanel subSubPanelBottom = new JPanel();
            subSubPanelBottom.setBackground(Color.PINK);
            subSubPanelBottom.setPreferredSize(new Dimension(190, 210));

            // Components get added to containers according to the Layout Manager.  That's a class we will learn
            // about later.  For now, the default layout manager places components from left to right, and when there
            // is no room to place them horizontally, it places the next component underneath in the "next" row.
            // Each row is then centered.
            // First, let's add the sub-sub-panels to the Right (white) panel.
            subPanelRight.add(subSubPanelTop);
            // The white panel has a preferred width of 200.  Our first panel was 190, so there is not enough room
            // after adding the subSubPanelTop to put the sub-subPanelBottom.  Thus, the bottom panel will be placed
            // in the row underneath the top panel.
            subPanelRight.add(subSubPanelBottom);

            // Now, let's add the left panel and then the right panel.
            // First, we add the left panel.
            this.add(subPanelLeft);
            // then, we add the right panel.  Since components are added from left to right, the right panel
            // will appear next to (and to the right of) the left panel.
            this.add(subPanelRight);

            // Play around with adding the panels in different orders and configurations to see how that affects their
            // appearance on the screen.  Remember: all panels have the .add() function built into them.
            // Also, experiment with the sizes of the panels, to get a sense for how that affects the way they appear.
        }
    }



}


