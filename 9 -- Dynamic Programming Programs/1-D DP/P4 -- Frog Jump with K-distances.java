// RECURSION-BASED SOLUTION -- T.C = O(K^N) S.C = O(N)
/*
class FrogKJumps {
    public static int findMinEnergy(int idx, int[] heights, int k) {
        if(idx == 0) return 0;

        int minEnergy = Integer.MAX_VALUE;

        for(int j = 1; j <= k; j++) {
            if(idx - j >= 0) {
                int jump = findMinEnergy(idx-j, heights, k) + Math.abs(heights[idx] - heights[idx-j]);
                minEnergy = Math.min(minEnergy, jump);
            }
        }

        return minEnergy;
    }
    public static void main(String args[]) {
        int[] heights = {10, 5, 20, 0, 15};
        int n = heights.length;
        int k = 2;
        
        System.out.println("Minimum Energy required to reach Nth step from 0th-step using K-steps: " + findMinEnergy(n-1, heights, k));
    }
}
*/

// MEMOIZATION-BASED SOLUTION -- T.C = O(N * K) S.C = O(N) + O(N)
/*
import java.util.Arrays;

class FrogKJumps {
    public static int findMinEnergy(int idx, int[] heights, int k, int[] dp ) {
        if(idx == 0) return 0;
        
        if(dp[idx] != -1) return dp[idx];

        int minEnergy = Integer.MAX_VALUE;

        for(int j = 1; j <= k; j++) {
            if(idx - j >= 0) {
                int jump = findMinEnergy(idx-j, heights, k, dp) + Math.abs(heights[idx] - heights[idx-j]);
                minEnergy = Math.min(minEnergy, jump);
            }
        }

        return dp[idx] = minEnergy;
    }
    public static void main(String args[]) {
        int[] heights = {10, 5, 20, 0, 15};
        int n = heights.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int k = 2;
        
        System.out.println("Minimum Energy required to reach Nth step from 0th-step using K-steps: " + findMinEnergy(n-1, heights, k, dp));
    }
}
*/

// TABULATION-BASED SOLUTION -- T.C = O(N * K) S.C = O(N)
/*
class FrogKJumps {
    public static void main(String args[]) {
        int[] heights = {10, 5, 20, 0, 15};
        int n = heights.length;
        int[] dp = new int[n];
        int k = 2;
        
        // Base-Case
        dp[0] = 0;
        for(int idx = 1; idx < n; idx++) {
            int minEnergy = Integer.MAX_VALUE;
            for(int j = 1; j <= k; j++) {
                if(idx - j >= 0) {
                    int jump = dp[idx-j] + Math.abs(heights[idx] - heights[idx-j]);
                    minEnergy = Math.min(minEnergy, jump);
                }
            }
            dp[idx] = minEnergy;
        }
        
        System.out.println("Minimum Energy required to reach Nth step from 0th-step using K-steps: " + dp[n-1]);
    }
}
*/