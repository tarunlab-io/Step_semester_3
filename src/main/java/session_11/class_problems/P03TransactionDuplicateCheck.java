package session_11.class_problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Detects whether any transaction ID occurs more than once. */
public class P03TransactionDuplicateCheck {
    /** Hash-based solution: expected O(n) time and O(n) extra space. */
    public static boolean hasDuplicate(List<String> transactionIds) {
        Set<String> seen = new HashSet<>();
        for (String id : transactionIds) {
            if (!seen.add(id)) return true;
        }
        return false;
    }

    /** Low-memory alternative: O(n^2) time and O(1) extra space. */
    public static boolean hasDuplicateLowMemory(List<String> transactionIds) {
        for (int i = 0; i < transactionIds.size(); i++) {
            for (int j = i + 1; j < transactionIds.size(); j++) {
                if (transactionIds.get(i).equals(transactionIds.get(j))) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasDuplicate(List.of("TXN001", "TXN002", "TXN003", "TXN002", "TXN004")));
        System.out.println(hasDuplicate(List.of("TXN001", "TXN002", "TXN003")));
    }
}
