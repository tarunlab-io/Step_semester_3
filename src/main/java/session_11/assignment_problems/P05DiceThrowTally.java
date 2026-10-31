package session_11.assignment_problems;

import java.util.Arrays;

/** Counts die results and reconstructs them in ascending order. */
public class P05DiceThrowTally {
    /**
     * Returns counts for faces 1 through 6. Rolls outside that range are rejected.
     * Time: O(n); extra space: O(1) (the fixed seven-element count array).
     */
    public static int[] countRolls(int[] rolls) {
        int[] counts = new int[7];
        for (int roll : rolls) {
            if (roll < 1 || roll > 6) {
                throw new IllegalArgumentException("Each die result must be from 1 to 6");
            }
            counts[roll]++;
        }
        return counts;
    }

    /** Returns all rolls in increasing order using the face counts; O(n) time. */
    public static int[] diceSort(int[] rolls) {
        int[] counts = countRolls(rolls);
        int[] sorted = new int[rolls.length];
        int index = 0;
        for (int face = 1; face <= 6; face++) {
            for (int occurrence = 0; occurrence < counts[face]; occurrence++) {
                sorted[index++] = face;
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        int[] rolls = {4, 1, 6, 4, 2, 1, 4};
        int[] counts = countRolls(rolls);
        StringBuilder tally = new StringBuilder("Counts:");
        for (int face = 1; face <= 6; face++) {
            tally.append(' ').append(face).append(':').append(counts[face]);
        }
        System.out.println(tally);
        System.out.println("Sorted: " + Arrays.toString(diceSort(rolls)));
    }
}
