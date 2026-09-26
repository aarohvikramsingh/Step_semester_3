package assignmentproblems;

import java.util.Map;
import java.util.Scanner;
import java.util.Locale;
import java.util.function.DoubleFunction;

public class CanteenBillingCounter {

    private interface Bill {
        double finalAmount();
    }

    private static class StudentBill implements Bill {
        private final double amount;

        StudentBill(double amount) { this.amount = amount; }
        public double finalAmount() { return amount * 0.90; }
    }

    private static class StaffBill implements Bill {
        private final double amount;

        StaffBill(double amount) { this.amount = amount; }
        public double finalAmount() { return amount * 0.95; }
    }

    private static class GuestBill implements Bill {
        private final double amount;

        GuestBill(double amount) { this.amount = amount; }
        public double finalAmount() { return amount + 10.0; }
    }

    private static final Map<String, DoubleFunction<Bill>> BILL_TYPES = Map.of(
        "STUDENT", StudentBill::new,
        "STAFF", StaffBill::new,
        "GUEST", GuestBill::new
    );

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);
        int count = input.nextInt();
        double total = 0.0;

        for (int i = 0; i < count; i++) {
            String type = input.next();
            Bill bill = BILL_TYPES.get(type).apply(input.nextDouble());
            double amount = bill.finalAmount();
            System.out.printf(Locale.US, "%s: %.2f%n", type, amount);
            total += amount;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
