// RECURSION + MEMOIZATION: TC: O(N * 2) && SC: O(N * 2) + O(N)
/*
class Solution {
    public int findMax(int idx, int buy, int N, int[] prices, int dp[][]) {
        if(idx >= N) return 0;

        if(dp[idx][buy] != -1) return dp[idx][buy];

        int maxProfit = 0;
        if(buy == 1) {
            maxProfit = Math.max(-prices[idx] + findMax(idx + 1, 0, N, prices, dp), 0 + findMax(idx + 1, 1, N, prices, dp));
        }
        else {
            maxProfit = Math.max(prices[idx] + findMax(idx + 2, 1, N, prices, dp), 0 + findMax(idx + 1, 0, N, prices, dp));
        }
        return dp[idx][buy] = maxProfit;
    }
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int dp[][] = new int[N][2];
        for(int row[] : dp)
            Arrays.fill(row, -1);

        return findMax(0, 1, N, prices, dp);
    }
}
*/

// TABULATION: TC: O(N * 2) && SC: O(N * 2)
/*
class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int dp[][] = new int[N + 2][2];

        for(int idx = N - 1; idx >= 0; idx--) {
            dp[idx][1] = Math.max(-prices[idx] + dp[idx + 1][0], 0 + dp[idx + 1][1]); // Buy
            dp[idx][0] = Math.max(prices[idx] + dp[idx + 2][1], 0 + dp[idx + 1][0]); // Sell
        }

        return dp[0][1];
    }
}
*/

// SPACE-OPTIMIZATION: TC: O(N * 2) && SC: O(2)
/*
class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int ahead1[] = new int[2]; // dp[idx + 1]
        int ahead2[] = new int[2]; // dp[idx + 2]
        int curr[] = new int[2];   // dp[idx]

        for (int idx = N - 1; idx >= 0; idx--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    curr[buy] = Math.max(-prices[idx] + ahead1[0], 0 + ahead1[1]);
                } else {
                    curr[buy] = Math.max(prices[idx] + ahead2[1], 0 + ahead1[0]);
                }
            }
            ahead2 = ahead1.clone();
            ahead1 = curr.clone();
        }

        return ahead1[1];
    }
}
*/