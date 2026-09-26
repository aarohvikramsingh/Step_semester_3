package assignmentproblems;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.function.IntFunction;

public class CampusParkingChargeCalculator {

    private interface Vehicle {
        double charge();
    }

    private static class Bike implements Vehicle {
        private final int hours;

        Bike(int hours) { this.hours = hours; }
        public double charge() { return hours * 10.0; }
    }

    private static class Car implements Vehicle {
        private final int hours;

        Car(int hours) { this.hours = hours; }
        public double charge() { return 30.0 + (hours - 1) * 20.0; }
    }

    private static class Truck implements Vehicle {
        private final int hours;

        Truck(int hours) { this.hours = hours; }
        public double charge() { return Math.max(100.0, hours * 50.0); }
    }

    private static final Map<String, IntFunction<Vehicle>> VEHICLE_TYPES = Map.of(
        "BIKE", Bike::new,
        "CAR", Car::new,
        "TRUCK", Truck::new
    );

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        double total = 0.0;

        for (int i = 0; i < count; i++) {
            String type = input.next();
            Vehicle vehicle = VEHICLE_TYPES.get(type).apply(input.nextInt());
            double charge = vehicle.charge();
            System.out.printf(Locale.US, "%s: %.2f%n", type, charge);
            total += charge;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
