package StrategyPattern;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jbaarsch
 */
public class SelectionSort implements Sorter {
    
    
    public SelectionSort()
    {
        
    }
    
    public Comparable[] sort(Comparable[] objects)
    {
        System.out.println("Selection!");
        for (int i = 0; i < objects.length; i++)
        {
            Comparable lowestItem = objects[i];
            for (int j = i; j < objects.length; j++)
            {
                if (lowestItem.compareTo(objects[j]) > 0)
                {   
                    Comparable temp = lowestItem;
                
                    lowestItem = objects[j];
                    objects[j]=temp;
                    
                }
                objects[i] = lowestItem;
            }
            
            
        }
        
        return objects;
    }
    
    public Comparable[] slowSort(Comparable[] objects, int count)
    {
        Comparable lowestItem = objects[count-1];
            for (int j = count-1; j < objects.length; j++)
            {
                if (lowestItem.compareTo(objects[j]) > 0)
                {   
                    Comparable temp = lowestItem;
                
                    lowestItem = objects[j];
                    objects[j]=temp;
                    
                }
                objects[count-1] = lowestItem;
            }
        
            
            return objects;
        
        
    }
    
}
