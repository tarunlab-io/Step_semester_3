package session_9.class_problems;

import java.util.Scanner;

public class M2_WeeklyStaffPay {

    static abstract class Staff {

        protected String name;

        Staff(String name) {
            this.name = name;
        }

        abstract double calculatePay();
    }

    static class FullTimeStaff extends Staff {

        private double weeklySalary;

        FullTimeStaff(String name, double weeklySalary) {
            super(name);
            this.weeklySalary = weeklySalary;
        }

        @Override
        double calculatePay() {
            return weeklySalary;
        }
    }

    static class HourlyStaff extends Staff {

        private double hours;
        private double rate;

        HourlyStaff(String name, double hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        @Override
        double calculatePay() {

            if (hours <= 40) {
                return hours * rate;
            }

            double regularPay = 40 * rate;
            double overtimeHours = hours - 40;
            double overtimePay = overtimeHours * rate * 1.5;

            return regularPay + overtimePay;
        }
    }

    static class Intern extends Staff {

        private double stipend;

        Intern(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        @Override
        double calculatePay() {
            return stipend;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Staff[] staff = new Staff[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            if (type.equals("FULLTIME")) {

                double salary = sc.nextDouble();

                staff[i] = new FullTimeStaff(
                    name,
                    salary
                );

            } else if (type.equals("HOURLY")) {

                double hours = sc.nextDouble();
                double rate = sc.nextDouble();

                staff[i] = new HourlyStaff(
                    name,
                    hours,
                    rate
                );

            } else {

                double stipend = sc.nextDouble();

                staff[i] = new Intern(
                    name,
                    stipend
                );
            }
        }

        double totalPayroll = 0;

        for (Staff person : staff) {

            double pay = person.calculatePay();

            System.out.printf(
                "%s: %.2f%n",
                person.name,
                pay
            );

            totalPayroll += pay;
        }

        System.out.printf(
            "Total Payroll: %.2f%n",
            totalPayroll
        );
    }
}