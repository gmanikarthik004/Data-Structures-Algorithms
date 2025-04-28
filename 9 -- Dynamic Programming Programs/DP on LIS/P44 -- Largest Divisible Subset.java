import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int[] hash = new int[nums.length];

        int maxLen = 1, lastIdx = 0;
        for(int idx = 1; idx < nums.length; idx++) {
            hash[idx] = idx;
            for(int prevIdx = 0; prevIdx < idx; prevIdx++) {
                if(nums[idx] % nums[prevIdx] == 0 && dp[prevIdx] + 1 > dp[idx]) {
                    dp[idx] = dp[prevIdx] + 1;
                    hash[idx] = prevIdx;
                }
            }
            if(dp[idx] > maxLen) {
                maxLen = dp[idx];
                lastIdx = idx;
            }
        }

        List<Integer> res = new ArrayList<>();
        res.add(nums[lastIdx]);

        while(hash[lastIdx] != lastIdx) {
            lastIdx = hash[lastIdx];
            res.add(nums[lastIdx]);
        }

        Collections.reverse(res);
        return res;
    }
}
