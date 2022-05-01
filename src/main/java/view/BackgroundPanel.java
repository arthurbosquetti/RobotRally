package view;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel
{
    protected Image bgImage;
    public BackgroundPanel(Image image)
    {
        super(true);
        bgImage = image;
        setOpaque(false);
    }
    public void paint(Graphics g)
    {
        g.drawImage(bgImage, 0 ,0 ,this);
        super.paint(g);
    }
}
