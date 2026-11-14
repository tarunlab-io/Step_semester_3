
package session_12.class_problems;

import java.util.Scanner;

interface PaymentMode {
    double processPayment(double amount);
}

class CashPayment implements PaymentMode {
    @Override
    public double processPayment(double amount) {
        return amount;
    }
}

class CardPayment implements PaymentMode {
    @Override
    public double processPayment(double amount) {
        return amount + amount * 0.02;
    }
}

class UpiPayment implements PaymentMode {
    @Override
    public double processPayment(double amount) {
        return amount;
    }
}

public class P04PaymentProcessing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PaymentMode[] payments = new PaymentMode[n];
        double[] amounts = new double[n];
        String[] modes = new String[n];

        for (int i = 0; i < n; i++) {
            modes[i] = sc.next();
            amounts[i] = sc.nextDouble();

            if (modes[i].equalsIgnoreCase("Cash")) {
                payments[i] = new CashPayment();
            } else if (modes[i].equalsIgnoreCase("Card")) {
                payments[i] = new CardPayment();
            } else {
                payments[i] = new UpiPayment();
            }
        }

        double total = 0;

        for (int i = 0; i < n; i++) {
            double processed =
                payments[i].processPayment(amounts[i]);

            double fee = processed - amounts[i];
            total += processed;

            String mode;

            if (modes[i].equalsIgnoreCase("Cash")) {
                mode = "Cash";
            } else if (modes[i].equalsIgnoreCase("Card")) {
                mode = "Card";
            } else {
                mode = "UPI";
            }

            System.out.println(mode + ": amount " +
                amounts[i] + ", fee " + fee +
                ", processed " + processed);
        }

        System.out.println("Total Amount Processed: " + total);
        sc.close();
    }
}
