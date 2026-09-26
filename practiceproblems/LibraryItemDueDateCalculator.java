package practiceproblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Map;
import java.util.function.Function;

public class LibraryItemDueDateCalculator {

    private abstract static class LibraryItem {
        private final String title;

        LibraryItem(String title) { this.title = title; }
        abstract int borrowingDays();

        String title() { return title; }
        LocalDate dueDate() { return LocalDate.of(2023, 10, 26).plusDays(borrowingDays()); }
    }

    private static class Book extends LibraryItem {
        Book(String title) { super(title); }
        int borrowingDays() { return 14; }
    }

    private static class Dvd extends LibraryItem {
        Dvd(String title) { super(title); }
        int borrowingDays() { return 7; }
    }

    private static class Magazine extends LibraryItem {
        Magazine(String title) { super(title); }
        int borrowingDays() { return 3; }
    }

    private static final Map<String, Function<String, LibraryItem>> ITEM_TYPES = Map.of(
        "BOOK", Book::new,
        "DVD", Dvd::new,
        "MAGAZINE", Magazine::new
    );

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(input.readLine().trim());

        for (int i = 0; i < count; i++) {
            String line = input.readLine().trim();
            int separator = line.indexOf(' ');
            String type = line.substring(0, separator);
            String title = line.substring(separator + 1).trim();
            if (title.length() >= 2 && title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item = ITEM_TYPES.get(type).apply(title);
            System.out.println(item.title() + ": " + item.dueDate());
        }
    }
}
