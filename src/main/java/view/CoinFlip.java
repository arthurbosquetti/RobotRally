package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CoinFlip extends JFrame implements ActionListener
{
    private JButton button;
    private JPanel panel;
    private JLabel label;
    private ImageIcon coin;
    private ImageIcon heads;
    private ImageIcon tails;
    private int flip;
    private static String pl1, pl2;

    public CoinFlip(String pl1,String pl2)
    {
        this.pl1 = pl1;
        this.pl2 = pl2;
        JFrame frame = new JFrame("Sudden Death");
        frame.setSize(250,300);

        JPanel window = new JPanel();
        frame.add(window, BorderLayout.CENTER);

        coin = new ImageIcon("src/main/resources/coin.jpg");
        heads = new ImageIcon("src/main/resources/heads.jpg");
        tails = new ImageIcon("src/main/resources/tails.jpg");

        window.setPreferredSize(new Dimension (200, 200));
        label = new JLabel();
        label.setIcon(coin);
        window.add(label);

        button = new JButton("Flip");
        button.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        button.addActionListener(this);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event)
    {

        flip = (int) (Math.random() * 2);

        if (flip == 0) {
            label.setIcon(heads);
            EndScreen es = new EndScreen(pl1);
        }
        else {
            label.setIcon(tails);
            EndScreen es = new EndScreen(pl2);
        }
    }
}