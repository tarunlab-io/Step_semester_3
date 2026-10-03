package session_9.class_problems;

import java.util.Scanner;

public class M4_ElectricityConnectionBilling {

    static abstract class Connection {

        protected int units;

        Connection(int units) {
            this.units = units;
        }

        abstract double calculateBill();

        abstract String getType();
    }

    static class Home extends Connection {

        Home(int units) {
            super(units);
        }

        @Override
        double calculateBill() {

            if (units <= 100) {
                return units * 5;
            }

            return (100 * 5) + ((units - 100) * 7);
        }

        @Override
        String getType() {
            return "HOME";
        }
    }

    static class Shop extends Connection {

        Shop(int units) {
            super(units);
        }

        @Override
        double calculateBill() {
            return (units * 8) + 100;
        }

        @Override
        String getType() {
            return "SHOP";
        }
    }

    static class Factory extends Connection {

        Factory(int units) {
            super(units);
        }

        @Override
        double calculateBill() {
            return Math.max(units * 6, 1000);
        }

        @Override
        String getType() {
            return "FACTORY";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Connection[] connections = new Connection[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int units = sc.nextInt();

            if (type.equals("HOME")) {

                connections[i] = new Home(units);

            } else if (type.equals("SHOP")) {

                connections[i] = new Shop(units);

            } else {

                connections[i] = new Factory(units);
            }
        }

        double total = 0;

        for (Connection connection : connections) {

            double bill = connection.calculateBill();

            System.out.printf(
                "%s: %.2f%n",
                connection.getType(),
                bill
            );

            total += bill;
        }

        System.out.printf(
            "Total: %.2f%n",
            total
        );
    }
}
