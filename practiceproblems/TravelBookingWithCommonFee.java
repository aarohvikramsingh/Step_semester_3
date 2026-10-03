package practiceproblems;

import java.util.*;

abstract class TravelBooking {

    static final double BOOKING_FEE = 50;

    double distance;

    TravelBooking(double distance) {
        this.distance = distance;
    }

    abstract double calculateBaseFare();

    double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class Bus extends TravelBooking {

    Bus(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 2;
    }
}

class Train extends TravelBooking {

    Train(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 1.5;
    }
}

class Flight extends TravelBooking {

    Flight(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return 2500 + (distance * 4);
    }
}

public class TravelBookingWithCommonFee {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String mode = sc.next();
            double distance = sc.nextDouble();

            TravelBooking booking;

            if (mode.equals("BUS")) {
                booking = new Bus(distance);

            } else if (mode.equals("TRAIN")) {
                booking = new Train(distance);

            } else {
                booking = new Flight(distance);
            }

            double total = booking.calculateTotal();

            System.out.printf("%s: %.2f%n",
                    mode, total);
        }

        sc.close();
    }
}