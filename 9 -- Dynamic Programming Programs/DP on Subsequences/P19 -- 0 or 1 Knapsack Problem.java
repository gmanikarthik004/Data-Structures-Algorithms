// RECURSION: T.C: O(2^N) && S.C: O(N)
/*
class Solution{
    static int findMaxValue(int idx, int maxWeight, int[] weight, int[] value) {
        if(idx == 0) {
            if(weight[0] <= maxWeight) return value[0];
            else return 0; 
        }
        int notTake = 0 + findMaxValue(idx-1, maxWeight, weight, value);
        int take = Integer.MIN_VALUE;
        if(weight[idx] <= maxWeight) 
            take = value[idx] + findMaxValue(idx-1, maxWeight - weight[idx], weight, value);
        
        return Math.max(take, notTake);
    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        return findMaxValue(n-1, maxWeight, weight, value);
    }
}
*/

// MEMOIZATION: T.C: O(N * MAXWEIGHT) && S.C: O(N * MAXWEIGHT) + O(N)
/*
import java.util.Arrays;
class Solution{
    static int findMaxValue(int idx, int maxWeight, int[] weight, int[] value, int dp[][]) {
        if(idx == 0) {
            if(weight[0] <= maxWeight) return value[0];
            else return 0; 
        }

        if(dp[idx][maxWeight] != -1) return dp[idx][maxWeight];
        
        int notTake = 0 + findMaxValue(idx-1, maxWeight, weight, value, dp);
        int take = Integer.MIN_VALUE;
        if(weight[idx] <= maxWeight) 
            take = value[idx] + findMaxValue(idx-1, maxWeight - weight[idx], weight, value, dp);
        
        return dp[idx][maxWeight] = Math.max(take, notTake);
    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int dp[][] = new int[n][maxWeight + 1];
        for(int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return findMaxValue(n-1, maxWeight, weight, value, dp);
    }
}
*/

// TABULATION: T.C: O(N * MAXWEIGHT) && S.C: O(N * MAXWEIGHT)
/*
class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int dp[][] = new int[n][maxWeight + 1];

        for(int i = weight[0]; i <= maxWeight; i++) dp[0][i] = value[0];

        for(int idx = 1; idx < n; idx++) {
            for(int k = 0; k <= maxWeight; k++) {
                int notPick = 0 + dp[idx-1][k];
                int pick = 0;
                if(weight[idx] <= k) pick = value[idx] + dp[idx-1][k-weight[idx]];

                dp[idx][k] = Math.max(notPick, pick); 
            }
        }

        return dp[n-1][maxWeight];
    }
}
*/

// SPACE OPTIMIZATION USING 2-ARRAYS: T.C: O(N * MAXWEIGHT) && S.C: O(MAXWEIGHT)
/*
class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int prevRow[] = new int[maxWeight + 1];

        for(int i = weight[0]; i <= maxWeight; i++) prevRow[i] = value[0];

        for(int idx = 1; idx < n; idx++) {
            int curRow[] = new int[maxWeight + 1];
            for(int k = 0; k <= maxWeight; k++) {
                int notPick = 0 + prevRow[k];
                int pick = 0;
                if(weight[idx] <= k) pick = value[idx] + prevRow[k-weight[idx]];

                curRow[k] = Math.max(notPick, pick); 
            }
            prevRow = curRow;
        }

        return prevRow[maxWeight];
    }
}
*/

// SPACE OPTIMIZATION USING 1-ARRAY: T.C: O(N * MAXWEIGHT) && S.C: O(MAXWEIGHT)
/*
class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int prevRow[] = new int[maxWeight + 1];

        for(int i = weight[0]; i <= maxWeight; i++) prevRow[i] = value[0];

        for(int idx = 1; idx < n; idx++) {
            for(int k = maxWeight; k >= 0; k--) {
                int notPick = 0 + prevRow[k];
                int pick = 0;
                if(weight[idx] <= k) pick = value[idx] + prevRow[k-weight[idx]];

                prevRow[k] = Math.max(notPick, pick); 
            }
        }

        return prevRow[maxWeight];
    }
}
*/