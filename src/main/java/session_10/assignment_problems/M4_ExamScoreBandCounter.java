package session_10.assignment_problems;

import java.util.Scanner;

public class M4_ExamScoreBandCounter {

    static int lowerBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    static int upperBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    static int countInBand(int[] scores, int low, int high) {
        int first = lowerBound(scores, low);
        int last = upperBound(scores, high);

        return last - first;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        int low = sc.nextInt();
        int high = sc.nextInt();

        System.out.println(countInBand(scores, low, high));
    }
}