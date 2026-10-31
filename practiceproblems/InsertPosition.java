package practiceproblems;

import java.util.Scanner;

public class InsertPosition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int low = 0;
        int high = n - 1;
        int position = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                position = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(position);

        sc.close();
    }
}