// RECURSION: T.C: O(2^N) && S.C: O(N) 
/*
class Solution {
    static int MOD = (int)1e9 + 7;
    public static int subsetCnt(int idx, int tar, int num[]) {
        if(idx == 0) {
            if(tar == 0 && num[0] == 0) return 2; // choose or not choose
            if(tar == 0 || num[0] == tar) return 1;
            return 0;
        }

        int notTake = subsetCnt(idx - 1, tar, num);
        int take = 0;
        if(num[idx] <= tar) take = subsetCnt(idx - 1, tar - num[idx], num);

        return (take + notTake) % MOD;
    }
    public static int findWays(int num[], int tar) {
        int n = num.length;
        return subsetCnt(n-1, tar, num);
    }
}
*/

// MEMOIZATION: T.C: O(N * TARGET) && S.C: O(N * K) + O(N)
/*
class Solution {
    static int MOD = (int)1e9 + 7;

    public static int subsetCnt(int idx, int tar, int num[], int dp[][]) {
        // Base Case
        if(idx == 0) {
            if(tar == 0 && num[0] == 0) return 2; // choose or not choose
            if(tar == 0 || num[0] == tar) return 1;
            return 0;
        }

        if(dp[idx][tar] != -1) return dp[idx][tar];

        int notTake = subsetCnt(idx - 1, tar, num, dp);
        int take = 0;
        if(num[idx] <= tar) take = subsetCnt(idx - 1, tar - num[idx], num, dp);

        return dp[idx][tar] = (take + notTake) % MOD;
    }
    public static int findWays(int num[], int tar) {
        int n = num.length;

        int dp[][] = new int[n][tar + 1];
        for(int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return subsetCnt(n-1, tar, num, dp);
    }
}
*/

// TABULATION: T.C: O(N * TARGET) && S.C: O(N * K)
/*
class Solution {
    static int MOD = (int)1e9 + 7;

    public static int findWays(int num[], int tar) {
        int n = num.length;
        int dp[][] = new int[n][tar + 1];

        for(int idx = 0; idx < n; idx++) dp[idx][0] = 1;
        if(num[0] <= tar) dp[0][num[0]] = 1;

        // Fill the dp table for the rest of the elements
        for (int idx = 1; idx < n; idx++) {
            for (int k = 0; k <= tar; k++) {
                int notTake = dp[idx - 1][k];
                int take = 0;
                if(num[idx] <= k) {
                    take = dp[idx - 1][k - num[idx]];
                }

                dp[idx][k] = (take + notTake) % MOD;
            }
        }

        // The result will be in the bottom-right corner of the DP table
        return dp[n - 1][tar];
    }
}
*/

// SPACE OPTIMIZATION: T.C: O(N * TARGET) && S.C: O(TARGET)
/*
class Solution {
    static int MOD = (int)1e9 + 7;

    public static int findWays(int num[], int tar) {
        int n = num.length;
        int prev[] = new int[tar + 1];

        prev[0] = 1;
        if(num[0] <= tar) prev[num[0]] = 1;

        // Fill the dp table for the rest of the elements
        for (int idx = 1; idx < n; idx++) {
            int curr[] = new int[tar + 1];
            curr[0] = 0;
            for (int k = 0; k <= tar; k++) {
                int notTake = prev[k];
                int take = 0;
                if(num[idx] <= k) {
                    take = prev[k - num[idx]];
                }

                curr[k] = (take + notTake) % MOD;
            }
            prev = curr;
        }

        // The result will be in the bottom-right corner of the DP table
        return prev[tar];
    }
}
*/
