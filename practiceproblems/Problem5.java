package practiceproblems;

import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = sc.nextInt();

        int num = n;
        int sum = 0;
        int reverse = 0;

        while (num > 0) {
            int digit = num % 10;

            sum = sum + digit;
            reverse = reverse * 10 + digit;

            num = num / 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);

        sc.close();
    }
}