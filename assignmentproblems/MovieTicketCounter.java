package assignmentproblems;

import java.util.*;

abstract class Ticket {
    int count;

    static final double CONVENIENCE_FEE = 20;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPrice();

    double getTotal() {
        return (getPrice() * count) + (CONVENIENCE_FEE * count);
    }
}

class Regular extends Ticket {

    Regular(int count) {
        super(count);
    }

    double getPrice() {
        return 150;
    }
}

class Premium extends Ticket {

    Premium(int count) {
        super(count);
    }

    double getPrice() {
        return 250;
    }
}

class Recliner extends Ticket {

    Recliner(int count) {
        super(count);
    }

    double getPrice() {
        return 400;
    }
}

public class MovieTicketCounter {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String seat = sc.next();
            int count = sc.nextInt();

            Ticket ticket;

            if (seat.equals("REGULAR")) {
                ticket = new Regular(count);

            } else if (seat.equals("PREMIUM")) {
                ticket = new Premium(count);

            } else {
                ticket = new Recliner(count);
            }

            double amount = ticket.getTotal();

            System.out.printf("%s: %.2f%n", seat, amount);

            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}