package de.turtle.lib;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Ein Panel, das lediglich aus einem Bild besteht.
 */
class ImagePanel extends JPanel
{
    private final BufferedImage _image;

    /**
     * Initialisiert ein neues ImagePanel mit dem angegebenen Bild.
     */
    public ImagePanel(BufferedImage image)
    {
        super(null);
        _image = image;
        setPreferredSize(new Dimension(_image.getWidth(), _image.getHeight()));
    }

    /**
     * Zeichnet das ImagePanel.
     */
    public void paintComponent(Graphics g)
    {
        g.drawImage(_image, 0, 0, null);
    }
}
