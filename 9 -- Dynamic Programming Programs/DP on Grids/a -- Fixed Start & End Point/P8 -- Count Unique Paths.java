// RECURSION-BASED SOLUTION -- T.C = O(2 ^ M*N) S.C = O(Path Length = (M-1) + (N-1))
/*
class Solution {
    public int cntPaths(int i, int j) {
        // Base-Case
        if(i == 0 && j == 0) return 1; // Reached Destination
        if(i < 0 || j < 0) return 0; // Out-of Boundry

        int upDirection = cntPaths(i - 1, j);
        int leftDirection = cntPaths(i, j - 1);

        return upDirection + leftDirection;
    }
    public int uniquePaths(int m, int n) {
        return cntPaths(m-1, n-1);
    }
}
*/

// MEMOIZATION-BASED SOLUTION -- T.C = O(M * N) S.C = O(Path Length) + O(M * N)
/*
import java.util.Arrays;
class Solution {
    public int cntPaths(int i, int j, int dp[][]) {
        // Base-Case
        if(i == 0 && j == 0) return 1; // Reached Destination
        if(i < 0 || j < 0) return 0; // Out-of Boundry

        if(dp[i][j] != -1) return dp[i][j];

        int upDirection = cntPaths(i - 1, j, dp);
        int leftDirection = cntPaths(i, j - 1, dp);

        return dp[i][j] = upDirection + leftDirection;
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }

        return cntPaths(m-1, n-1, dp);
    }
}
*/

// TABULATION-BASED SOLUTION -- T.C = O(M * N) S.C = O(M * N)
/*
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) dp[0][0] = 1;
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

// SPACE-OPTIMIZED SOLUTION -- T.C = O(M * N) S.C = O(1)
/*
class Solution {
    public int uniquePaths(int m, int n) {
        int[] prevRow = new int[n];

        for(int i = 0; i < m; i++) {
            int curRow[] = new int[n];
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) {
                    curRow[j] = 1; // starting point
                }
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

// OPMIZED SOLUTION -- T.C : O(min(M, N)) && S.C: O(1)
/*
class Solution {
    public int uniquePaths(int m, int n) {
        long res = 1;

        // We calculate C(m+n-2, m-1) iteratively to avoid overflow
        for (int i = 1; i <= m - 1; i++) {
            res = res * (n - 1 + i) / i;
        }

        return (int) res;
    }
}
*/

