// RECURSION + MEMOIZATION: T.C: O(N * N) && S.C: O(N * N) + O(N)
/*
class Solution {
    public int findLIS(int idx, int prevIdx, int[] nums, int dp[][]) {
        if(idx == nums.length) return 0;

        if(dp[idx][prevIdx + 1] != -1) return dp[idx][prevIdx + 1];
        
        int longestSubseq = 0;
        longestSubseq = 0 + findLIS(idx + 1, prevIdx, nums, dp); // NotPick
        if(prevIdx == -1 || nums[idx] > nums[prevIdx])
            longestSubseq = Math.max(longestSubseq, 1 + findLIS(idx + 1, idx, nums, dp)); // Pick
        
        return dp[idx][prevIdx + 1] = longestSubseq;
    }
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int dp[][] = new int[N][N + 1];
        for(int row[] : dp)
            Arrays.fill(row, -1);
        
        return findLIS(0, -1, nums, dp);
    }
}
*/

// TABULATION: T.C: O(N * N) && S.C: O(N * N)
/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int dp[][] = new int[N + 1][N + 1];

        for(int idx = N - 1; idx >= 0; idx--) {
            for(int prevIdx = idx - 1; prevIdx >= -1; prevIdx--) {
                int longestSubseq = 0;
                longestSubseq = 0 + dp[idx + 1][prevIdx + 1]; // NotPick
                if(prevIdx == -1 || nums[idx] > nums[prevIdx])
                    longestSubseq = Math.max(longestSubseq, 1 + dp[idx + 1][idx + 1]); // Pick
                
                dp[idx][prevIdx + 1] = longestSubseq;
            }
        }

        return dp[0][0];
    }
}
*/

// SPACE-OPTIMIZATION: T.C: O(N * N) && S.C: O(N)
/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int prevRow[] = new int[N + 1];
        int curRow[] = new int[N + 1];

        for(int idx = N - 1; idx >= 0; idx--) {
            for(int prevIdx = idx - 1; prevIdx >= -1; prevIdx--) {
                int longestSubseq = 0;
                longestSubseq = 0 + prevRow[prevIdx + 1]; // NotPick
                if(prevIdx == -1 || nums[idx] > nums[prevIdx])
                    longestSubseq = Math.max(longestSubseq, 1 + prevRow[idx + 1]); // Pick
                
                curRow[prevIdx + 1] = longestSubseq;
            }
            prevRow = curRow.clone();
        }

        return prevRow[0];
    }
}
*/

// 2 LOOPS
/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        int N = nums.length, maxLength = 1;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for(int idx = 0; idx < N; idx++) {
            for(int prevIdx = 0; prevIdx < idx; prevIdx++) {
                if(nums[prevIdx] < nums[idx]) {
                    dp[idx] = Math.max(dp[idx], dp[prevIdx] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[idx]);
        }

        return maxLength;
    }
}
*/

