
package session_12.class_problems;

import java.util.Scanner;

public class P06HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int roomsBilled = 0;
        int totalBill = 0;

        for (int i = 0; i < n; i++) {
            String room = sc.next();
            int units = sc.nextInt();

            if (units < 0) {
                System.out.println(room +
                    ": invalid reading");
                continue;
            }

            int bill;

            if (units <= 100) {
                bill = units * 3 + 50;
            } else if (units <= 200) {
                bill = 100 * 3 +
                    (units - 100) * 5 + 50;
            } else {
                bill = 100 * 3 +
                    100 * 5 +
                    (units - 200) * 8 + 50;
            }

            roomsBilled++;
            totalBill += bill;

            System.out.println(room + ": " +
                units + " units, bill " + bill);
        }

        System.out.println("Rooms billed " +
            roomsBilled + ", total " + totalBill);

        sc.close();
    }
}
