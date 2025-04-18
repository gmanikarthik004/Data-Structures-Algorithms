class Solution {
    public boolean subsetSum(int n, int k, int arr[]){
        boolean prev[] = new boolean[k+1];

        prev[0] = true;

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

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for(int i : nums) {
            totalSum += i;
        }

        if(totalSum % 2 != 0) return false; // Odd Sum

        return subsetSum(n, totalSum / 2, nums);
    }
}