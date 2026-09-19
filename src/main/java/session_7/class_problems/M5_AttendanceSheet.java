package session_7.class_problems;

public class M5_AttendanceSheet {

    static class AttendanceSheet {

        private final String[] presentStudents;
        private int presentCount;

        // Constructor
        AttendanceSheet(int maxStudents) {

            presentStudents = new String[maxStudents];
            presentCount = 0;
        }

        // Mark student present
        void markPresent(String name) {

            // Check duplicate
            if (isPresent(name)) {
                return;
            }

            // Check capacity
            if (presentCount >= presentStudents.length) {
                System.out.println(
                    "Attendance sheet is full"
                );
                return;
            }

            presentStudents[presentCount] = name;
            presentCount++;
        }

        // Return number present
        int getPresentCount() {
            return presentCount;
        }

        // Check whether student is present
        boolean isPresent(String name) {

            for (int i = 0; i < presentCount; i++) {

                if (presentStudents[i].equals(name)) {
                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {

        AttendanceSheet sheet =
            new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println(
            "Present count: " +
            sheet.getPresentCount()
        );

        System.out.println(
            "Ben present: " +
            sheet.isPresent("Ben")
        );

        System.out.println(
            "Chen present: " +
            sheet.isPresent("Chen")
        );
    }
}