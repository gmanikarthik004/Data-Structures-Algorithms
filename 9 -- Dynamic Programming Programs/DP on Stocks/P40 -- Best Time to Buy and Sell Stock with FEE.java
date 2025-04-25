// TABULATION: 
/*
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int N = prices.length;
        int dp[][] = new int[N + 1][2];

        for(int idx = N - 1; idx >= 0; idx--) {
            dp[idx][1] = Math.max(-prices[idx] + dp[idx + 1][0], dp[idx + 1][1]); // Buy
            dp[idx][0] = Math.max(prices[idx] - fee + dp[idx + 1][1], dp[idx + 1][0]); // Sell
        }

        return dp[0][1];
    }
}
*/