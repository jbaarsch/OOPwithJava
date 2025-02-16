package StrategyPattern;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jbaarsch
 */
public interface Sorter {
    
    public Comparable[] sort(Comparable[] objects);
    public Comparable[] slowSort(Comparable[] objects, int count);
    
    
    
}
