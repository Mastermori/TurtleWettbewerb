package de.turtle.lib;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 * Eine Welt, in der sich Turtles bewegen.
 */
public class TurtleWelt {
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    public static final TurtleWelt globaleWelt = new TurtleWelt();

    private final Graphics2D _graphics;
    private final JFrame _frame;

    /**
     * Initialisiert eine neue TurtleWelt.
     */
    public TurtleWelt() {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

        _graphics = image.createGraphics();
        _graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        _graphics.setColor(Color.WHITE);
        _graphics.fillRect(0, 0, WIDTH, HEIGHT);

        JPanel panel = new ImagePanel(image);
        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.getButton() != MouseEvent.BUTTON1) {
                    loescheAlleSpuren();
                }
            }
        });

        _frame = new JFrame("Turtle Graphics - the canvas can be cleared by right-clicking on it");
        _frame.add(panel);
        _frame.pack();
        _frame.setResizable(false);
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setVisible(true);
    }

    /**
     * Loescht alle Spuren, die Turtles bisher hinterlassen haben.
     */
    public void loescheAlleSpuren() {
        _graphics.setColor(new Color(16, 68, 116));
        _graphics.fillRect(0, 0, WIDTH, HEIGHT);
        _frame.repaint();
    }

    /**
     * Faerbt den Frame in einer bestimmten Farbe mit RGB wert
     *
     * @param r der Rotanteil
     * @param g der Gruenanteil
     * @param b der Blauanteil
     */
    public void bildschirmEinfaerben(int r, int g, int b) {
        //Absicherung gegen unzulaessige Werte
        r = r % 256;
        g = g % 256;
        b = b % 256;

        _graphics.setColor(new Color(r, g, b));
        _graphics.fillRect(0, 0, WIDTH, HEIGHT);
        _frame.repaint();
    }

    /**
     * Zeichnet eine farbige Linie von (x1/y1) nach (x2/y2).
     */
    public void zeichneLinie(double x1, double y1, double x2, double y2, Color farbe) {
        _graphics.setColor(farbe);
        _graphics.drawLine((int) (x1 + 0.5), (int) (y1 + 0.5), (int) (x2 + 0.5), (int) (y2 + 0.5));
        _frame.repaint();
    }
}
