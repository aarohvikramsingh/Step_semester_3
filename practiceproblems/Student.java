package practiceproblems;

public class Student {

    // Instance fields
    String name;
    double attendance;

    // Static fields
    static String collegeName =
        "SRM Institute of Science and Technology";

    static int studentCount = 0;

    // Constructor
    public Student(String name, double attendance) {

        this.name = name;
        this.attendance = attendance;

        studentCount++;
    }

    // Static method
    public static void printCollegeInfo() {

        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }

    public static void main(String[] args) {

        new Student("Ravi", 90);
new Student("Anitha", 95);

Student.printCollegeInfo();
    }
}