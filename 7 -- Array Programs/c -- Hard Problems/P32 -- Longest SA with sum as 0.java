import java.util.Map;
import java.util.HashMap;

class SAwithSum0 {
    // Prefix-Sum Concept
    public static int findSA(int[] arr) {
        Map<Integer, Integer> hMap = new HashMap<>();
        
        int sum = 0, maxi = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            
            if(sum == 0) {
                maxi = Math.max(maxi, i+1);
            } else {
                // If prefixSum exists
                if(hMap.containsKey(sum)) {
                    maxi = Math.max(maxi, i - hMap.get(sum));
                } else {
                    hMap.put(sum, i);
                }
            }
        }
        
        return maxi;
    }
    
    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};
        
        System.out.println("Length of the largest SA with sum as 0: " + findSA(arr));
    }
}