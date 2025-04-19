// Same as previous, P5, but here houses are in circle, i.e 1st && Last houses are
// adjacent to each other

class Solution {
    public int findMaxAmt(int[] nums) {
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
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0]; // Single-Element

        int[] temp1 = new int[n-1]; // Exclude FirstElement
        for(int i = 1; i < n; i++) {
            temp1[i-1] = nums[i];
        }
        int[] temp2 = new int[n-1]; // Exclude LastElement
        for(int i = 0; i < n-1; i++) {
            temp2[i] = nums[i];
        }

        return Math.max(findMaxAmt(temp1), findMaxAmt(temp2));
    }
}