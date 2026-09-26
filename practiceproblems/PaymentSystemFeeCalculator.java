package practiceproblems;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.function.DoubleFunction;

public class PaymentSystemFeeCalculator {

    private interface Payment {
        double adjustedAmount();
    }

    private static class CardPayment implements Payment {
        private final double amount;

        CardPayment(double amount) { this.amount = amount; }
        public double adjustedAmount() { return amount * 1.02; }
    }

    private static class WalletPayment implements Payment {
        private final double amount;

        WalletPayment(double amount) { this.amount = amount; }
        public double adjustedAmount() { return amount * 1.01; }
    }

    private static class BankTransfer implements Payment {
        private final double amount;

        BankTransfer(double amount) { this.amount = amount; }
        public double adjustedAmount() { return amount; }
    }

    private static final Map<String, DoubleFunction<Payment>> PAYMENT_TYPES = Map.of(
        "CARD", CardPayment::new,
        "WALLET", WalletPayment::new,
        "BANKTRANSFER", BankTransfer::new
    );

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);
        int count = input.nextInt();
        double total = 0.0;

        for (int i = 0; i < count; i++) {
            String type = input.next();
            Payment payment = PAYMENT_TYPES.get(type).apply(input.nextDouble());
            double amount = payment.adjustedAmount();
            System.out.printf(Locale.US, "%s: %.2f%n", type, amount);
            total += amount;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
