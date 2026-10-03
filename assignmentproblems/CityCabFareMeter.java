package assignmentproblems;

import java.util.*;

abstract class Cab {

    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    double calculateFare() {

        double fare = km * getRate();

        return Math.max(fare, 100);
    }
}

interface NightService {
    double applyNightFare(double fare);
}

class Mini extends Cab {

    Mini(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }
}

class Sedan extends Cab implements NightService {

    Sedan(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    public double applyNightFare(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {

    SUV(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    public double applyNightFare(double fare) {
        return fare * 1.20;
    }
}

public class CityCabFareMeter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String cabType = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            if (cabType.equals("MINI")) {
                cab = new Mini(km);

            } else if (cabType.equals("SEDAN")) {
                cab = new Sedan(km);

            } else {
                cab = new SUV(km);
            }

            if (time.equals("NIGHT") &&
                    !(cab instanceof NightService)) {

                System.out.println(
                        cabType + ": night service not available"
                );

                continue;
            }

            double fare = cab.calculateFare();

            if (time.equals("NIGHT")) {
                fare = ((NightService) cab).applyNightFare(fare);
            }

            System.out.printf(
                    "%s: %.2f%n",
                    cabType, fare
            );

            total += fare;
        }

        System.out.printf(
                "Total: %.2f%n",
                total
        );

        sc.close();
    }
}