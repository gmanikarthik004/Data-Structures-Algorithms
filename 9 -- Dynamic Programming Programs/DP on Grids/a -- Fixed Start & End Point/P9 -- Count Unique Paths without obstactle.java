// RECURSION && MEMOIZATION BASED-SOLUTION
/*
import java.util.Arrays;
class Solution {
    public int cntPaths(int i, int j, int[][] obstacleGrid, int dp[][]) {
        // // Out of Bounds
        if(i < 0 || j < 0) return 0;

        // // Obstacle Hit
        if(obstacleGrid[i][j] == 1) return 0;

        // Destination
        if(i == 0 && j == 0) return 1;

        // Already computed in dp
        if(dp[i][j] != -1) return dp[i][j];

        int up = cntPaths(i-1, j, obstacleGrid, dp);
        int left = cntPaths(i, j-1, obstacleGrid, dp);

        return dp[i][j] = up + left;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int dp[][] = new int[m][n];
        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }

        return cntPaths(m - 1, n - 1, obstacleGrid, dp);
    }
}
*/

// TABULATION BASED-SOLUTION
/*
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int dp[][] = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                // Obstacle check
                if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                // Destination reached
                else if(i == 0 && j == 0) dp[i][j] = 1;
                else {
                    int up = (i > 0)? dp[i-1][j] : 0;
                    int left = (j > 0)? dp[i][j-1] : 0;
                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m-1][n-1];
    }
}
*/

// SPACE-OPTIMIZED SOLUTION
/*
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] prevRow = new int[n];
        
        for(int i = 0; i < m; i++) {
            int[] curRow = new int[n];
            for(int j = 0; j < n; j++) {
                // Obstacle check
                if(obstacleGrid[i][j] == 1) curRow[j] = 0;
                // Destination reached
                else if(i == 0 && j == 0) curRow[j] = 1;
                else {
                    int up = (i > 0)? prevRow[j] : 0;
                    int left = (j > 0)? curRow[j-1] : 0;
                    curRow[j] = up + left;
                }
            }
            prevRow = curRow;
        }

        return prevRow[n-1];
    }
}
*/