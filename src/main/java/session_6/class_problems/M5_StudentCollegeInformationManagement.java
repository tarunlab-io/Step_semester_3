package session_6.class_problems;

public class M5_StudentCollegeInformationManagement {

    static class Student {

        // Instance variables
        String name;
        double attendance;

        // Static variables
        static String collegeName =
            "SRM Institute of Science and Technology";

        static int studentCount = 0;

        // Constructor
        Student(String name, double attendance) {

            this.name = name;
            this.attendance = attendance;

            studentCount++;
        }

        // Static method
        static void printCollegeInfo() {

            System.out.println(collegeName);
            System.out.println(
                "Students created: " + studentCount
            );
        }
    }

    public static void main(String[] args) {

    new Student("Ravi", 90.0);
    new Student("Anitha", 95.0);

    Student.printCollegeInfo();

    }
}