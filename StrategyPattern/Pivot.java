package StrategyPattern;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Represents a pivot point in the quick sort algorithm--necessary for the slow version of that sort.
 *
 * @author Jon
 */
public class Pivot implements Comparable{
    
    private int indexOfPivot;
    private boolean hasBeenUsed;
    
    public Pivot(int i)
    {
        indexOfPivot = i;
        hasBeenUsed = false;
    }
    
    public int getIndex()
    {
        return indexOfPivot;
    }
    
    public int compareTo(Object otherPivot)
    {
        
        return indexOfPivot-((Pivot)otherPivot).getIndex();
    }

    
    
    
    
    
}
