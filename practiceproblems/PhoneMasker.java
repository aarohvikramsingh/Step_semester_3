// Q4: Masked Phone Number Formatter
package practiceproblems;

import java.util.Scanner;

public class PhoneMasker {

    public static String maskPhoneNumber(String phone) {
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        String last4Digits = phone.substring(6);

        StringBuilder sb = new StringBuilder();
        sb.append("XXXXXX");
        sb.append("-");
        sb.append(last4Digits);

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        System.out.println(maskPhoneNumber(phone));
        scanner.close();
    }
}