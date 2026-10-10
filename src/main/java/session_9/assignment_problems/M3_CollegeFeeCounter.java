package session_9.assignment_problems;

import java.util.Scanner;

public class M3_CollegeFeeCounter {

    static abstract class Student {
        protected String name;

        private static final double BUS_FEE = 12000;

        Student(String name) {
            this.name = name;
        }

        abstract double getTuitionFee();

        abstract boolean usesBus();

        double calculateTotalFee() {
            double total = getTuitionFee();

            if (usesBus()) {
                total += BUS_FEE;
            }

            return total;
        }
    }

    static class DayScholar extends Student {
        DayScholar(String name) {
            super(name);
        }

        @Override
        double getTuitionFee() {
            return 40000;
        }

        @Override
        boolean usesBus() {
            return true;
        }
    }

    static class Hosteller extends Student {
        Hosteller(String name) {
            super(name);
        }

        @Override
        double getTuitionFee() {
            return 40000 + 60000;
        }

        @Override
        boolean usesBus() {
            return false;
        }
    }

    static class Scholar extends Student {
        Scholar(String name) {
            super(name);
        }

        @Override
        double getTuitionFee() {
            return 20000;
        }

        @Override
        boolean usesBus() {
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            switch (type) {
                case "DAY_SCHOLAR":
                    students[i] = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    students[i] = new Hosteller(name);
                    break;
                case "SCHOLAR":
                    students[i] = new Scholar(name);
                    break;
                default:
                    throw new IllegalArgumentException(
                        "Invalid student type: " + type
                    );
            }
        }

        double totalCollected = 0;

        for (Student student : students) {
            double fee = student.calculateTotalFee();

            System.out.printf(
                "%s: %.2f%n",
                student.name,
                fee
            );

            totalCollected += fee;
        }

        System.out.printf(
            "Total Collected: %.2f%n",
            totalCollected
        );
    }
}