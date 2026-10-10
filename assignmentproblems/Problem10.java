package assignmentproblems;

import java.util.Scanner;

public class Problem10 {

    public static void busiestRow(int[][] grid) {
        int maxRow = 0;
        int maxTotal = 0;

        for (int i = 0; i < grid.length; i++) {
            int total = 0;

            for (int j = 0; j < grid[i].length; j++) {
                total = total + grid[i][j];
            }

            if (i == 0 || total > maxTotal) {
                maxTotal = total;
                maxRow = i;
            }
        }

        System.out.println("Row " + maxRow + ", Total " + maxTotal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] grid = new int[rows][cols];

        System.out.println("Enter the number of students in each seat:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        busiestRow(grid);

        sc.close();
    }
}