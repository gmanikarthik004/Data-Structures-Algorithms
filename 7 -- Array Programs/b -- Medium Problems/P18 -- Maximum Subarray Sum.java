class MaxSASum {
    public static int maxSubarraySum(int[] arr, int n) {
        int sum = 0, maxSum = Integer.MIN_VALUE;
        int start = 0, subarrayStart = -1, subarrayEnd = -1;
        
        for(int i=0; i<n; i++) {
            if(sum == 0) start = i;
            // Step-1 Add a[idx] to the sum
            sum += arr[i];
            // Step-2 Update curr MaxSum
            if(sum > maxSum) {
                maxSum = sum;
                subarrayStart = start;
                subarrayEnd = i;
            }
            // Step-3 Set sum = 0, if sum<0
            if(sum < 0) sum = 0;
        }

        // To display the subarray
        System.out.print("Subarray with maxSum: [ ");
        for(int i = subarrayStart; i <= subarrayEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]");
        System.out.println();

        // To consider even the sum of emptySubarray
        // uncomment this
        if(maxSum < 0) maxSum = 0;
        
        return maxSum;
    }

    public static void main(String args[]) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        int maxSum = maxSubarraySum(arr, n);
        System.out.println("The maximum subarray sum is: " + maxSum);
    }

}

