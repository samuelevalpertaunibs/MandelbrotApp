package it.unibs.pajc;

import javax.swing.*;
import java.awt.*;

public class PnlMandelbrot extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int resolution = 100;
        Mandelbrot m = new Mandelbrot();
        m.eval(new Complex(-2, -1), new Complex(1, 1), resolution);
        double data[][] = m.getData();

        int dx = getWidth() / resolution;
        int dy = getHeight() / resolution;

        for (int i = 0; i < resolution; i++) {
            for (int j = 0; j < resolution; j++) {
                float intensity = (float) data[i][j]; // 0 to 1
                g.setColor(new Color(intensity, intensity, intensity));
                g.fillRect(dx * j, dy * i, dx, dy);
            }
        }

    }
}
