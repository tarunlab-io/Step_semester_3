package session_9.class_problems;

import java.util.Scanner;

public class M5_TravelBookingWithCommonFee {

    static abstract class Booking {

        protected double distance;

        private static final double BOOKING_FEE = 50;

        Booking(double distance) {
            this.distance = distance;
        }

        abstract double calculateBaseFare();

        double calculateTotal() {
            return calculateBaseFare() + BOOKING_FEE;
        }

        abstract String getMode();
    }

    static class Bus extends Booking {

        Bus(double distance) {
            super(distance);
        }

        @Override
        double calculateBaseFare() {
            return distance * 2;
        }

        @Override
        String getMode() {
            return "BUS";
        }
    }

    static class Train extends Booking {

        Train(double distance) {
            super(distance);
        }

        @Override
        double calculateBaseFare() {
            return distance * 1.5;
        }

        @Override
        String getMode() {
            return "TRAIN";
        }
    }

    static class Flight extends Booking {

        Flight(double distance) {
            super(distance);
        }

        @Override
        double calculateBaseFare() {
            return 2500 + (distance * 4);
        }

        @Override
        String getMode() {
            return "FLIGHT";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Booking[] bookings = new Booking[n];

        for (int i = 0; i < n; i++) {

            String mode = sc.next();
            double distance = sc.nextDouble();

            if (mode.equals("BUS")) {

                bookings[i] = new Bus(distance);

            } else if (mode.equals("TRAIN")) {

                bookings[i] = new Train(distance);

            } else {

                bookings[i] = new Flight(distance);
            }
        }

        for (Booking booking : bookings) {

            System.out.printf(
                "%s: %.2f%n",
                booking.getMode(),
                booking.calculateTotal()
            );
        }
    }
}