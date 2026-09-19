package practiceproblems;

public class AttendanceSheet {

    private String[] students;
    private int count;

    AttendanceSheet(int maxStudents) {

        students = new String[maxStudents];
        count = 0;
    }

    void markPresent(String name) {

        if (isPresent(name)) {
            return;
        }

        students[count] = name;
        count++;
    }

    int getPresentCount() {
        return count;
    }

    boolean isPresent(String name) {

        for (int i = 0; i < count; i++) {

            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println(sheet.getPresentCount());
        System.out.println(sheet.isPresent("Ben"));
        System.out.println(sheet.isPresent("Chen"));
    }
}