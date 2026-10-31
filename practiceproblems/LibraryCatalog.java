package practiceproblems;

import java.util.Scanner;

public class LibraryCatalog {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] books = new int[n];

        for (int i = 0; i < n; i++) {
            books[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int low = 0;
        int high = n - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (books[mid] == target) {
                result = mid;
                break;
            } else if (books[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(result);

        sc.close();
    }
}