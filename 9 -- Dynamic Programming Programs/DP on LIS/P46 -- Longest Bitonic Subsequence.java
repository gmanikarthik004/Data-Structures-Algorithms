class Solution {
    public static int longestBitonicSequence(int[] arr, int n) {
        int[] dp1 = new int[n]; // LIS from front      
        int[] dp2 = new int[n]; // LIS from back

        for(int idx = 0; idx < n; idx++) {
            dp1[idx] = 1;
            for(int prev = 0; prev < idx; prev++) {
                if(arr[idx] > arr[prev] && dp1[prev] + 1 > dp1[idx])
                    dp1[idx] = dp1[prev] + 1;
            }
        }

        for(int idx = n - 1; idx >= 0; idx--) {
            dp2[idx] = 1;
            for(int prev = n - 1; prev > idx; prev--) {
                if(arr[idx] > arr[prev] && dp2[prev] + 1 > dp2[idx])
                    dp2[idx] = dp2[prev] + 1;
            }
        }

        int maxLength = 1;
        for(int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, dp1[i] + dp2[i] - 1);
        }

        return maxLength;
    }
}