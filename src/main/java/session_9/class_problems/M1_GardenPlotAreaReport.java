package session_9.class_problems;

import java.util.Scanner;

public class M1_GardenPlotAreaReport {

    static abstract class Plot {

        protected String owner;

        Plot(String owner) {
            this.owner = owner;
        }

        abstract double calculateArea();

        abstract String getShape();
    }

    static class Circle extends Plot {

        private double radius;

        Circle(String owner, double radius) {
            super(owner);
            this.radius = radius;
        }

        @Override
        double calculateArea() {
            return Math.PI * radius * radius;
        }

        @Override
        String getShape() {
            return "CIRCLE";
        }
    }

    static class Rectangle extends Plot {

        private double length;
        private double width;

        Rectangle(String owner, double length, double width) {
            super(owner);
            this.length = length;
            this.width = width;
        }

        @Override
        double calculateArea() {
            return length * width;
        }

        @Override
        String getShape() {
            return "RECTANGLE";
        }
    }

    static class Triangle extends Plot {

        private double base;
        private double height;

        Triangle(String owner, double base, double height) {
            super(owner);
            this.base = base;
            this.height = height;
        }

        @Override
        double calculateArea() {
            return 0.5 * base * height;
        }

        @Override
        String getShape() {
            return "TRIANGLE";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Plot[] plots = new Plot[n];

        for (int i = 0; i < n; i++) {

            String shape = sc.next();
            String owner = sc.next();

            if (shape.equals("CIRCLE")) {

                double radius = sc.nextDouble();

                plots[i] = new Circle(owner, radius);

            } else if (shape.equals("RECTANGLE")) {

                double length = sc.nextDouble();
                double width = sc.nextDouble();

                plots[i] = new Rectangle(owner, length, width);

            } else {

                double base = sc.nextDouble();
                double height = sc.nextDouble();

                plots[i] = new Triangle(owner, base, height);
            }
        }

        double totalArea = 0;

        for (Plot plot : plots) {

            double area = plot.calculateArea();

            System.out.printf(
                "%s (%s): %.2f%n",
                plot.owner,
                plot.getShape(),
                area
            );

            totalArea += area;
        }

        System.out.printf(
            "Total Area: %.2f%n",
            totalArea
        );
    }
}
