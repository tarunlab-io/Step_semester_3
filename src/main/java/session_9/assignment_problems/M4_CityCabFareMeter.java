package session_9.assignment_problems;

import java.util.Scanner;

public class M4_CityCabFareMeter {

    interface NightService {
    }

    static abstract class Cab {
        protected double km;

        Cab(double km) {
            this.km = km;
        }

        abstract double getRate();

        abstract String getType();

        double calculateFare(boolean night) {
            double fare = Math.max(km * getRate(), 100);

            if (night) {
                fare *= 1.20;
            }

            return fare;
        }
    }

    static class Mini extends Cab {
        Mini(double km) {
            super(km);
        }

        @Override
        double getRate() {
            return 10;
        }

        @Override
        String getType() {
            return "MINI";
        }
    }

    static class Sedan extends Cab implements NightService {
        Sedan(double km) {
            super(km);
        }

        @Override
        double getRate() {
            return 14;
        }

        @Override
        String getType() {
            return "SEDAN";
        }
    }

    static class SUV extends Cab implements NightService {
        SUV(double km) {
            super(km);
        }

        @Override
        double getRate() {
            return 18;
        }

        @Override
        String getType() {
            return "SUV";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Cab[] cabs = new Cab[n];
        String[] times = new String[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            times[i] = time;

            switch (type) {
                case "MINI":
                    cabs[i] = new Mini(km);
                    break;
                case "SEDAN":
                    cabs[i] = new Sedan(km);
                    break;
                case "SUV":
                    cabs[i] = new SUV(km);
                    break;
                default:
                    throw new IllegalArgumentException(
                        "Invalid cab type: " + type
                    );
            }
        }

        double total = 0;

        for (int i = 0; i < n; i++) {
            Cab cab = cabs[i];
            boolean night = times[i].equals("NIGHT");

            if (night && !(cab instanceof NightService)) {
                System.out.println(
                    cab.getType() + ": night service not available"
                );
                continue;
            }

            double fare = cab.calculateFare(night);

            System.out.printf(
                "%s: %.2f%n",
                cab.getType(),
                fare
            );

            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}