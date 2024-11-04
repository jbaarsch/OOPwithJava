package StrategyPattern;

import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jbaarsch
 */
public class QuickSort implements Sorter {
    
    BarPanel graph;
    int startPivot, endPivot, internalCount;
    ArrayList<Integer> pivots;
    public QuickSort()
    {
        pivots = new ArrayList();
    }
    
    
    
    
    public Comparable[] sort(Comparable[] objects)
    {
        
        System.out.println("Quick!");
       ArrayList<Comparable> list = new ArrayList();
       for (Comparable o : objects)
           list.add(o);
       
       list  = sortList(list); 
        
        for (int i = 0; i < objects.length; i++)
        {
            objects[i]=list.get(i);
        }
        
        
        
        return objects;
    }
    
    private ArrayList<Comparable> sortList(ArrayList<Comparable> objects)
    {
        if (objects.size()<=1)
            return objects;
        else
        {
            Comparable pivot = findPivot(objects);
            objects.remove(pivot);
            ArrayList<Comparable> lower = new ArrayList();
            ArrayList<Comparable> upper = new ArrayList();
            //System.out.println(pivot.getClass().getName());
            for (Comparable object: objects)
            {
                if ((pivot.compareTo(object))<=0)
                    upper.add(object);
                else
                    lower.add(object);
            }
            
            lower = sortList(lower);
            upper = sortList(upper);
            
            ArrayList<Comparable> bigList = new ArrayList();
            for (Comparable o : lower)
                bigList.add(o);
            bigList.add(pivot);
            for (Comparable o : upper)
                bigList.add(o);
            
            return bigList;
            
          
        }
        
    }
    
    
    private Comparable findPivot(ArrayList<Comparable> objects)
    {
        return objects.get((int)(Math.random()*objects.size()));
    }
    
//   
    
    public void sortPivots()
    {
        
        for (int i = 0; i < pivots.size(); i++)
       {
           int min = Integer.MAX_VALUE;
           int index = 0;
           for (int j = i; j < pivots.size();j++)
               if(min > pivots.get(j))
               {    
                   min = pivots.get(j);
                   index = j;
               }
           pivots.add(i, pivots.remove(index));
       }
 
        
    }
    
    private int getDistanceBetweenPivots(int pivot1, int pivot2)
    {
        return pivot2 - pivot1;
    }
    
    private ArrayList<Comparable> sortOnOnePivot(ArrayList<Comparable> objects, Comparable pivot)
    {
            ArrayList<Comparable> lower = new ArrayList();
            ArrayList<Comparable> upper = new ArrayList();
            //System.out.println(pivot.getClass().getName());
            for (Comparable object: objects)
            {
                if ((pivot.compareTo(object))<=0)
                    upper.add(object);
                else
                    lower.add(object);
            }
            
            System.out.println(lower);
            System.out.println(pivot);
            System.out.println(upper);
            
            ArrayList<Comparable> bigList = new ArrayList();
            for (Comparable o : lower)
                bigList.add(o);
            bigList.add(pivot);
            pivots.add(lower.size());
            for (Comparable o : upper)
                bigList.add(o);
            
            return bigList;
    }
    
    private boolean needAnotherSwitch(int listSize)
    {
        boolean goAgain = false;
        if (pivots.get(0) >= 2)
            goAgain = true;
        for (int i = 0; i < pivots.size() - 1; i ++)
            if (pivots.get(i +1)-pivots.get(i) >= 2)
            {
                startPivot = pivots.get(i);
                endPivot = pivots.get(i+1);
                goAgain = true;
            }
        if (!goAgain && listSize - pivots.get(pivots.size()-1) >= 3)
        {
            startPivot = pivots.get(pivots.size()-1);
            endPivot = listSize;
            goAgain = true;
        }
        return goAgain;
        
    }
    
    private Comparable findPivotSlowly(ArrayList<Comparable> objects, int step)
    {
        if (step >= pivots.size())
            pivots.add((int)(Math.random()*objects.size()));
        return objects.get(pivots.get(step));
        
       
    }
    
    private ArrayList<Comparable> sortListSlowly(ArrayList<Comparable> objects, int count, int step)
    {
        if (objects.size()<=1 || count == step)
            return objects;
        else
        {   
            Comparable pivot = findPivot(objects);
            objects.remove(pivot);
            ArrayList<Comparable> lower = new ArrayList();
            ArrayList<Comparable> upper = new ArrayList();
            //System.out.println(pivot.getClass().getName());
            for (Comparable object: objects)
            {
                if ((pivot.compareTo(object))<=0)
                    upper.add(object);
                else
                    lower.add(object);
            }
            step++;
            lower = sortListSlowly(lower, count, step);
            upper = sortListSlowly(upper, count, step);
            
            ArrayList<Comparable> bigList = new ArrayList();
            for (Comparable o : lower)
                bigList.add(o);
            bigList.add(pivot);
            for (Comparable o : upper)
                bigList.add(o);
            
            return bigList;
            
          
        }
        
    }
     
    
    
    public Comparable[] slowSort(Comparable[] objects, int count)
    {
        int step = 0;
       ArrayList<Comparable> list = new ArrayList();
       for (Comparable o : objects)
           list.add(o);
       list  = sortListSlowly(list, count, step ); 
        
        for (int i = 0; i < objects.length; i++)
        {
            objects[i]=list.get(i);
        }
//       
//       int pivotCount = 0;
//        if (pivots.size()==0)
//        {
//            Comparable pivot = findPivot(list);
//            list.remove(pivot);
//            System.out.println(pivot);
//            list = sortOnOnePivot(list, pivot);
//            
//            for (int i = 0; i < objects.length; i++)
//            {
//                objects[i]=list.get(i);
//            }
//        }
//        else if (pivots.size() == 1)
//        {
//            ArrayList<Comparable> subset  = new ArrayList();
//            for (int i = 0; i < pivots.get(0); i ++)
//                subset.add(list.get(i));
//            Comparable pivot = findPivot(subset);
//            subset.remove(pivot);
//            subset = sortOnOnePivot(subset, pivot);
//            sortPivots();
//            for (int i = 0; i < objects.length; i++)
//            {
//                if (i < pivots.get(0))
//                    objects[i]=subset.get(i);
//                else
//                    objects[i]= list.get(i);
//            }
//            
//        }
//        else
////            while (!(getDistanceBetweenPivots(pivots.get(pivotCount), pivots.get(pivotCount+1)) > 1) 
////                                            && pivotCount < pivots.size()-1)
////                pivotCount++;
//        if (needAnotherSwitch(objects.length))
//        {
//            ArrayList<Comparable> subset = new ArrayList();
//            
//            
//            for (int i = startPivot + 1; i < endPivot; i++)
//                subset.add(list.get(i));
//            
//            Comparable pivot = findPivot(subset);
//            subset.remove(pivot);
//            subset = sortOnOnePivot(subset, pivot);
//            sortPivots();
//            
//            for (int i = 0; i < objects.length; i++)
//            {
//                if (i <= startPivot)
//                    objects[i] = list.get(i);
//                else if (i > startPivot && i < endPivot)
//                    objects[i]=subset.get(i - (startPivot + 1));
//                else
//                    objects[i]= list.get(i);
//            }
//            
//        }  
//            
////        else    
////        {
////            
//        while (!(getDistanceBetweenPivots(pivots.get(pivotCount), pivots.get(pivotCount+1)) > 1) 
//                && pivotCount < pivots.size()-1)
//            pivotCount++;
//        if (pivotCount < pivots.size()-1)
//        {
//            ArrayList<Comparable> unChangingLow = new ArrayList(),
//            unChangingHigh = new ArrayList(), 
//            changing = new ArrayList(), lower = new ArrayList(), upper = new ArrayList();
//        
//            for (int i = 0; i < objects.length; i ++)
//            {
//                if (i <= pivots.get(pivotCount))
//                    unChangingLow.add(objects[i]);
//                else if (i >= pivots.get(pivotCount+1))
//                    unChangingHigh.add(objects[i]);
//                else 
//                    changing.add(objects[i]);
//            }
//
//            System.out.println(unChangingLow);
//            System.out.println(unChangingHigh);
//            System.out.println(changing);
//            Comparable pivot = findPivot(changing);
//
//            for (Comparable object: objects)
//                {
//                    if ((pivot.compareTo(object))<=0)
//                        upper.add(object);
//                    else
//                        lower.add(object);
//                }
//
//            pivots.add(pivots.get(pivotCount)+lower.size());
//            int start, end;
//            
//            System.out.println(objects.length + "\t" + unChangingLow.size()
//            + "\t" + lower.size()+ "\t" + upper.size()+ "\t" + unChangingHigh.size());
//            
//            ArrayList<Comparable> bigList = new ArrayList();
//            
//            for(Comparable o: unChangingLow)
//                bigList.add(o);
//            
//                            //
//            for(Comparable o: lower)
//                bigList.add(o);
//            
//            bigList.add(pivot);
//            
//            
//                                //
//            for(Comparable o: upper)
//                bigList.add(o);
//            for(Comparable o: unChangingHigh)
//                bigList.add(o);
//
//            sortPivots();
//            
//            for (int i = 0; i< objects.length; i++)
//                objects[i] = bigList.get(i);
//            
//        }
//        }
//        
//        
        return objects;
    }
}

