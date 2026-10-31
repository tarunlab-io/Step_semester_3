package session_11.assignment_problems;

import java.util.Arrays;

/** Inserts books into their correct position on an ascending-numbered shelf. */
public class P03LibraryBookShelf {
    /**
     * Insertion-sorts books in place, printing the shelf after placing each book
     * from index 1 onward. Time: O(n^2) worst case; extra space: O(1).
     */
    public static void shelf(int[] books) {
        for (int i = 1; i < books.length; i++) {
            int book = books[i];
            int position = i - 1;
            while (position >= 0 && books[position] > book) {
                books[position + 1] = books[position];
                position--;
            }
            books[position + 1] = book;
            System.out.println("After placing " + book + ": " + Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        shelf(new int[] {30, 10, 40, 20});
        System.out.println();
        shelf(new int[] {5, 2, 4});
    }
}
