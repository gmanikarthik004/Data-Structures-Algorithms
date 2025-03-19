import java.util.Map;
import java.util.HashMap;

class XORofSA {
    public static int xorCount(int[] arr, int K) {
        Map<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);
        
        int maxCnt = 0, xor = 0;
        for(int i : arr) {
            // Add currentElement into the XOR
            xor ^= i;
            
            int target = xor ^ K;
            
            if(mpp.containsKey(target)) {
                maxCnt += mpp.get(target); // increment count
            }
            
            mpp.put(xor, mpp.getOrDefault(xor, 0) + 1);
        }
        return maxCnt;
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        int K = 6;
        
        System.out.println("No.of subarrays whose XOR equal to given XOR: " + xorCount(arr, K));
    }
}