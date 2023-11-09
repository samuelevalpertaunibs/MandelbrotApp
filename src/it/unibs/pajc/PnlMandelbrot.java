package it.unibs.pajc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class PnlMandelbrot extends JPanel implements MouseListener {

    public PnlMandelbrot() {
        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int resolution = 200;
        Mandelbrot m = new Mandelbrot();
        m.eval(new Complex(viewport.getMinX(), viewport.getMinY()), new Complex(viewport.getMaxX(), viewport.getMaxY()), resolution);
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

    // Viewport handling
    protected Rectangle2D viewport = new Rectangle2D.Double(-2., -1., 3., 2.);

    public void setViewport (Rectangle2D newViewport) {
        viewport = newViewport;
        repaint();
    }

    public void zoomIn(Point2D.Double p, double zoom) {
        double finalWidth = viewport.getWidth() / zoom;
        double finalHeight = viewport.getHeight() / zoom;

        double rx = (p.x - viewport.getMinX()) / viewport.getWidth();
        double ry = (p.y - viewport.getMinY()) / viewport.getHeight();

        Rectangle2D newViewport = new Rectangle2D.Double(p.x - finalWidth * rx, p.y - finalHeight * ry, finalWidth, finalHeight);
        setViewport(newViewport);
    }

    public void zoomOut(Point2D.Double p, double zoom) {
        zoomIn(p, 1/zoom);
    }

    protected Point2D.Double getViewportPoint (Point pixel) {
        double x = viewport.getWidth() / getWidth() * pixel.x + viewport.getMinX();
        double y = -viewport.getHeight() / getHeight() * pixel.y + viewport.getMaxY();
        return new Point2D.Double(x, y);
    }

    protected Point getPixelPoint(Point2D viewportPoint) {
        int x = (int) ((viewportPoint.getX() - viewport.getMinX()) * getWidth() / viewport.getWidth());
        int y = (int) ((viewport.getMaxY() - viewportPoint.getY()) * getHeight() / viewport.getHeight());
        return new Point(x, y);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point2D.Double p = getViewportPoint(e.getPoint());
        if (e.isShiftDown())
            zoomOut(p, 1.1);
        else
            zoomIn(p, 1.1);

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
