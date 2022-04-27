package view;

import view.EndScreen;

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
        frame.setSize(300,400);
        createGUI();
        frame.setVisible(true);
    }

    private void createGUI()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        coin = new ImageIcon("src/main/resources/coin.jpg");
        heads = new ImageIcon("src/main/resources/heads.jpg");
        tails = new ImageIcon("src/main/resources/tails.jpg");

        label = new JLabel();
        label.setIcon(coin);
        window.add(label);

        button = new JButton("Flip");
        window.add(button);
        button.addActionListener(this);
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