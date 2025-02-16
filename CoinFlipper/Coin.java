package CoinFlipper;

import javax.swing.*;

public class Coin {

    private boolean isHeads;

    public Coin() {
        flip();
    }

    public void flip() {
        isHeads = ((int)(Math.random() * 2)) == 0;
    }

    public boolean isHeads() {
        return isHeads;
    }

    public Icon getIcon(){
        ImageIcon icon;
        if (isHeads)
            icon = new ImageIcon("images/heads.png");
        else
            icon = new ImageIcon("images/tails.png");

        return icon;
    }

}
