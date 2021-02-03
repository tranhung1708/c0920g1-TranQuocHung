package session_4.BaiTap;

import java.util.Scanner;

public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        return this.b * this.b - 4 * (this.a * this.c);
    }

    public double getRoot1() {
        return (-b + Math.pow(this.getDiscriminant(), 0.5)) / (2 * a);
    }

    public double getRoot2() {
        return (-b - Math.pow(this.getDiscriminant(), 0.5)) / (2 * a);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextInt();
        double b = scanner.nextInt();
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        if (quadraticEquation.getDiscriminant() > 0) {
            System.out.println("a: " + quadraticEquation.getA() + "," + "b: " + quadraticEquation.getB() + "," + "c: " + quadraticEquation.getC() + "." + "phuong trinh co hai nghiem " + quadraticEquation.getRoot1() + "," + quadraticEquation.getRoot2());
        } else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("phuong trinh co mot nghiem " + quadraticEquation.getRoot1());
        } else {
            System.out.println("phuong trinh vo nghiem");
        }
    }
}
