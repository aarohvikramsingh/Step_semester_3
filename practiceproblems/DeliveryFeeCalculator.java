package practiceproblems;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class DeliveryFeeCalculator {

    private interface Delivery {
        double fee();
    }

    private static class StandardDelivery implements Delivery {
        private final double weight;
        private final double distance;

        StandardDelivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        public double fee() { return 5.0 + 0.50 * weight + 0.10 * distance; }
    }

    private static class ExpressDelivery implements Delivery {
        private final double weight;
        private final double distance;

        ExpressDelivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }

        public double fee() { return 15.0 + weight + 0.20 * distance; }
    }

    private static class InternationalDelivery implements Delivery {
        private final double weight;
        private final double distance;
        private final double customsFee;

        InternationalDelivery(double weight, double distance, double customsFee) {
            this.weight = weight;
            this.distance = distance;
            this.customsFee = customsFee;
        }

        public double fee() { return 25.0 + 2.0 * weight + 0.50 * distance + customsFee; }
    }

    private static final Map<String, Function<Scanner, Delivery>> DELIVERY_TYPES = Map.of(
        "STANDARD", input -> new StandardDelivery(input.nextDouble(), input.nextDouble()),
        "EXPRESS", input -> new ExpressDelivery(input.nextDouble(), input.nextDouble()),
        "INTERNATIONAL", input -> new InternationalDelivery(
            input.nextDouble(), input.nextDouble(), input.nextDouble())
    );

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);
        int count = input.nextInt();
        double total = 0.0;

        for (int i = 0; i < count; i++) {
            String type = input.next();
            Delivery delivery = DELIVERY_TYPES.get(type).apply(input);
            double fee = delivery.fee();
            System.out.printf(Locale.US, "%s: %.2f%n", type, fee);
            total += fee;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
