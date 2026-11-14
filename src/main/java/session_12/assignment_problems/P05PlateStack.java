
package session_12.assignment_problems;

import java.util.Scanner;

public class P05PlateStack {

    static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    static class PlateStack {
        private Node top;
        private int size;

        void push(String plate) {
            Node newNode = new Node(plate);

            newNode.next = top;
            top = newNode;
            size++;

            System.out.println("push " + plate +
                    " -> top " + top.data +
                    ", size " + size);
        }

        void pop() {
            if (isEmpty()) {
                System.out.println("pop -> stack is empty");
                return;
            }

            String removed = top.data;
            top = top.next;
            size--;

            System.out.println("pop -> " + removed +
                    ", size " + size);
        }

        void peek() {
            if (isEmpty()) {
                System.out.println("peek -> stack is empty");
            } else {
                System.out.println("peek -> " + top.data);
            }
        }

        boolean isEmpty() {
            return top == null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PlateStack stack = new PlateStack();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String operation = sc.next();

            switch (operation.toLowerCase()) {
                case "push":
                    String plate = sc.next();
                    stack.push(plate);
                    break;

                case "pop":
                    stack.pop();
                    break;

                case "peek":
                    stack.peek();
                    break;

                case "isempty":
                    System.out.println("isEmpty -> " +
                            stack.isEmpty());
                    break;

                default:
                    System.out.println("Invalid operation");
            }
        }

        sc.close();
    }
}
