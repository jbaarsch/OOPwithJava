package StrategyPattern;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jbaarsch
 */
public class InsertionSort implements Sorter {
    
    
    
    
    public Comparable[] sort(Comparable[] objects)
    {
        System.out.println("Insertion!");
       for (int i = 1; i < objects.length; i++)
       {
           Comparable homelessObject = objects[i];
           int position = i;
           while(position > 0 && homelessObject.compareTo(objects[position-1])<0)
           {
               objects[position] = objects[position-1];
               position--;
           }
          
           objects[position]  = homelessObject;
       }
 
        return objects;
    }
    
    public Comparable[] slowSort(Comparable[] objects, int count)
    {
        
        Comparable homelessObject = objects[count];
        int position = count;
           while(position > 0 && homelessObject.compareTo(objects[position-1])<0)
           {
               objects[position] = objects[position-1];
               position--;
           }
          
           objects[position]  = homelessObject;
           
           return objects;
        
        
    }
}
