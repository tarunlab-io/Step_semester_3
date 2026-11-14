
package session_12.class_problems;

import java.util.Scanner;

public class P03LibraryReturnDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] stack = new String[3];
        String[] queue = new String[3];

        int top = -1;
        int front = 0;
        int rear = -1;
        int size = 0;

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String command = sc.next().toUpperCase();

            switch (command) {
                case "RETURN": {
                    String book = sc.next();

                    if (top == 2) {
                        System.out.println(book +
                            " rejected: pile is full");
                    } else {
                        stack[++top] = book;
                        System.out.println(book +
                            " placed on pile");
                    }
                    break;
                }

                case "SHELVE": {
                    if (top == -1) {
                        System.out.println("pile is empty");
                    } else {
                        System.out.println("shelved " +
                            stack[top--]);
                    }
                    break;
                }

                case "WAIT": {
                    String name = sc.next();

                    if (size == 3) {
                        System.out.println(name +
                            " rejected: line is full");
                    } else {
                        rear = (rear + 1) % 3;
                        queue[rear] = name;
                        size++;

                        System.out.println(name +
                            " joined the line");
                    }
                    break;
                }

                case "SERVE": {
                    if (size == 0) {
                        System.out.println("no one waiting");
                    } else {
                        System.out.println("served " +
                            queue[front]);

                        front = (front + 1) % 3;
                        size--;
                    }
                    break;
                }

                default:
                    System.out.println("Invalid command");
            }
        }

        sc.close();
    }
}
