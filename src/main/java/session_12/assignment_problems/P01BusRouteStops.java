
package session_12.assignment_problems;

import java.util.Scanner;

public class P01BusRouteStops {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node build(String[] stops) {
        Node head = null;
        Node tail = null;

        for (String stop : stops) {
            Node newNode = new Node(stop);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    static void printRoute(Node head) {
        Node current = head;
        int count = 0;
        String first = "";
        String last = "";

        while (current != null) {
            if (count == 0) {
                first = current.data;
            }

            last = current.data;

            System.out.print(current.data + " -> ");
            count++;

            current = current.next;
        }

        System.out.println("null");

        System.out.println("Stops: " + count +
                ", First: " + first +
                ", Last: " + last);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] stops = new String[n];

        for (int i = 0; i < n; i++) {
            stops[i] = sc.next();
        }

        Node head = build(stops);
        printRoute(head);

        sc.close();
    }
}
