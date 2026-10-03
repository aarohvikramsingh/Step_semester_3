package assignmentproblems;

import java.util.*;

abstract class Student {

    String name;

    static final double TRANSPORT_FEE = 12000;

    Student(String name) {
        this.name = name;
    }

    abstract double getTuition();

    abstract boolean usesBus();

    double calculateFee() {

        double fee = getTuition();

        if (usesBus()) {
            fee += TRANSPORT_FEE;
        }

        return fee;
    }
}

class DayScholar extends Student {

    DayScholar(String name) {
        super(name);
    }

    double getTuition() {
        return 40000;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {

    Hosteller(String name) {
        super(name);
    }

    double getTuition() {
        return 40000 + 60000;
    }

    boolean usesBus() {
        return false;
    }
}

class Scholar extends Student {

    Scholar(String name) {
        super(name);
    }

    double getTuition() {
        return 20000;
    }

    boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();

            Student student;

            if (type.equals("DAY_SCHOLAR")) {
                student = new DayScholar(name);

            } else if (type.equals("HOSTELLER")) {
                student = new Hosteller(name);

            } else {
                student = new Scholar(name);
            }

            double fee = student.calculateFee();

            System.out.printf("%s: %.2f%n",
                    student.name, fee);

            totalCollected += fee;
        }

        System.out.printf(
                "Total Collected: %.2f%n",
                totalCollected
        );

        sc.close();
    }
}