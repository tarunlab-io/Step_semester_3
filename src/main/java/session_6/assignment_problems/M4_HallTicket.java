package session_6.assignment_problems;

class HallTicket {

    String studentName;
    int seatNumber;

    // Constructor
    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class M4_HallTicket {

    public static void main(String[] args) {

        HallTicket priya =
                new HallTicket("Priya", 0);

        // Both variables refer to SAME object
        HallTicket copy = priya;

        // Change through copy
        copy.seatNumber = 45;

        // Separate object
        HallTicket separate =
                new HallTicket("Priya", 45);

        System.out.println(
            "Priya's seatNumber (via first variable):"
        );

        System.out.println(priya.seatNumber);

        System.out.println("copy == priya: " + (copy == priya));

        System.out.println(
            "separate == priya: " + (separate == priya)
        );
    }
}