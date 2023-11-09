package it.unibs.pajc;

public class Mandelbrot {
    private double [][] data;

    public double[][] getData() {
        return data;
    }

    public void eval(Complex min, Complex max, int resolution) {
        data = new double[resolution][resolution];

        double dreal = Math.abs(min.real - max.real) / resolution;
        double dimaginary = Math.abs(min.imaginary - max.imaginary) / resolution;

        for (int i = 0; i < resolution; i++) {
            for (int j = 0; j < resolution; j++) {
                data[i][j] = fMandelbrot(new Complex(min.real + j * dreal, max.imaginary - i * dimaginary));
            }
        }
    }

    private static double fMandelbrot(Complex c) {
        int maxIteration = 100;
        Complex z = new Complex();
        for (int i = 0; i < maxIteration; i++) {
            z = z.sqr().sum(c);
            if (z.moduleSquared() > 1e5)
                return ((double)maxIteration - i) / maxIteration;
        }
        return 0.;
    }
}
