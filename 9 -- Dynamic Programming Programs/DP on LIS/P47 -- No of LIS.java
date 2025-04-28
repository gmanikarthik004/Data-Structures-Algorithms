class Solution {
    public int findNumberOfLIS(int[] nums) {
        int N = nums.length;

        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int[] cnt = new int[N];
        Arrays.fill(cnt, 1);

        int maxi = 1;
        for(int idx = 1; idx < N; idx++) {
            for(int prev = 0; prev < idx; prev++) {
                if(nums[idx] > nums[prev]) {
                    if(dp[prev] + 1 > dp[idx]) {
                        dp[idx] = dp[prev] + 1;
                        cnt[idx] = cnt[prev];
                    }
                    else if(dp[prev] + 1 == dp[idx]) {
                        cnt[idx] += cnt[prev];
                    }
                }
                maxi = Math.max(maxi, dp[idx]);
            }
        }

        int cntWays = 0;
        for(int i = 0; i < N; i++) {
            if(dp[i] == maxi) {
                cntWays += cnt[i];
            }
        }

        return cntWays;
    }
}