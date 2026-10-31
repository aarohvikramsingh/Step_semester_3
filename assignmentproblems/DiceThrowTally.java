package assignmentproblems;

import java.util.Scanner;

public class DiceThrowTally {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] count = new int[7];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            count[arr[i]]++;
        }

        for (int i = 1; i <= 6; i++) {
            System.out.print(count[i] + " ");
        }

        System.out.println();

        int index = 0;

        for (int face = 1; face <= 6; face++) {
            for (int j = 0; j < count[face]; j++) {
                arr[index] = face;
                index++;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}