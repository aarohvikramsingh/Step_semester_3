package assignmentproblems;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class FestivalBonusCalculator {

    private interface Employee {
        String name();
        double bonus();
    }

    private static class FullTimeEmployee implements Employee {
        private final String name;
        private final double salary;

        FullTimeEmployee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String name() { return name; }
        public double bonus() { return salary * 0.10; }
    }

    private static class PartTimeEmployee implements Employee {
        private final String name;
        private final double salary;

        PartTimeEmployee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String name() { return name; }
        public double bonus() { return salary * 0.05; }
    }

    private static class Intern implements Employee {
        private final String name;

        Intern(String name, double salary) { this.name = name; }
        public String name() { return name; }
        public double bonus() { return 2000.0; }
    }

    private static final Map<String, BiFunction<String, Double, Employee>> EMPLOYEE_TYPES = Map.of(
        "FULLTIME", FullTimeEmployee::new,
        "PARTTIME", PartTimeEmployee::new,
        "INTERN", Intern::new
    );

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);
        int count = input.nextInt();
        double total = 0.0;

        for (int i = 0; i < count; i++) {
            String type = input.next();
            String name = input.next();
            Employee employee = EMPLOYEE_TYPES.get(type).apply(name, input.nextDouble());
            double bonus = employee.bonus();
            System.out.printf(Locale.US, "%s: %.2f%n", employee.name(), bonus);
            total += bonus;
        }

        System.out.printf(Locale.US, "Total Bonus: %.2f%n", total);
    }
}
