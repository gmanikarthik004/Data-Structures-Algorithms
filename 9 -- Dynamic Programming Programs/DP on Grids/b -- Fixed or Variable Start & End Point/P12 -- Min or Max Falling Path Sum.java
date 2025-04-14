// VARIABLE-STARTING POINT && VARIABLE-ENDING POINT

// CONSIDER MIN FALLING PATH SUM
// RECURSIVE BASED SOLUTION -- T.C: O(3^N) && S.C: O(N)
/*
class Solution {
    public int findMinPathSum(int i, int j, int cols, int[][] matrix) {
        if(j < 0 || j >= cols) return (int)1e9;
        if(i == 0) return matrix[0][j];

        int straight = matrix[i][j] + findMinPathSum(i-1, j, cols, matrix);
        int leftDiagonal = matrix[i][j] + findMinPathSum(i-1, j-1, cols, matrix);
        int rightDiagonal = matrix[i][j] + findMinPathSum(i-1, j+1, cols, matrix);

        return Math.min(straight, Math.min(leftDiagonal, rightDiagonal));
    }
    
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length; // No.of Rows
        int m = matrix[0].length; // No.of Cols

        int minPathSum = Integer.MAX_VALUE;
        for(int j = 0; j < m; j++) {
            int ans = findMinPathSum(n-1, j, m, matrix);
            minPathSum = Math.min(minPathSum, ans);
        }

        return minPathSum;
    }
}
*/

// MEMOIZATION BASED SOLUTION -- T.C: O(N*M) && S.C: O(N) + O(N*M)
/*
import java.util.Arrays;
class Solution {
    public int findMinPathSum(int i, int j, int cols, int[][] matrix, int[][] dp) {
        if(j < 0 || j >= cols) return (int)1e9;
        if(i == 0) return matrix[0][j];
        if(dp[i][j] != -1) return dp[i][j];

        int straight = matrix[i][j] + findMinPathSum(i-1, j, cols, matrix, dp);
        int leftDiagonal = matrix[i][j] + findMinPathSum(i-1, j-1, cols, matrix, dp);
        int rightDiagonal = matrix[i][j] + findMinPathSum(i-1, j+1, cols, matrix, dp);

        return dp[i][j] = Math.min(straight, Math.min(leftDiagonal, rightDiagonal));
    }
    
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length; // No.of Rows
        int m = matrix[0].length; // No.of Cols

        int[][] dp = new int[n][m];
        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }

        int minPathSum = Integer.MAX_VALUE;
        for(int j = 0; j < m; j++) {
            int ans = findMinPathSum(n-1, j, m, matrix, dp);
            minPathSum = Math.min(minPathSum, ans);
        }

        return minPathSum;
    }
}
*/

// TABULATION BASED SOLUTION: T.C: O(N*M)+O(M) && S.C: O(N*M)
/* 
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length; // No.of Rows
        int m = matrix[0].length; // No.of Cols

        int[][] dp = new int[n][m];

        // Base-Case(Fill the 1st Row)
        for(int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int s = dp[i-1][j];
                int ld = (j-1 >= 0)? dp[i-1][j-1] : (int)1e9;
                int rd = (j+1 < m)? dp[i-1][j+1] : (int)1e9;

                dp[i][j] = matrix[i][j] + Math.min(s, Math.min(ld, rd));
            }
        }

        int minPathSum = dp[n-1][0];
        for(int j = 1; j < m; j++) {
            minPathSum = Math.min(minPathSum, dp[n-1][j]);
        }

        return minPathSum;
    }
}
*/

// SPACE-BASED SOLUTION: T.C: O(N*M)+O(M) && S.C: O(M)
/*
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length; // No.of Rows
        int m = matrix[0].length; // No.of Cols

        int[] prevR = new int[m];

        // Base-Case(Fill the 1st Row)
        for(int j = 0; j < m; j++) {
            prevR[j] = matrix[0][j];
        }

        for(int i = 1; i < n; i++) {
            int[] curR = new int[m];
            for(int j = 0; j < m; j++) {
                int s = prevR[j];
                int ld = (j-1 >= 0)? prevR[j-1] : (int)1e9;
                int rd = (j+1 < m)? prevR[j+1] : (int)1e9;

                curR[j] = matrix[i][j] + Math.min(s, Math.min(ld, rd));
            }
            prevR = curR;
        }

        int minPathSum = prevR[0];
        for(int j = 1; j < m; j++) {
            minPathSum = Math.min(minPathSum, prevR[j]);
        }

        return minPathSum;
    }
}
*/
