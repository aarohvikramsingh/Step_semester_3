package assignmentproblems;

public class HallTicket {

    String studentName;
    int seatNumber;

    // Constructor
    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {

        HallTicket priya =
            new HallTicket("Priya", 0);

        // Both references point to the same object
        HallTicket copy = priya;

        copy.seatNumber = 45;

        // A separate object
        HallTicket separate =
            new HallTicket("Priya", 45);

        System.out.println(
            "Priya's seatNumber (via first variable): "
            + priya.seatNumber
        );

        System.out.println("copy == priya: " + (copy == priya));

        System.out.println(
            "separate == priya: " + (separate == priya)
        );
    }
}