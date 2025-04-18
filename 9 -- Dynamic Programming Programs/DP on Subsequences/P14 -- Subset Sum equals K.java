// RECURSION SOLUTION: T.C: O(2^N) && S.C: O(N)
/*
class Solution {
    public static boolean isPossible(int idx, int target, int[] arr) {
        // Base-Case
        if(target == 0) return true;
        if(idx == 0) return arr[idx] == target;

        boolean notPick = isPossible(idx - 1, target, arr);        
        boolean pick = false;
        if(arr[idx] <= target) 
            pick = isPossible(idx - 1, target - arr[idx], arr);

        return pick || notPick;
    }
    public static boolean subsetSumToK(int n, int k, int arr[]){
        return isPossible(n-1, k, arr);
    }
}
*/

// MEMOIZATION SOLUTION: T.C: O(N*K) && S.C: O(N*K) + O(N)
/*
class Solution {
    public static boolean isPossible(int idx, int target, int[] arr, int[][] dp) {
        // Base-Case
        if(target == 0) return true;

        if(idx == 0) return arr[idx] == target;

        if(dp[idx][target] != -1) return dp[idx][target] == 1;

        boolean notPick = isPossible(idx - 1, target, arr, dp);        
        boolean pick = false;
        if(target >= arr[idx]) 
            pick = isPossible(idx - 1, target - arr[idx], arr, dp);
        
        dp[idx][target] = (pick || notPick)? 1 : 0;

        return dp[idx][target] == 1;

    }
    public static boolean subsetSumToK(int n, int k, int arr[]){
        int dp[][] = new int[n][k+1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return isPossible(n-1, k, arr, dp);
    }
}
*/

// TABULATION SOLUTION: T.C: O(N*K) && S.C: O(N*K)
/*
class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean[][] dp = new boolean[n][k+1];

        // If target == 0
        for(int idx = 0; idx < n; idx++) dp[idx][0] = true;

        // Only if arr[0] <= k
        if(arr[0] <= k) dp[0][arr[0]] = true;

        for(int idx = 1; idx < n; idx++) {
            for(int target = 1; target <= k; target++) {
                boolean notPick = dp[idx - 1][target];        
                boolean pick = false;
                if(arr[idx] <= target) 
                    pick = dp[idx - 1][target - arr[idx]];
                
                dp[idx][target] = pick || notPick;
            }
        }

        return dp[n-1][k];
    }
}
*/

// SPACE OPTIMIZED SOLUTION: T.C: O(N*K) && S.C: O(K)
/*
class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean prev[] = new boolean[k+1];

        prev[0] = true;

        // Only if arr[0] <= k
        if(arr[0] <= k) prev[arr[0]] = true;

        for(int idx = 1; idx < n; idx++) {
            boolean curr[] = new boolean[k+1];
            curr[0] = true;
            for(int target = 1; target <= k; target++) {
                boolean notPick = prev[target];        
                boolean pick = false;
                if(arr[idx] <= target) 
                    pick = prev[target - arr[idx]];
                
                curr[target] = pick || notPick;
            }
            prev = curr;
        }

        return prev[k];
    }
}
*/

