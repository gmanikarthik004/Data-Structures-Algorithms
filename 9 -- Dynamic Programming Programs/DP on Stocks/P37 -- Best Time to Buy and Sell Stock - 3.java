// RECURSION + MEMOIZATION: T.C: O(N * 2 * 3) && S.C: O(N) + O(N * 2 * 3)
/*
class Solution {
    public int findMax(int idx, int buy, int cap, int N, int[] prices, int dp[][][]) {
        if (cap == 0) return 0;
        if (idx == N) return 0;

        if (dp[idx][buy][cap] != -1) return dp[idx][buy][cap];

        int maxProfit = 0;
        if (buy == 1) {
            maxProfit = Math.max(-prices[idx] + findMax(idx + 1, 0, cap, N, prices, dp), 0 + findMax(idx + 1, 1, cap, N, prices, dp));
        }
        else {
            maxProfit = Math.max(prices[idx] + findMax(idx + 1, 1, cap-1, N, prices, dp), 0 + findMax(idx + 1, 0, cap, N, prices, dp));
        }
        return dp[idx][buy][cap] = maxProfit;
    }

    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length][2][3];
        for(int rows[][] : dp) {
            for(int row[] : rows)
                Arrays.fill(row, -1);
        }

        return findMax(0, 1, 2, prices.length, prices, dp);
    }
}
*/

// TABULATION: T.C: O(N * 2 * 3) && S.C: O(N * 2 * 3)
/*
class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int dp[][][] = new int[N + 1][2][3];

        // Capacity = 0, Idx && Buy(anything)
        for(int idx = 0; idx <= N; idx++) {
            for(int buy = 0; buy <= 1; buy++) {
                dp[idx][buy][0] = 0;
            }
        }

        // Idx == N, Buy && Cap(anything)
        for(int buy = 0; buy <= 1; buy++) {
            for(int cap = 0; cap <= 2; cap++) {
                dp[N][buy][cap] = 0;
            }
        }

        for(int idx = N - 1; idx >= 0; idx--) {
            for(int buy = 0; buy <= 1; buy++) {
                for(int cap = 1; cap <= 2; cap++) {
                    if (buy == 1) {
                        dp[idx][buy][cap] = Math.max(-prices[idx] + dp[idx + 1][0][cap], 0 + dp[idx + 1][1][cap]);
                    }
                    else {
                        dp[idx][buy][cap] = Math.max(prices[idx] + dp[idx + 1][1][cap - 1], 0 + dp[idx + 1][0][cap]);
                    }
                }
            }
        }

        return dp[0][1][2];
    }
}
*/

// SPACE-OPTIMIZATION: T.C: O(N * 2 * 3) && S.C: O(2 * 3)
/*
class Solution {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        int prevRow[][] = new int[2][3];
        int curRow[][] = new int[2][3];

        for(int idx = N - 1; idx >= 0; idx--) {
            for(int buy = 0; buy <= 1; buy++) {
                for(int cap = 1; cap <= 2; cap++) {
                    if (buy == 1) {
                        curRow[buy][cap] = Math.max(-prices[idx] + prevRow[0][cap], 0 + prevRow[1][cap]);
                    }
                    else {
                        curRow[buy][cap] = Math.max(prices[idx] + prevRow[1][cap - 1], 0 + prevRow[0][cap]);
                    }
                }
            }
            prevRow = curRow.clone();
        }

        return prevRow[1][2];
    }
}
*/

