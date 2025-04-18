// RECURSION: T.C: > O(2^N) && S.C: O(W)
/*
class Solution {
    public static int maxProfit(int idx, int W, int[] weight, int[] value) {
        if(idx == 0) {
            return (W / weight[0]) * value[0];
        }
        int notTake = 0 + maxProfit(idx - 1, W, weight, value);
        int take = Integer.MIN_VALUE;
        if(weight[idx] <= W) 
            take = value[idx] + maxProfit(idx, W - weight[idx], weight, value);
        
        return Math.max(take, notTake);
    }
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        return maxProfit(n-1, w, weight, profit);
    }
}
*/

// MEMOIZATION: T.C: O(N * W) && S.C: O(W) + O(N * W)
/*
import java.util.Arrays;
class Solution {
    public static int maxProfit(int idx, int W, int[] weight, int[] value, int[][] dp) {
        if(idx == 0) {
            return (W / weight[0]) * value[0];
        }

        if(dp[idx][W] != -1) return dp[idx][W];
        
        int notTake = 0 + maxProfit(idx - 1, W, weight, value, dp);
        int take = Integer.MIN_VALUE;
        if(weight[idx] <= W) 
            take = value[idx] + maxProfit(idx, W - weight[idx], weight, value, dp);
        
        return dp[idx][W] = Math.max(take, notTake);
    }
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w+1];
        for(int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return maxProfit(n-1, w, weight, profit, dp);
    }
}
*/

// TABULATION: T.C: O(N * W) && S.C: O(N * W)
/*
class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w+1];

        for(int W = 0; W <= w; W++) {
            dp[0][W] = (W / weight[0]) * profit[0];
        }

        for(int idx = 1; idx < n; idx++) {
            for(int W = 0; W <= w; W++) {
                int notPick = 0 + dp[idx - 1][W];
                int pick = Integer.MIN_VALUE;
                if (weight[idx] <= W)
                    pick = profit[idx] + dp[idx][W - weight[idx]];

                dp[idx][W] = Math.max(pick, notPick);
            }
        }

        return dp[n-1][w];
    }
}
*/

// SPACE OPTIMIZATION (USING 2 ARRAYS): T.C: O(N * W) && S.C: O(W)
/*
class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int prevRow[] = new int[w + 1];

        for(int W = 0; W <= w; W++) {
            prevRow[W] = (W / weight[0]) * profit[0];
        }

        for(int idx = 1; idx < n; idx++) {
            int curRow[] = new int[w + 1];
            for(int W = 0; W <= w; W++) {
                int notPick = 0 + prevRow[W];
                int pick = Integer.MIN_VALUE;
                if (weight[idx] <= W)
                    pick = profit[idx] + curRow[W - weight[idx]];

                curRow[W] = Math.max(pick, notPick);
            }
            prevRow = curRow;
        }

        return prevRow[w];
    }
}
*/

// SPACE OPTIMIZATION (USING 1-ARRAY): T.C: O(N * W) && S.C: O(W)
/*
class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int prevRow[] = new int[w + 1];

        for(int W = 0; W <= w; W++) {
            prevRow[W] = (W / weight[0]) * profit[0];
        }

        for(int idx = 1; idx < n; idx++) {
            for(int W = 0; W <= w; W++) {
                int notPick = 0 + prevRow[W];
                int pick = Integer.MIN_VALUE;
                if (weight[idx] <= W) 
                    pick = profit[idx] + prevRow[W - weight[idx]];

                prevRow[W] = Math.max(pick, notPick);
            }
        }

        return prevRow[w];
    }
}
*/