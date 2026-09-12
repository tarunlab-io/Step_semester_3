
package session_6.assignment_problems;

class Employee {

    String empName;
    double salary;

    // Static field shared by all employees
    static String companyName = "Bright Horizon Technologies";

    // Static field to count employees
    static int employeeCount = 0;

    // Constructor
    Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;

        employeeCount++;
    }

    // Static method
    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class M5_EmployeeCompany {

    public static void main(String[] args) {

        Employee e1 = new Employee("Divya", 65000);

        Employee e2 = new Employee("Arjun", 50000);

        Employee e3 = new Employee("Priya", 55000);

        // Call static method using class name
        Employee.printCompanyInfo();
    }
}