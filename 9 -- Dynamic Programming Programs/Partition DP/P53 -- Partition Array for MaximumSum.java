// RECURSON + MEMOIZATION: T.C: O(N * K) && S.C: O(N) + O(N)
/*
class Solution {
    public int maxSum(int idx, int[] arr, int k, int[] dp) {
        int N = arr.length;
        if(idx == N) return 0;

        if(dp[idx] != -1) return dp[idx];
        
        int length = 0, maxElement = Integer.MIN_VALUE, maxSum = 0;
        for(int j = idx; j < Math.min(idx + k, N); j++) {
            length++;
            maxElement = Math.max(maxElement, arr[j]);
            int sum = (length * maxElement) + maxSum(j + 1, arr, k, dp);
            maxSum = Math.max(maxSum, sum);
        }

        return dp[idx] = maxSum;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int N = arr.length;
        int[] dp = new int[N];
        Arrays.fill(dp, -1);

        return maxSum(0, arr, k, dp);
    }
}
*/

// TABULATION: T.C: O(N * K) && S.C: O(N)
/*
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int N = arr.length;
        int[] dp = new int[N + 1];

        dp[N] = 0;

        for(int idx = N - 1; idx >= 0; idx--) {
            int length = 0, maxElement = Integer.MIN_VALUE, maxSum = 0;
            for(int j = idx; j < Math.min(idx + k, N); j++) {
                length++;
                maxElement = Math.max(maxElement, arr[j]);
                int sum = (length * maxElement) + dp[j + 1];
                maxSum = Math.max(maxSum, sum);
            }

            dp[idx] = maxSum;
        }

        return dp[0];
    }
}
*/

