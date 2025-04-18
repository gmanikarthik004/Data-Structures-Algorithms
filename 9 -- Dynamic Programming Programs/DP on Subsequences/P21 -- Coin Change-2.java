// RECURSION: T.C: >O(2^N) && S.C: >O(N)
/*
class Solution {
    public int findWays(int idx, int amount, int[] coins) {
        if(idx == 0) {
            return (amount % coins[0] == 0)? 1 : 0;
        }
        int notTake = findWays(idx-1, amount, coins);
        int take = 0;
        if(coins[idx] <= amount) take = findWays(idx, amount - coins[idx], coins);

        return take + notTake;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        return findWays(n-1, amount, coins);
    }
}
*/

// MEMOIZATION: T.C: O(N * AMOUNT) && S.C: O(N * AMOUNT) + O(N)
/*
class Solution {
    public int findWays(int idx, int amount, int[] coins, int[][] dp) {
        if(idx == 0) {
            return (amount % coins[0] == 0)? 1 : 0;
        }

        if(dp[idx][amount] != -1) return dp[idx][amount];

        int notTake = findWays(idx-1, amount, coins, dp);
        int take = 0;
        if(coins[idx] <= amount) take = findWays(idx, amount - coins[idx], coins, dp);

        return dp[idx][amount] = take + notTake;
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return findWays(n-1, amount, coins, dp);
    }
}
*/

// TABULATION: T.C: O(N * AMOUNT) && S.C: O(N * AMOUNT)
/*
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        
        for(int A = 0; A <= amount; A++) {
            dp[0][A] = (A % coins[0] == 0) ? 1 : 0;
        }

        for(int idx = 1; idx < n; idx++) {
            for(int A = 0; A <= amount; A++) {
                int notPick = dp[idx-1][A];
                int pick = 0;
                if(coins[idx] <= A)
                    pick = dp[idx][A - coins[idx]];
                
                dp[idx][A] = pick + notPick;
            }
        }

        return dp[n-1][amount];
    }
}
*/

// SPACE-OPTIMIZATION: T.C: O(N * AMOUNT) && S.C: O(AMOUNT)
/*
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int prevRow[] = new int[amount + 1];
        
        for(int A = 0; A <= amount; A++) {
            prevRow[A] = (A % coins[0] == 0) ? 1 : 0;
        }

        for(int idx = 1; idx < n; idx++) {
            int curRow[] = new int[amount + 1];
            for(int A = 0; A <= amount; A++) {
                int notPick = prevRow[A];
                int pick = 0;
                if(coins[idx] <= A)
                    pick = curRow[A - coins[idx]];
                
                curRow[A] = pick + notPick;
            }
            prevRow = curRow;
        }

        return prevRow[amount];
    }
}
*/