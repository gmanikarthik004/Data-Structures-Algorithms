// RECURSION-BASED SOLUTION -- T.C = O(2^N) S.C = O(N)
/*
class FrogJump {
    public static int findMin(int idx, int[] cost) {
        if(idx == 0) return 0;
        int leftR = findMin(idx - 1, cost) + Math.abs(cost[idx] - cost[idx-1]);
        int rightR = Integer.MAX_VALUE;
        if(idx > 1) {
            rightR = findMin(idx - 2, cost) + Math.abs(cost[idx] - cost[idx-2]);
        }
        
        return Math.min(leftR, rightR);
    }
    public static void main(String args[]) {
        int N = 6;
        int[] cost = {30, 10, 60, 10, 60, 50};
        
        System.out.println("Minimum energy required to reach Nth-step from 0th-step: " + findMin(N-1, cost));
    }
}
*/

// MEMOIZATION-BASED SOLUTION -- T.C = O(N) S.C = O(N) + O(N)
/*
import java.util.Arrays;
class Solution {
    public static int findMinEnergy(int idx, int[] heights, int[] dp) {
        if(idx == 0) return 0;
        if(dp[idx] != -1) return dp[idx];
        int leftR = findMinEnergy(idx - 1, heights, dp) + Math.abs(heights[idx] - heights[idx-1]);
        int rightR = Integer.MAX_VALUE;
        if(idx > 1) {
            rightR = findMinEnergy(idx - 2, heights, dp) + Math.abs(heights[idx] - heights[idx-2]);
        }
        
        return dp[idx] = Math.min(leftR, rightR);
    }

    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return findMinEnergy(n-1, heights, dp);
    }
}
*/

// TABULATION-BASED SOLUTION -- T.C = O(N) S.C = O(N)
/*
class Solution {
    public static int frogJump(int n, int heights[]) {
        int[] dp = new int[n];
        dp[0] = 0;

        for(int idx = 1; idx < n; idx++) {
            int firstStep = dp[idx - 1] + Math.abs(heights[idx] - heights[idx-1]);
            int secondStep = Integer.MAX_VALUE;
            if(idx > 1) {
                secondStep = dp[idx - 2] + Math.abs(heights[idx] - heights[idx-2]);
            }
            dp[idx] = Math.min(firstStep, secondStep);
        }

        return dp[n-1];
    }
}
*/

// SPACE-OPTIMIZED SOLUTION -- T.C = O(N) S.C = O(1)
/*
class Solution {
    public static int frogJump(int n, int heights[]) {
        int prev1 = 0, prev2 = 0, curVal;

        for(int idx = 1; idx < n; idx++) {
            int firstStep = prev1 + Math.abs(heights[idx]-heights[idx-1]);
            int secondStep = Integer.MAX_VALUE;
            if(idx > 1) {
                secondStep = prev2 + Math.abs(heights[idx]-heights[idx-2]);
            }
            curVal = Math.min(firstStep, secondStep);
            prev2 = prev1;
            prev1 = curVal;
        }

        return prev1;
    }
}
*/
