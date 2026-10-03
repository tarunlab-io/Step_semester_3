package session_9.class_problems;

import java.util.Scanner;

public class M3_LibraryLateFineCounter {

    static abstract class LibraryItem {

        protected String title;
        protected int daysLate;

        LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        abstract double calculateFine();
    }

    static class Book extends LibraryItem {

        Book(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        double calculateFine() {
            return daysLate * 2;
        }
    }

    static class DVD extends LibraryItem {

        DVD(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        double calculateFine() {
            return Math.min(daysLate * 5, 50);
        }
    }

    static class Magazine extends LibraryItem {

        Magazine(String title, int daysLate) {
            super(title, daysLate);
        }

        @Override
        double calculateFine() {
            return daysLate;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();

            if (type.equals("BOOK")) {

                items[i] = new Book(
                    title,
                    daysLate
                );

            } else if (type.equals("DVD")) {

                items[i] = new DVD(
                    title,
                    daysLate
                );

            } else {

                items[i] = new Magazine(
                    title,
                    daysLate
                );
            }
        }

        double totalFines = 0;

        for (LibraryItem item : items) {

            double fine = item.calculateFine();

            System.out.printf(
                "%s: %.2f%n",
                item.title,
                fine
            );

            totalFines += fine;
        }

        System.out.printf(
            "Total Fines: %.2f%n",
            totalFines
        );
    }
}
