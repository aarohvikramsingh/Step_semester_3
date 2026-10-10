package assignmentproblems;

import java.util.Scanner;

public class Problem4 {

    public static int countInBand(int[] scores, int low, int high) {
        int n = scores.length;

        int left = 0;
        int right = n;

        // Find the first position where score >= low
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] < low) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int first = left;

        left = 0;
        right = n;

        // Find the first position where score > high
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] <= high) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int last = left;

        return last - first;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of scores: ");
        int n = sc.nextInt();

        int[] scores = new int[n];

        System.out.println("Enter scores in ascending order:");

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        System.out.print("Enter low: ");
        int low = sc.nextInt();

        System.out.print("Enter high: ");
        int high = sc.nextInt();

        int result = countInBand(scores, low, high);

        System.out.println("Count: " + result);

        sc.close();
    }
}