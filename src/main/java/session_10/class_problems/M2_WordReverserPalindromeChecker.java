package session_10.class_problems;

import java.util.Scanner;

public class M2_WordReverserPalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.next();
        StringBuilder sb = new StringBuilder(word);
        String reversed = sb.reverse().toString();

        System.out.println(reversed + " - " +
            (word.equals(reversed) ? "palindrome" : "not a palindrome"));
    }
}