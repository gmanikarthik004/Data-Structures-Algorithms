// Using HashMap

// Disclaimer: Works only for arrays with Positives & Negatives

import java.util.Map;
import java.util.HashMap;

class LongestSA {
    static int longestSA(int[] arr, int n, long k) {
        Map<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLength = 0;
        
        for(int i=0; i<n; i++) {
            //calculate the prefix sum till index i
            sum += arr[i];
            
            // if the sum = k, update the maxLen
            if(sum == k) {
               maxLength = Math.max(maxLength, i+1); 
            }
            
            // calculate the sum of remaining part i.e. x-k
            long rem = sum - k;
            if(preSumMap.containsKey(rem)) {
                // update maxLen
                int len = i - preSumMap.get(rem);
                maxLength = Math.max(maxLength, len);
            }
            
            // update map after checking conditions
            if(!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }
        return maxLength;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};
        int n = arr.length;
        long k = 3;
        
        System.out.println("Length of SA with given sum :"+longestSA(arr, n, k));
    }
}