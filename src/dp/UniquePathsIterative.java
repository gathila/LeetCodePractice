package dp;

import java.util.Arrays;

public class UniquePathsIterative {

    public static void main(String[] args) {
        UniquePathsIterative uniquePathsIterative = new UniquePathsIterative();
        int i = uniquePathsIterative.uniquePaths(3, 7);
        System.out.println(i);
    }
    public int uniquePaths(int m, int n) {
        int [][] grid = new int[m][n];
        Arrays.fill(grid[0], 1);

        for (int i=1; i<m; i++) {
            grid[i][0] = 1;
            for (int j=1; j<n; j++) {
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }

        return grid[m-2][n-1] + grid[m-1][n-2];
    }
}
