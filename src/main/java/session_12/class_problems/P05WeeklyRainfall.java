
package session_12.class_problems;

import java.util.Scanner;

public class P05WeeklyRainfall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] rainfall = new double[7];

        double total = 0;
        int dryDays = 0;
        int wettestDay = 0;

        for (int i = 0; i < 7; i++) {
            rainfall[i] = sc.nextDouble();
        }

        System.out.print("Rainfall (mm): ");

        for (int i = 0; i < 7; i++) {
            System.out.print(rainfall[i] + " ");

            total += rainfall[i];

            if (rainfall[i] == 0) {
                dryDays++;
            }

            if (rainfall[i] > rainfall[wettestDay]) {
                wettestDay = i;
            }
        }

        double average = total / 7.0;

        System.out.println();

        System.out.println("Total Rainfall: " +
            total + " mm");

        System.out.printf(
            "Average Rainfall: %.2f mm%n", average
        );

        System.out.println("Wettest Day: Day " +
            (wettestDay + 1) + " (" +
            rainfall[wettestDay] + " mm)");

        System.out.println("Total Dry Days: " + dryDays);

        sc.close();
    }
}
