package it.unibs.pajc;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.EventQueue;

public class MandelbrotApp extends JFrame {

    private PnlMandelbrot MainPanel = new PnlMandelbrot();

    public MandelbrotApp() {
        setTitle("Mandelbrot");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        add(MainPanel);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MandelbrotApp frame = new MandelbrotApp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
