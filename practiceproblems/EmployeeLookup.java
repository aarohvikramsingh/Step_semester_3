package practiceproblems;

import java.util.HashMap;
import java.util.Scanner;

public class EmployeeLookup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<Integer, String> employees = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            String name = sc.next();

            employees.put(id, name);
        }

        int searchId = sc.nextInt();

        if (employees.containsKey(searchId)) {
            System.out.println(employees.get(searchId));
        } else {
            System.out.println("Employee not found");
        }

        sc.close();
    }
}