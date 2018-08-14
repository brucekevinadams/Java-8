
/*
 * Author: Bruce Adams
 * email: ezaroth@gmail.com
 * website: austingamestudios.com
 *
    This program is from a Hackerrank problem
    A 1 is called a filled cell, a 0 is unfilled.
    Two cells are said to be connected if they are
    adjacent to each other horizontally, vertically, or diagonally.
*/

import java.util.Scanner;

public class ConnectedCellsInAGrid {

    private static int rows; 
    private static int cols; 

    public static void main(String[] args) {
        /* Read and save grid */
        Scanner scan = new Scanner(System.in);
        rows = scan.nextInt();
        cols = scan.nextInt();
        int grid[][] = new int[rows][cols];
        for (int grid_i = 0; grid_i < rows; grid_i++) {
            for (int grid_j = 0; grid_j < cols; grid_j++) {
                grid[grid_i][grid_j] = scan.nextInt();
            }
        }
        scan.close();

        System.out.println(largestRegion(grid));
    }

    /* Returns the size of the largest region */
    public static int largestRegion(int[][] grid) {
        int maxRegion = 0;
        
        /* From each filled cell, find the largest region from that cell */
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    int size = findLargestRegion(grid, row, col);
                    maxRegion = Math.max(maxRegion, size);
                }
            }
        }
        return maxRegion;
    }

    private static int findLargestRegion(int[][] grid, int row, int col) {
        /* Put boundary checks at top of recursive call, 
                    instead of before doing recursive call */
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return 0;
        } else if (grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0; // we alter the original matrix here
        int size = 1;       // 1 accounts for our size
        
        /* Accounts recursively for neighbors sizes */
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (!(r == 0 && c == 0)) {
                    size += findLargestRegion(grid, r, c);
                }
            }
        }

        return size;
    }
}
