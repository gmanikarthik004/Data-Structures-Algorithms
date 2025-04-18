// RECURSION: T.C: >O(2^N) && S.C: >O(N)
/*
class Solution {
    public int minCoins(int idx, int amount, int[] coins) {
        if(idx == 0) {
            if(amount % coins[0] == 0) return amount/coins[0];
            else return (int)1e9;
        }

        int notPick = 0 + minCoins(idx - 1, amount, coins);
        int pick = Integer.MAX_VALUE;
        if(coins[idx] <= amount) pick = 1 + minCoins(idx, amount - coins[idx], coins);

        return Math.min(pick, notPick);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int ans = minCoins(n-1, amount, coins);
        if(ans >= 1e9) return -1;
        return ans;
    }
}
*/

// MEMOIZATION: T.C: O(N * AMOUNT) && S.C: O(N * AMOUNT) + O(N)
/*
import java.util.Arrays;
class Solution {
    public int minCoins(int idx, int amount, int[] coins, int dp[][]) {
        if(idx == 0) {
            if(amount % coins[0] == 0) return amount/coins[0];
            else return (int)1e9;
        }

        if(dp[idx][amount] != -1) return dp[idx][amount];
        
        int notPick = 0 + minCoins(idx - 1, amount, coins, dp);
        int pick = Integer.MAX_VALUE;
        if(coins[idx] <= amount) pick = 1 + minCoins(idx, amount - coins[idx], coins, dp);

        return dp[idx][amount] = Math.min(pick, notPick);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int dp[][] = new int[n][amount + 1];
        for(int row[] : dp) {
            Arrays.fill(row, -1);
        }

        int ans = minCoins(n-1, amount, coins, dp);
        if(ans >= 1e9) return -1;
        return ans;
    }
}
*/

// TABULATION: T.C: O(N * AMOUNT) && S.C: O(N * AMOUNT)
/*
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];

        for(int T = 0; T <= amount; T++) {
            if(T % coins[0] == 0) 
                dp[0][T] = T / coins[0];
            else 
                dp[0][T] = (int) 1e9;
        }

        for(int idx = 1; idx < n; idx++) {
            for(int T = 0; T <= amount; T++) {
                int notPick = 0 + dp[idx - 1][T];
                int pick = Integer.MAX_VALUE;
                if(coins[idx] <= T) pick = 1 + dp[idx][T - coins[idx]];

                dp[idx][T] = Math.min(pick, notPick);
            }
        }

        if(dp[n-1][amount] >= (int) 1e9) return -1;
        else return dp[n-1][amount];
    }
}
*/

// SPACE-OPTIMIZATION: T.C: O(N * AMOUNT) && S.C: O(AMOUNT)
/*
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int prevRow[] = new int[amount + 1];

        for(int T = 0; T <= amount; T++) {
            if(T % coins[0] == 0) 
                prevRow[T] = T / coins[0];
            else 
                prevRow[T] = (int) 1e9;
        }

        for(int idx = 1; idx < n; idx++) {
            int curRow[] = new int[amount + 1];
            for(int T = 0; T <= amount; T++) {
                int notPick = 0 + prevRow[T];
                int pick = Integer.MAX_VALUE;
                if(coins[idx] <= T) pick = 1 + curRow[T - coins[idx]];

                curRow[T] = Math.min(pick, notPick);
            }
            prevRow = curRow;
        }

        if(prevRow[amount] >= (int) 1e9) return -1;
        else return prevRow[amount];
    }
}
*/

