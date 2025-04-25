// RECURSION + MEMOIZATION: T.C: O(N * 2) && S.C: O(N * 2) + O(N)
/*
import java.util.Arrays;
class Solution {
    public int getMaxProfit(int idx, int N, int buy, int[] prices, int dp[][]) {
        if(idx == N) return 0;

        if(dp[idx][buy] != -1) return dp[idx][buy];

        int maxProfit = 0;
        if(buy == 1) {
            maxProfit = Math.max(-prices[idx] + getMaxProfit(idx + 1, N, 0, prices, dp), getMaxProfit(idx + 1, N, 1, prices, dp));
        }
        else {
            maxProfit = Math.max(prices[idx] + getMaxProfit(idx + 1, N, 1, prices, dp), getMaxProfit(idx + 1, N, 0, prices, dp));
        }

        return dp[idx][buy] = maxProfit;
    }
    
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int dp[][] = new int[N][2];
        for(int row[] : dp)
            Arrays.fill(row, -1);

        return getMaxProfit(0, N, 1, prices, dp);
    }
}
*/

// TABULATION: T.C: O(N * 2) && S.C: O(N * 2)
/*
class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int dp[][] = new int[N + 1][2];

        dp[N][0] = dp[N][1] = 0;

        for(int idx = N - 1; idx >= 0; idx--) {
            for(int buy = 0; buy <= 1; buy++) {
                int maxProfit = 0;
                if(buy == 1) {
                    maxProfit = Math.max(-prices[idx] + dp[idx + 1][0], dp[idx + 1][1]);
                }
                else {
                    maxProfit = Math.max(prices[idx] + dp[idx + 1][1], dp[idx + 1][0]);
                }

                dp[idx][buy] = maxProfit; 
            }
        }

        return dp[0][1];
    }
}
*/

// SPACE OPTIMIZATION(Using 2 Arrays): T.C: O(N * 2) && S.C: O(2)
/*
class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int prevRow[] = new int[2];

        prevRow[0] = prevRow[1] = 0;

        for(int idx = N - 1; idx >= 0; idx--) {
            int curRow[] = new int[2];
            for(int buy = 0; buy <= 1; buy++) {
                int maxProfit = 0;
                if(buy == 1) {
                    maxProfit = Math.max(-prices[idx] + prevRow[0], prevRow[1]);
                }
                else {
                    maxProfit = Math.max(prices[idx] + prevRow[1], prevRow[0]);
                }

                curRow[buy] = maxProfit; 
            }
            prevRow = curRow;
        }

        return prevRow[1];
    }
}
*/

// SPACE OPTIMIZATION(Using 4 Variables): T.C: O(N) && S.C: O(1)
/*
class Solution {
    public int maxProfit(int[] prices) {
        int prevBuy = 0; // dp[idx + 1][1] — can buy
        int prevSell = 0; // dp[idx + 1][0] — must sell

        for (int idx = prices.length - 1; idx >= 0; idx--) {
            int curBuy = Math.max(-prices[idx] + prevSell, prevBuy);
            int curSell = Math.max(prices[idx] + prevBuy, prevSell);
            prevBuy = curBuy;
            prevSell = curSell;
        }

        return prevBuy;
    }
}
*/

// USING GREEDY-SOLUTION : T.C: O(N) && S.C: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        }

        return maxProfit;
    }
}