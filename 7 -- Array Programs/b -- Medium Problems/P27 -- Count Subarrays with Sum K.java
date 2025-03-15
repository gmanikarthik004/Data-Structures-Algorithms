import java.util.Map;
import java.util.HashMap;

class CountSubArrays {
    public static int cntSubArrays(int[] arr, int n, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        
        int prefixSum = 0, cnt = 0;
        mpp.put(0, 1);
        
        for(int i : arr) {
            // Add current element to prefixSum
            prefixSum += i;
            
            // Calculate x-k
            int remove = prefixSum - k;
            
            // Find cnt of x-k in mpp
            cnt += mpp.getOrDefault(remove, 0);
            
            mpp.put(prefixSum, mpp.getOrDefault(prefixSum, 0) + 1);
        }
        
        return cnt;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};
        int n = arr.length;
        int k = 3;
        
        System.out.println("No.of subarrays with given sum k: " + cntSubArrays(arr, n, k));
    }
}