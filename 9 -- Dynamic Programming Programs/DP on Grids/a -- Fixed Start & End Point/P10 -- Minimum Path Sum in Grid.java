// RECURSION(T.C: O(2^ N*M) && S.C: O(Path Length)) + 
// MEMOIZATION(T.C: O(N*M) && S.C: O(Path Length) + O(N*M))
/*
import java.util.Arrays;
class Solution {
    public int minSum(int i, int j, int[][] grid, int dp[][]) {
        // Reached destination
        if(i == 0 && j == 0) return grid[i][j];
        // Out-of-boundry path
        if(i < 0 || j < 0) return Integer.MAX_VALUE;
        // Return if already computed
        if(dp[i][j] != -1) return dp[i][j];

        int upSum = minSum(i - 1, j, grid, dp);
        int leftSum = minSum(i, j - 1, grid, dp);

        return dp[i][j] = grid[i][j] + Math.min(upSum, leftSum);
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dp[][] = new int[n][m];
        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return minSum(n-1, m-1, grid, dp);
    }
}
*/

// TABULATION-BASED APPROACH -- T.C: O(N*M) && S.C: O(N*M)
/*
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } 
                else {
                    int upSum = (i > 0)? dp[i - 1][j] : Integer.MAX_VALUE;
                    int leftSum = (j > 0)? dp[i][j - 1] : Integer.MAX_VALUE;

                    dp[i][j] = grid[i][j] + Math.min(upSum, leftSum);
                }
            }
        }
        return dp[n-1][m-1];
    }
}
*/

// SPACE-OPTIMIZED SOLUTION -- T.C: (N*M) && S.C: O(4) ~= O(1)
/*
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] prevRow = new int[m];

        for(int i = 0; i < n; i++) {
            int[] curRow = new int[m];
            for(int j = 0; j < m; j++) {
                if(i == 0 && j == 0) {
                    curRow[j] = grid[i][j];
                } 
                else {
                    int upSum = (i > 0)? prevRow[j] : (int)1e9;
                    int leftSum = (j > 0)? curRow[j - 1] : (int)1e9;

                    curRow[j] = grid[i][j] + Math.min(upSum, leftSum);
                }
            }
            prevRow = curRow;
        }
        return prevRow[m-1];
    }
}
*/