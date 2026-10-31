package practiceproblems;

import java.util.HashSet;
import java.util.Scanner;

public class TransactionCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        HashSet<Integer> set = new HashSet<>();

        boolean duplicate = false;

        for (int i = 0; i < n; i++) {
            int transaction = sc.nextInt();

            if (set.contains(transaction)) {
                duplicate = true;
            }

            set.add(transaction);
        }

        if (duplicate) {
            System.out.println("Duplicate");
        } else {
            System.out.println("No Duplicate");
        }

        sc.close();
    }
}