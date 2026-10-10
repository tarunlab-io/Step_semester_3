package session_9.assignment_problems;

import java.util.Scanner;

public class M5_HomeApplianceEnergyReport {

    interface SaverMode {
        double reduceUnits(double normalUnits);
    }

    static abstract class Appliance {
        protected double hours;

        Appliance(double hours) {
            this.hours = hours;
        }

        abstract double getPower();

        abstract String getType();

        double calculateUnits() {
            return getPower() * hours / 1000.0;
        }

        double calculateCost(double units) {
            return units * 8;
        }
    }

    static class Fridge extends Appliance {
        Fridge(double hours) {
            super(hours);
        }

        @Override
        double getPower() {
            return 150;
        }

        @Override
        String getType() {
            return "FRIDGE";
        }
    }

    static class AC extends Appliance implements SaverMode {
        AC(double hours) {
            super(hours);
        }

        @Override
        double getPower() {
            return 1500;
        }

        @Override
        String getType() {
            return "AC";
        }

        @Override
        public double reduceUnits(double normalUnits) {
            return normalUnits * 0.75;
        }
    }

    static class TV extends Appliance {
        TV(double hours) {
            super(hours);
        }

        @Override
        double getPower() {
            return 100;
        }

        @Override
        String getType() {
            return "TV";
        }
    }

    static class Washer extends Appliance implements SaverMode {
        Washer(double hours) {
            super(hours);
        }

        @Override
        double getPower() {
            return 500;
        }

        @Override
        String getType() {
            return "WASHER";
        }

        @Override
        public double reduceUnits(double normalUnits) {
            return normalUnits * 0.75;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Appliance[] appliances = new Appliance[n];
        boolean[] saverRequested = new boolean[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            String mode = "";

            if (sc.hasNextLine()) {
                // Read optional SAVER token on this same input line.
                String remainder = sc.nextLine().trim();
                mode = remainder;
            }

            saverRequested[i] = mode.equals("SAVER");

            switch (type) {
                case "FRIDGE":
                    appliances[i] = new Fridge(hours);
                    break;
                case "AC":
                    appliances[i] = new AC(hours);
                    break;
                case "TV":
                    appliances[i] = new TV(hours);
                    break;
                case "WASHER":
                    appliances[i] = new Washer(hours);
                    break;
                default:
                    throw new IllegalArgumentException(
                        "Invalid appliance: " + type
                    );
            }
        }

        double totalCost = 0;

        for (int i = 0; i < n; i++) {
            Appliance appliance = appliances[i];

            if (saverRequested[i] &&
                !(appliance instanceof SaverMode)) {

                System.out.println(
                    appliance.getType() + ": saver mode not supported"
                );
                continue;
            }

            double units = appliance.calculateUnits();

            if (saverRequested[i]) {
                SaverMode saver = (SaverMode) appliance;
                units = saver.reduceUnits(units);
            }

            double cost = appliance.calculateCost(units);

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                appliance.getType(),
                units,
                cost
            );

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}