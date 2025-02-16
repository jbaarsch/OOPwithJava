package StrategyPattern;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jbaarsch
 */
public class BubbleSort implements Sorter {
    
    BarPanel graph;
    
    public Comparable[] sort(Comparable[] objects)
    {
        System.out.println("Bubble, Bubble!");
        boolean keepGoing = true;
        while (keepGoing)
        {
            keepGoing = false;
            for (int i = 0; i < objects.length - 1; i++)
            {
                if (objects[i].compareTo(objects[i+1]) > 0)
                {
                    keepGoing = true;
                    Comparable temp = objects[i+1];
                    objects[i+1] = objects[i];
                    objects[i] = temp;
                }
            }
            
            
        }
        
        return objects;
    }
    
    public Comparable[] slowSort(Comparable[] objects, int count)
    {
        for (int i = 0; i < objects.length - 1; i++)
            {
                if (objects[i].compareTo(objects[i+1]) > 0)
                {
                    //keepGoing = true;
                    Comparable temp = objects[i+1];
                    objects[i+1] = objects[i];
                    objects[i] = temp;
                }
            }
          return objects;      
                
    }
}
