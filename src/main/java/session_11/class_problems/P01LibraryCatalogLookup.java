package session_11.class_problems;

import java.util.List;

/** Binary-search lookup in a catalog sorted by ISBN. */
public class P01LibraryCatalogLookup {
    public static final class Book {
        public final String isbn;
        public final String title;

        public Book(String isbn, String title) {
            this.isbn = isbn;
            this.title = title;
        }
    }

    /** Returns the matching title, or "Not Found". O(log n) time, O(1) extra space. */
    public static String findBook(List<Book> catalog, String targetIsbn) {
        int low = 0;
        int high = catalog.size() - 1;
        while (low <= high) {
            int middle = low + (high - low) / 2;
            int comparison = catalog.get(middle).isbn.compareTo(targetIsbn);
            if (comparison == 0) return catalog.get(middle).title;
            if (comparison < 0) low = middle + 1;
            else high = middle - 1;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        List<Book> catalog = List.of(
            new Book("0001112223", "Introduction to Algebra"),
            new Book("0002223334", "Beginning Python"),
            new Book("0003334445", "Classic Mythology"),
            new Book("0004445556", "Data and Society"),
            new Book("0005556667", "European History")
        );
        System.out.println(findBook(catalog, "0003334445"));
        System.out.println(findBook(catalog, "0009998887"));
    }
}
