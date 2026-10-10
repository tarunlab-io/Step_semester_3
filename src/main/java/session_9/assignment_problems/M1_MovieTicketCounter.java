package session_9.assignment_problems;

import java.util.Scanner;

public class M1_MovieTicketCounter {

    static abstract class Ticket {
        private static final double CONVENIENCE_FEE = 20.0;

        protected int count;

        Ticket(int count) {
            this.count = count;
        }

        abstract double getPrice();

        abstract String getSeatType();

        double calculateAmount() {
            return (getPrice() + CONVENIENCE_FEE) * count;
        }
    }

    static class Regular extends Ticket {
        Regular(int count) {
            super(count);
        }

        @Override
        double getPrice() {
            return 150;
        }

        @Override
        String getSeatType() {
            return "REGULAR";
        }
    }

    static class Premium extends Ticket {
        Premium(int count) {
            super(count);
        }

        @Override
        double getPrice() {
            return 250;
        }

        @Override
        String getSeatType() {
            return "PREMIUM";
        }
    }

    static class Recliner extends Ticket {
        Recliner(int count) {
            super(count);
        }

        @Override
        double getPrice() {
            return 400;
        }

        @Override
        String getSeatType() {
            return "RECLINER";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Ticket[] tickets = new Ticket[n];

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            switch (seat) {
                case "REGULAR":
                    tickets[i] = new Regular(count);
                    break;
                case "PREMIUM":
                    tickets[i] = new Premium(count);
                    break;
                case "RECLINER":
                    tickets[i] = new Recliner(count);
                    break;
                default:
                    throw new IllegalArgumentException(
                        "Invalid seat type: " + seat
                    );
            }
        }

        double total = 0;

        for (Ticket ticket : tickets) {
            double amount = ticket.calculateAmount();

            System.out.printf(
                "%s: %.2f%n",
                ticket.getSeatType(),
                amount
            );

            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}