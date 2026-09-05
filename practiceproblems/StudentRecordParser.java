// Q2: CSV Student Record Parser
package practiceproblems;

import java.util.Scanner;

public class StudentRecordParser {

    public static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String rollNo = fields[1].trim();
        String dept = fields[2].trim();

        System.out.println("Name: " + name + " | Roll No: " + rollNo + " | Dept: " + dept);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter CSV Line: ");
        String input = scanner.nextLine();

        parseStudentRecord(input);
        scanner.close();
    }
}