package session_9.assignment_problems;

import java.util.Scanner;

public class M2_ParcelShippingDesk {

    interface Insurable {
        double calculateInsurance();
    }

    static abstract class Parcel {
        protected double weight;
        protected double declaredValue;

        Parcel(double weight, double declaredValue) {
            this.weight = weight;
            this.declaredValue = declaredValue;
        }

        abstract double calculateCharge();

        abstract String getType();

        double calculateInsurance() {
            return 0.0;
        }

        double calculateTotal() {
            return calculateCharge() + calculateInsurance();
        }
    }

    static class Standard extends Parcel {
        Standard(double weight, double value) {
            super(weight, value);
        }

        @Override
        double calculateCharge() {
            return 40 + 10 * weight;
        }

        @Override
        String getType() {
            return "STANDARD";
        }
    }

    static class Express extends Parcel implements Insurable {
        Express(double weight, double value) {
            super(weight, value);
        }

        @Override
        double calculateCharge() {
            return 80 + 15 * weight;
        }

        @Override
        public double calculateInsurance() {
            return declaredValue * 0.02;
        }

        @Override
        String getType() {
            return "EXPRESS";
        }
    }

    static class Fragile extends Parcel implements Insurable {
        Fragile(double weight, double value) {
            super(weight, value);
        }

        @Override
        double calculateCharge() {
            return 40 + 10 * weight + 50;
        }

        @Override
        public double calculateInsurance() {
            return declaredValue * 0.02;
        }

        @Override
        String getType() {
            return "FRAGILE";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Parcel[] parcels = new Parcel[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            switch (type) {
                case "STANDARD":
                    parcels[i] = new Standard(weight, value);
                    break;
                case "EXPRESS":
                    parcels[i] = new Express(weight, value);
                    break;
                case "FRAGILE":
                    parcels[i] = new Fragile(weight, value);
                    break;
                default:
                    throw new IllegalArgumentException(
                        "Invalid parcel type: " + type
                    );
            }
        }

        double grandTotal = 0;

        for (Parcel parcel : parcels) {
            double charge = parcel.calculateCharge();
            double insurance = parcel.calculateInsurance();
            double total = parcel.calculateTotal();

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                parcel.getType(),
                charge,
                insurance,
                total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}