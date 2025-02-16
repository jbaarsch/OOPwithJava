package CoinFlipper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoinFlipPanel extends JPanel {
    private Coin coin;
    private JButton flipButton;

    private JLabel coinLabel;


    CoinFlipPanel() {
        coin = new Coin();
        flipButton = new JButton("Flip");
        coinLabel = new JLabel(coin.getIcon());

        this.setBackground(Color.BLUE);
        flipButton.setBackground(Color.RED);
        flipButton.setForeground(Color.WHITE);
        flipButton.addActionListener(new FlipListener());

        this.setPreferredSize(
                new Dimension(500, 500));

        this.add(flipButton);
        this.add(coinLabel);

    }

    private class FlipListener
            implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            coin.flip();
            coinLabel.setIcon(coin.getIcon());


        }


    }


}
