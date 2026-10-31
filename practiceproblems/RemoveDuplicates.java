package practiceproblems;

import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        if (n == 0) {
            System.out.println(0);
            sc.close();
            return;
        }

        int unique = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[unique - 1]) {
                arr[unique] = arr[i];
                unique++;
            }
        }

        System.out.println(unique);

        for (int i = 0; i < unique; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}