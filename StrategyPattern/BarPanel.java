package StrategyPattern;

import java.awt.*;
import javax.swing.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jbaarsch
 */
public class BarPanel extends JPanel {
    
    private double[] nums = {1};
    private final int BAR_SPACE = 5;  //represents space between bars
    
    public BarPanel()
    {
        setPreferredSize(new Dimension(300, 300));
        setBackground(Color.BLUE);
    }
    
    public void update(double[] nums)
    {
        this.nums = nums;
        revalidate();
        repaint();
    }
    
    private double findMax()
    {
        double max = Double.MIN_VALUE;
        for (double num : nums)
            if (num> max)
                max = num;      
        return max;
    }
    
    public void paintComponent(Graphics page)
    {
        super.paintComponent(page);
        double widthOfBars = (280/nums.length)-BAR_SPACE;
        page.setColor(Color.yellow);
        
        for (int i = 0; i < nums.length; i++)
        {
            page.fillRect((int)((widthOfBars + BAR_SPACE) * i) + BAR_SPACE,
                    (int) (300 - (nums[i]/findMax() * 290)),
                    (int) (widthOfBars), 
                    (int) (nums[i]/findMax()*280));
        }   
    }   
}
