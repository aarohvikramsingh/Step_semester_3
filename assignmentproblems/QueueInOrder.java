package assignmentproblems;

import java.util.Scanner;

public class QueueInOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = -1;

        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                result = i;
                break;
            }
        }

        System.out.println(result);

        sc.close();
    }
}