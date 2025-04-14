// FIXED-STARTING POINT && VARIABLE-ENDING POINT

// RECURSION(T.C: O(2^ N) && S.C: O(N))
/*
class Solution {
    public int findMinSum(int i, int j, int n, List<List<Integer>> triangle) {
        // Base-Case
        if(i == n-1) return triangle.get(i).get(j);

        int down = findMinSum(i + 1, j, n, triangle);
        int diagonal = findMinSum(i + 1, j + 1, n, triangle);

        return triangle.get(i).get(j) + Math.min(down, diagonal);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        return findMinSum(0, 0, n, triangle);
    }
}
*/

// MEMOIZATION(T.C: O(N*N) && S.C: O(N) + O(N*N)
/*
import java.util.Arrays;
class Solution {
    public int findMinSum(int i, int j, int n, List<List<Integer>> triangle, int[][] dp) {
        // Base-Case
        if(i == n-1) return triangle.get(i).get(j);
        if(dp[i][j] != -1) return dp[i][j]; 

        int down = findMinSum(i + 1, j, n, triangle, dp);
        int diagonal = findMinSum(i + 1, j + 1, n, triangle, dp);

        return dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return findMinSum(0, 0, n, triangle, dp);
    }
}
*/

// TABULATION-BASED APPROACH -- T.C: O(N*N) && S.C: O(N*N)
/*
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        // Fill the lastRow(n-1)
        for(int col = 0; col < n; col++) {
            dp[n-1][col] = triangle.get(n-1).get(col);
        }

        // Start from n-2
        for(int i = n-2; i >= 0; i--) {
            for(int j = i; j >= 0; j--) {
                int down = dp[i + 1][j];
                int diagonal = dp[i + 1][j + 1];

                dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
            }
        }

        return dp[0][0];
    }
}
*/

// SPACE OPTIMIZED SOLUTION -- T.C: O(N*N) && S.C: O(N)
/*
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] prevRow = new int[n];

        // Fill the lastRow(n-1) into prevRow
        for(int col = 0; col < n; col++) {
            prevRow[col] = triangle.get(n-1).get(col);
        }

        // Start from n-2
        for(int i = n-2; i >= 0; i--) {
            int[] currRow = new int[n];
            for(int j = i; j >= 0; j--) {
                int down = prevRow[j];
                int diagonal = prevRow[j + 1];

                currRow[j] = triangle.get(i).get(j) + Math.min(down, diagonal);
            }
            prevRow = currRow;
        }

        return prevRow[0];
    }
}
*/