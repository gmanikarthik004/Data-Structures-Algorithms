// Using 2-Pointers

// Disclaimer: Works only for arrays with Positives & 0's
class LongestSA {
    static int longestSA(int[] arr, int n, long k) {
        // Declare 2 Pointers
        int left = 0, right = 0;
        long sum = arr[0];
        int maxLength = 0;
        
        while(right < n) {
            // Cond: 1 If sum>k, trim it from left to right until it becomes <= K
            while(left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }
            
            // Cond: 2 If sum==k, update maxLength
            if(sum == k) {
                maxLength = Math.max(maxLength, right-left+1);
            }
            
            // Move forward in the array
            right++;
            if(right < n) sum += arr[right];
        }
        
        return maxLength;
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 0, 0, 3};
        int n = arr.length;
        long k = 3;
        
        System.out.println("Length of SA with given sum: "+longestSA(arr, n, k));
    }
}