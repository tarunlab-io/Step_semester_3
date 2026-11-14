package session_12.class_problems;

import java.util.Scanner;

class Staff {
    String name;
    double baseSalary;

    Staff(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    double getBonus() {
        return 0;
    }

    double getTotalSalary() {
        return baseSalary + getBonus();
    }
}

class Teacher extends Staff {
    Teacher(String name, double salary) {
        super(name, salary);
    }

    @Override
    double getBonus() {
        return 5000;
    }
}

class LabAssistant extends Staff {
    LabAssistant(String name, double salary) {
        super(name, salary);
    }

    @Override
    double getBonus() {
        return 2000;
    }
}

public class P01CampusStaffSalary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Staff[] staff = new Staff[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equalsIgnoreCase("Teacher")) {
                staff[i] = new Teacher(name, salary);
            } else if (type.equalsIgnoreCase("LabAssistant")) {
                staff[i] = new LabAssistant(name, salary);
            } else {
                staff[i] = new Staff(name, salary);
            }
        }

        double grandTotal = 0;

        for (Staff s : staff) {
            double bonus = s.getBonus();
            double total = s.getTotalSalary();

            System.out.println(s.name + " (" +
                s.getClass().getSimpleName() +
                "): base " + s.baseSalary +
                ", bonus " + bonus +
                ", total " + total);

            grandTotal += total;
        }

        System.out.println("Grand Total Salary: " + grandTotal);
        sc.close();
    }
}