package assignmentproblems;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class HostelElectricityBill {

    private interface Room {
        double billAmount();
    }

    private static class SingleRoom implements Room {
        private final int units;

        SingleRoom(int units) { this.units = units; }
        public double billAmount() { return units * 8.0; }
    }

    private static class SharedRoom implements Room {
        private final int units;
        private final int occupants;

        SharedRoom(int units, int occupants) {
            this.units = units;
            this.occupants = occupants;
        }

        public double billAmount() { return units * 6.0 / occupants; }
    }

    private static class AcRoom implements Room {
        private final int units;

        AcRoom(int units) { this.units = units; }
        public double billAmount() { return units * 10.0 + 200.0; }
    }

    private static final Map<String, Function<Scanner, Room>> ROOM_TYPES = Map.of(
        "SINGLE", input -> new SingleRoom(input.nextInt()),
        "SHARED", input -> new SharedRoom(input.nextInt(), input.nextInt()),
        "AC", input -> new AcRoom(input.nextInt())
    );

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        double total = 0.0;

        for (int i = 0; i < count; i++) {
            String type = input.next();
            Room room = ROOM_TYPES.get(type).apply(input);
            double amount = room.billAmount();
            System.out.printf(Locale.US, "%s: %.2f%n", type, amount);
            total += amount;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}
