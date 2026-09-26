package assignmentproblems;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class StreamingPlanRenewalReminder {

    private abstract static class Subscriber {
        private final String name;
        private final LocalDate startDate;

        Subscriber(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        abstract int validityDays();

        String name() { return name; }
        LocalDate renewalDate() { return startDate.plusDays(validityDays()); }
    }

    private static class BasicPlan extends Subscriber {
        BasicPlan(String name, LocalDate startDate) { super(name, startDate); }
        int validityDays() { return 30; }
    }

    private static class StandardPlan extends Subscriber {
        StandardPlan(String name, LocalDate startDate) { super(name, startDate); }
        int validityDays() { return 90; }
    }

    private static class PremiumPlan extends Subscriber {
        PremiumPlan(String name, LocalDate startDate) { super(name, startDate); }
        int validityDays() { return 365; }
    }

    private static final Map<String, BiFunction<String, LocalDate, Subscriber>> PLANS = Map.of(
        "BASIC", BasicPlan::new,
        "STANDARD", StandardPlan::new,
        "PREMIUM", PremiumPlan::new
    );

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();

        for (int i = 0; i < count; i++) {
            String type = input.next();
            String name = input.next();
            LocalDate startDate = LocalDate.parse(input.next());
            Subscriber subscriber = PLANS.get(type).apply(name, startDate);
            System.out.println(subscriber.name() + ": " + subscriber.renewalDate());
        }
    }
}
