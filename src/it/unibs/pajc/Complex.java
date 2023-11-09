package it.unibs.pajc;

public class Complex {

    double real;
    double imaginary;

    public Complex() {
        this.real = 0;
        this.imaginary = 0;
    }

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex(Complex c) {
        this(c.real, c.imaginary);
    }

    public Complex sum (Complex w) {
        return new Complex(real + w.real, imaginary + w.imaginary);
    }

    public Complex sqr () {
        double realResult = Math.pow(real, 2) - Math.pow(imaginary, 2);
        double imaginaryResult = 2 * realResult * imaginary;
        return new Complex(realResult, imaginaryResult);
    }

    public double moduleSquared () {
        return Math.pow(real, 2) + Math.pow(imaginary, 2);
    }
}
