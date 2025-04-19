// RECURSION-BASED SOLUTION -- T.C = O(2^N) S.C = O(N)
/*
class Solution {
    public int findWays(int n) {
        // Base-Case
        if(n == 0 || n == 1) return 1;
        int oneStep = findWays(n - 1);
        int twoSteps = findWays(n - 2);

        return oneStep + twoSteps;
    }
    public int climbStairs(int n) {
        return findWays(n);
    }
}
*/

// MEMOIZATION-BASED SOLUTION -- T.C = O(N) S.C = O(N) + O(N)
/*
import java.util.Arrays;
class Solution {
    public int findWays(int n, int[] dp) {
        // Base-Case
        if(n == 0 || n == 1) return 1;
        if(dp[n] != -1) return dp[n];

        int oneStep = findWays(n - 1, dp);
        int twoSteps = findWays(n - 2, dp);
        return dp[n] = oneStep + twoSteps;
    }
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return findWays(n, dp);
    }
}
*/

// TABULATION-BASED SOLUTION -- T.C = O(N) S.C = O(N)
/*
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];

        dp[0] = dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
} 
*/

// SPACE-OPTIMIZED SOLUTION -- T.C = O(N) S.C = O(1)
/*class Solution {
    public int climbStairs(int n) {
        int firstprev = 1, secondPrev = 1, currentIdx;

        for(int i = 2; i <= n; i++) {
            currentIdx = firstprev + secondPrev;
            secondPrev = firstprev;
            firstprev = currentIdx;
        }

        return firstprev;
    }
}
*/