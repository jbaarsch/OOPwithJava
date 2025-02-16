package StrategyPattern;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.Timer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jbaarsch
 */
public class SorterPanel extends JPanel {
    final int NUM_OF_NUMS = 40;
    final int DELAY = 500;
    BarPanel bars;
    Sorter sortingAlgorithm;
    JButton reSort, randomize;
    JComboBox sortSelector;
    String[] nums = {"Delta", "Alpha", "Gamma", "Beta"};
    Double[] test2Nums;
    Timer t;
    int sortCount;
    Sorter[] sorters = {new SelectionSort(), new InsertionSort(), new QuickSort(), new BubbleSort()};
    
    public SorterPanel()
    {
        t = new Timer(DELAY, new TimerListener());
        sortCount =0;
        
        bars = new BarPanel();
        this.add(bars);
        
        
        double[] testNums = new double[NUM_OF_NUMS];
        test2Nums = new Double[NUM_OF_NUMS];
        for (int i = 0; i< NUM_OF_NUMS; i++)
        {
            testNums[i] = (int)(Math.random()*100);
            test2Nums[i] = testNums[i];
        }
        bars.update(testNums);
       
        
        reSort = new JButton("Re Sort Numbers");
        reSort.addActionListener(new ReDoListener());
        add(reSort);
        
        randomize = new JButton("Randomize Numbers");
        randomize.addActionListener(new RandomListener());
        add(randomize);
        
        String[] sorterNames = {"Selection Sort","Insertion Sort", "Quick Sort", 
            "Bubble Sort"};
        sortSelector = new JComboBox(sorterNames);
        sortSelector.addActionListener(new SortSelectorListener());
        add(sortSelector);
        
        sortingAlgorithm = new InsertionSort();
        
        
        
        
    }
    
    
    
    
    
    private class ReDoListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            sortCount = 1;
            t.start();
            
            
//            Double[] nums2 = (Double[])sortingAlgorithm.sort(test2Nums);
//            double[] testNums = new double[NUM_OF_NUMS];
//            for (int j = 0; j< NUM_OF_NUMS; j++)
//            {
//                testNums[j] = nums2[j];
//            }
//            bars.update(testNums);
            
            
            
//            bars.update();
//            for (String num: nums)
//                System.out.print(num);
//            nums = (String[])sortingAlgorithm.sort(nums);
//            System.out.println("");
//            for (String num: nums)
//                System.out.print(num);
            
        }
        
        
        
    }
    
    private class RandomListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            double[] testNums = new double[NUM_OF_NUMS];
        test2Nums = new Double[NUM_OF_NUMS];
        for (int i = 0; i< NUM_OF_NUMS; i++)
        {
            testNums[i] = (int)(Math.random()*100);
            test2Nums[i] = testNums[i];
        }
        bars.update(testNums);
        }
    }
    
    private class SortSelectorListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            sortingAlgorithm = sorters[sortSelector.getSelectedIndex()];
        }
    }
    
    private class TimerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            Double[] nums2 = (Double[])sortingAlgorithm.slowSort(test2Nums, sortCount);
            double[] testNums = new double[NUM_OF_NUMS];
            for (int j = 0; j< NUM_OF_NUMS; j++)
            {
                testNums[j] = nums2[j];
            }
            bars.update(testNums);
            
            if(sortCount<testNums.length-1)
                sortCount++;
            else
                t.stop();
                
            }
            
        }
    }
    
    
    

