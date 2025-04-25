// RECURSION + MEMOIZATION: T.C: O(N * 2 * 3) && S.C: O(N * 2 * 3) + O(N)
/*
import java.util.Arrays;
class Solution {
    public int findMax(int idx, int buy, int k, int[] prices, int dp[][][]) {
        if(k == 0) return 0;
        if(idx == prices.length) return 0;

        if(dp[idx][buy][k] != -1) return dp[idx][buy][k];

        int maxProfit = 0;
        if(buy == 1) {
            maxProfit = Math.max(-prices[idx] + findMax(idx + 1, 0, k, prices, dp), 0 + findMax(idx + 1, 1, k, prices, dp));
        } else {
            maxProfit = Math.max(prices[idx] + findMax(idx + 1, 1, k-1, prices, dp), 0 + findMax(idx + 1, 0, k, prices, dp));
        }
        
        return dp[idx][buy][k] = maxProfit;
    }

    public int maxProfit(int k, int[] prices) {
        int dp[][][] = new int[prices.length][2][k+1];
        for(int rows[][] : dp) {
            for(int row[] : rows)
                Arrays.fill(row, -1);
        }
        return findMax(0, 1, k, prices, dp);
    }
}
*/

// TABULATION: T.C: O(N * 2 * 3) && S.C: O(N * 2 * 3)
/*
class Solution {
    public int maxProfit(int k, int[] prices) {
        int N = prices.length;
        int dp[][][] = new int[N + 1][2][k + 1];

        // If k = 0, idx & buy(can be anything)
        for(int idx = 0; idx <= N; idx++) {
            for(int buy = 0; buy <= 1; buy++) {
                dp[idx][buy][0] = 0;
            }
        }

        // If idx = 0, buy & k(can be anything)
        for(int buy = 0; buy <= 1; buy++) {
            for(int cap = 0; cap <= k; cap++) {
                dp[N][buy][cap] = 0;
            }
        }

        for(int idx = N - 1; idx >= 0; idx--) {
            for(int buy = 0; buy <= 1; buy++) {
                for(int cap = 1; cap <= k; cap++) {
                    if(buy == 1) {
                        dp[idx][buy][cap] = Math.max(-prices[idx] + dp[idx + 1][0][cap], 0 + dp[idx + 1][1][cap]);
                    } 
                    else {
                        dp[idx][buy][cap] = Math.max(prices[idx] + dp[idx + 1][1][cap - 1], 0 + dp[idx + 1][0][cap]);
                    }
                }
            }
        }

        return dp[0][1][k];
    }
}
*/

// SPACE-OPTIMIZATION: T.C: O(N * 2 * 3) && S.C: O(2 * 3)
/*
class Solution {
    public int maxProfit(int k, int[] prices) {
        int N = prices.length;
        int prevRow[][] = new int[2][k + 1];
        int currRow[][] = new int[2][k + 1];

        for(int idx = N - 1; idx >= 0; idx--) {
            for(int buy = 0; buy <= 1; buy++) {
                for(int cap = 1; cap <= k; cap++) {
                    if(buy == 1) {
                        currRow[buy][cap] = Math.max(-prices[idx] + prevRow[0][cap], 0 + prevRow[1][cap]);
                    } 
                    else {
                        currRow[buy][cap] = Math.max(prices[idx] + prevRow[1][cap - 1], 0 + prevRow[0][cap]);
                    }
                }
            }
            prevRow = currRow.clone();
        }

        return prevRow[1][k];
    }
}
*/


