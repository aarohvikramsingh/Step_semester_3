package assignmentproblems;

import java.util.*;

abstract class Appliance {

    double hours;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double calculateUnits() {
        return (getPower() * hours) / 1000;
    }

    double calculateCost() {
        return calculateUnits() * 8;
    }
}

interface SaverMode {

    double reduceUnits(double units);
}

class Fridge extends Appliance {

    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {

    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    public double reduceUnits(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {

    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {

    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    public double reduceUnits(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergyReport {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0;

        for (int i = 0; i < n; i++) {

            String applianceType = sc.next();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext()) {

                String next = sc.next();

                if (next.equals("SAVER")) {
                    saver = true;
                }
            }

            Appliance appliance;

            if (applianceType.equals("FRIDGE")) {
                appliance = new Fridge(hours);

            } else if (applianceType.equals("AC")) {
                appliance = new AC(hours);

            } else if (applianceType.equals("TV")) {
                appliance = new TV(hours);

            } else {
                appliance = new Washer(hours);
            }

            if (saver && !(appliance instanceof SaverMode)) {

                System.out.println(
                        applianceType +
                        ": saver mode not supported"
                );

                continue;
            }

            double units = appliance.calculateUnits();

            if (saver) {
                units = ((SaverMode) appliance).reduceUnits(units);
            }

            double cost = units * 8;

            System.out.printf(
                    "%s: Units=%.2f Cost=%.2f%n",
                    applianceType, units, cost
            );

            totalCost += cost;
        }

        System.out.printf(
                "Total Cost: %.2f%n",
                totalCost
        );

        sc.close();
    }
}