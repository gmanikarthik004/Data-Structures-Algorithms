/* TABULATION BASED APPROACH: WORKS ONLY FOR NON-NEGATIVES
class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;

        int totalSum = 0;
        for(int num : nums) totalSum += num;

        int target = totalSum;

        // Subset Sum DP Function
        boolean dp[][] = new boolean[n][target + 1];
        for(int idx = 0; idx < n; idx++) dp[idx][0] = true;
        if(nums[0] <= target) dp[0][nums[0]] = true; // If idx = 0

        for(int idx = 1; idx < n; idx++) {
            for(int k = 1; k <= target; k++) {
                boolean notTake = dp[idx - 1][k];
                boolean take = false;
                if(nums[idx] <= k) 
                    take = dp[idx - 1][k - nums[idx]];
                
                dp[idx][k] = take || notTake;
            }
        }

        // return dp[n-1][target]; // Tells whether targets from 1 to N possible at n-1 idx
        
        // This question logic
        int minDifference = (int)1e8;
        for(int s1 = 0; s1 <= totalSum / 2; s1++) {
            if(dp[n - 1][s1]) {
                int s2 = totalSum - s1;
                minDifference = Math.min(minDifference, Math.abs(s2-s1));
            }
        }

        return minDifference;
    }
}
*/

// SPACE OPTIMIZATION
/*
class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;

        int totalSum = 0;
        for(int num : nums) totalSum += num;

        int target = totalSum;

        // Subset Sum DP Function
        boolean prev[] = new boolean[target + 1];
        for(int idx = 0; idx < n; idx++) prev[0] = true;
        if(nums[0] <= target) prev[nums[0]] = true; // If idx = 0

        for(int idx = 1; idx < n; idx++) {
            boolean curr[] = new boolean[target + 1];
            curr[0] = true;
            for(int k = 1; k <= target; k++) {
                boolean notTake = prev[k];
                boolean take = false;
                if(nums[idx] <= k) 
                    take = prev[k - nums[idx]];
                
                curr[idx][k] = take || notTake;
            }
            prev = curr;
        }

        // return dp[n-1][target]; // Tells whether targets from 1 to N possible at n-1 idx
        
        // This question logic
        int minDifference = (int)1e8;
        for(int s1 = 0; s1 <= totalSum / 2; s1++) {
            if(prev[s1]) {
                int s2 = totalSum - s1;
                minDifference = Math.min(minDifference, Math.abs(s2-s1));
            }
        }

        return minDifference;
    }
}
*/