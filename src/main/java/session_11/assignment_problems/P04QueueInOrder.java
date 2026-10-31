package session_11.assignment_problems;

/** Finds the first student whose token breaks the queue's nondecreasing order. */
public class P04QueueInOrder {
    /**
     * Returns the first breaking index, or -1 when the queue is in order.
     * Equal adjacent tokens are allowed. Time: O(n); extra space: O(1).
     */
    public static int firstBreak(int[] tokens) {
        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstBreak(new int[] {3, 5, 5, 8, 6, 9}));
        System.out.println(firstBreak(new int[] {1, 2, 2, 7}));
    }
}
