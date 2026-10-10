package assignmentproblems;

import java.util.Scanner;

public class Problem6 {

    public static void attendanceSummary(int[] days) {
        int present = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int i = 0; i < days.length; i++) {
            if (days[i] == 1) {
                present++;
                currentStreak++;

                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        System.out.println("Present: " + present);
        System.out.println("Longest streak: " + longestStreak);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] days = new int[n];

        System.out.println("Enter attendance (1 for present, 0 for absent):");

        for (int i = 0; i < n; i++) {
            days[i] = sc.nextInt();
        }

        attendanceSummary(days);

        sc.close();
    }
}