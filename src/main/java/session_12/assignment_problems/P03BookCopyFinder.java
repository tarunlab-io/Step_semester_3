
package session_12.assignment_problems;

import java.util.Scanner;

public class P03BookCopyFinder {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static String find(Node head, String id) {
        Node current = head;

        int position = 1;
        int firstPosition = -1;
        int copies = 0;

        while (current != null) {
            if (current.data.equals(id)) {
                copies++;

                if (firstPosition == -1) {
                    firstPosition = position;
                }
            }

            position++;
            current = current.next;
        }

        if (copies == 0) {
            return id + " not found";
        }

        return id + " first at position " +
                firstPosition + ", copies: " + copies;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node head = null;
        Node tail = null;

        for (int i = 0; i < n; i++) {
            String id = sc.next();
            Node newNode = new Node(id);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        String searchId = sc.next();

        System.out.println(find(head, searchId));

        sc.close();
    }
}
