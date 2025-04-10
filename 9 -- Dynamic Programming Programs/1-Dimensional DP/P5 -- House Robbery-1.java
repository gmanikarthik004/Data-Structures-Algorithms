// RECURSION-BASED SOLUTION -- T.C = O(2^N) S.C = O(N)
/*
class Solution {
    public int findMaxAmt(int idx, int nums[]) {
        if(idx == 0) return nums[idx];
        if(idx < 0) return 0;
        int pickHouse = nums[idx] + findMaxAmt(idx-2, nums);
        int notPickHouse = 0 + findMaxAmt(idx-1, nums);

        return Math.max(pickHouse, notPickHouse);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        return findMaxAmt(n-1, nums);
    }
}
*/

// MEMOIZATION-BASED SOLUTION -- T.C = O(N) S.C = O(N) + O(N)
/*
import java.util.Arrays;
class Solution {
    public int findMaxAmt(int idx, int nums[], int dp[]) {
        if(idx == 0) return nums[idx];
        if(idx < 0) return 0;
        if(dp[idx] != -1) return dp[idx];
        int pickHouse = nums[idx] + findMaxAmt(idx-2, nums, dp);
        int notPickHouse = 0 + findMaxAmt(idx-1, nums, dp);

        return dp[idx] = Math.max(pickHouse, notPickHouse);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        return findMaxAmt(n-1, nums, dp);
    }
}
*/

// TABULATION-BASED SOLUTION -- T.C = O(N * K) S.C = O(N)
/*
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];

        dp[0] = nums[0];

        for(int idx = 1; idx < n; idx++) {
            int pickH = nums[idx];
            if(idx > 1) pickH += dp[idx-2];
            int notPickH = 0 + dp[idx-1];
            dp[idx] = Math.max(pickH, notPickH);
        }

        return dp[n-1];
    }
}
*/

// SPACE-OPTIMIZED SOLUTION -- T.C = O(N) S.C = O(1)
/*
class Solution {
    public int rob(int[] nums) {
        int prev2 = 0, prev1 = nums[0], curr;

        for(int idx = 1; idx < nums.length; idx++) {
            int pick = nums[idx];
            if(idx > 1) pick += prev2;
            int notPick = 0 + prev1;

            curr = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
*/
