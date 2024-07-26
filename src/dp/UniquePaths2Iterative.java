package dp;

public class UniquePaths2Iterative {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int [][] grid = new int[obstacleGrid.length][obstacleGrid[0].length];

        int i=0;
        for ( ;i<grid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            grid[0][i] = 1;
        }

        for (i=1; i<grid.length; i++) {

            grid[i][0] = obstacleGrid[i][0] == 0 ? grid[i-1][0] : 0;

            for (int j=1; j<grid[i].length; j++) {
                grid[i][j] = obstacleGrid[i][j] == 0? grid[i-1][j] + grid[i][j-1] : 0;
            }
        }

        return grid[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        UniquePaths2Iterative uniquePaths2Iterative = new UniquePaths2Iterative();
        int i = uniquePaths2Iterative.uniquePathsWithObstacles(new int[][]{{1},{0}});
        System.out.println(i);
    }
}
