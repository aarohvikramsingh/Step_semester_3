package practiceproblems;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class PublicTransportFareCalculator {

    private interface Transport {
        double fare();
    }

    private static class Bus implements Transport {
        private final double distance;

        Bus(double distance) { this.distance = distance; }
        public double fare() { return Math.min(10.0, 2.0 + 0.10 * distance); }
    }

    private static class Train implements Transport {
        private final double distance;

        Train(double distance) { this.distance = distance; }
        public double fare() { return 3.0 + 0.15 * distance; }
    }

    private static class Metro implements Transport {
        private final double distance;
        private final double peakHourFactor;

        Metro(double distance, double peakHourFactor) {
            this.distance = distance;
            this.peakHourFactor = peakHourFactor;
        }

        public double fare() { return (1.50 + 0.20 * distance) * peakHourFactor; }
    }

    private static final Map<String, Function<Scanner, Transport>> TRANSPORT_TYPES = Map.of(
        "BUS", input -> new Bus(input.nextDouble()),
        "TRAIN", input -> new Train(input.nextDouble()),
        "METRO", input -> new Metro(input.nextDouble(), input.nextDouble())
    );

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useLocale(Locale.US);
        int count = input.nextInt();
        double total = 0.0;

        for (int i = 0; i < count; i++) {
            String type = input.next();
            Transport transport = TRANSPORT_TYPES.get(type).apply(input);
            double fare = transport.fare();
            System.out.printf(Locale.US, "%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
