package StrategyPattern;

import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jbaarsch
 */
public class Tester {
    
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sorting");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(new SorterPanel());
        frame.pack();
        frame.setVisible(true);
        
    }
    
    
    
}
