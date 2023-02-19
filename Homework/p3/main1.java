package math;

public class Complex {
    private final double real;
    private final double imaginary;

    // Constructor taking real and imaginary part
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Constructor taking only the real part (imaginary defaults to 0)
    public Complex(double real) {
        this(real, 0);
    }

    // Returns a string representation of the Complex number
    // For example, Complex(3, 2) returns the string "3 + 2i"
    // and for Complex(3, -2), the string "3 - 2i"
    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + (-imaginary) + "i";
        }
    }

    // Accessor for the real part
    public double r() {
        return real;
    }

    // Accessor for the imaginary part
    public double i() {
        return imaginary;
    }

    // Adds two Complex numbers, returning a new Complex object
    // Preconditions: w is not null
    // Postconditions: Returns a new Complex object that represents the sum of this and w
    public Complex add(Complex w) {
        return new Complex(real + w.real, imaginary + w.imaginary);
    }

    // Subtracts two Complex numbers, returning a new Complex object
    // Preconditions: w is not null
    // Postconditions: Returns a new Complex object that represents the difference of this and w
    public Complex sub(Complex w) {
        return new Complex(real - w.real, imaginary - w.imaginary);
    }

    // Computes the complex conjugate, returning a new Complex object
    // Postconditions: Returns a new Complex object that represents the complex conjugate of this
    public Complex conj() {
        return new Complex(real, -imaginary);
    }

    // Computes the product of two complex numbers, returning a new Complex object
    // Preconditions: w is not null
    // Postconditions: Returns a new Complex object that represents the product of this and w
    public Complex mult(Complex w) {
        double newReal = real * w.real - imaginary * w.imaginary;
        double newImaginary = real * w.imaginary + imaginary * w.real;
        return new Complex(newReal, newImaginary);
    }

    // Computes the division of two complex numbers, returning a new Complex object
    // Preconditions: w is not null, w is not equal to zero
    // Postconditions: Returns a new Complex object that represents the quotient of this and w
    public Complex div(Complex w) {
        double divisor = w.real * w.real + w.imaginary * w.imaginary;
        double newReal = (real * w.real + imaginary * w.imaginary) / divisor;
        double newImaginary = (imaginary * w.real - real * w.imaginary) / divisor;
        return new Complex(newReal, newImaginary);
    }

    // Compares two Complex numbers and returns true if they are equal
    // Postconditions: Returns true if this and obj represent the same complex number
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Complex)) {
            return false;
        }
        Complex other = (Complex) obj;
        return Double.compare(real, other.real) == 0;


public class Main {
    public static void main(String[] args) {
        // Create some sample Complex objects
        Complex z = new Complex(3, 2);
        Complex w = new Complex(1, -1);

        // Print out the string representation of the Complex objects
        System.out.println("z = " + z);
        System.out.println("w = " + w);

        // Compute and print out the sum of the Complex objects
        Complex sum = z.add(w);
        System.out.println("z + w = " + sum);

        // Compute and print out the difference of the Complex objects
        Complex diff = z.sub(w);
        System.out.println("z - w = " + diff);

        // Compute and print out the product of the Complex objects
        Complex prod = z.mult(w);
        System.out.println("z * w = " + prod);

        // Compute and print out the quotient of the Complex objects
        Complex quot = z.div(w);
        System.out.println("z / w = " + quot);

        // Compute and print out the complex conjugate of z
        Complex conj = z.conj();
        System.out.println("conj(z) = " + conj);

        // Test the equals method
        Complex z2 = new Complex(3, 2);
        System.out.println("z.equals(z2) = " + z.equals(z2));

        // Test the r() and i() methods
        System.out.println("Real part of z: " + z.r());
        System.out.println("Imaginary part of z: " + z.i());
    }
}