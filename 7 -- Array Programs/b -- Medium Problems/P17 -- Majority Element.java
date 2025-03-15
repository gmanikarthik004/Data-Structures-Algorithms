// OPTIMAL SOLUTION
class MajorityElement {
    static int majorityElement(int[] arr, int n) {
        int eleCount = 0, currEle = 0;
        for(int i : arr) {
            if(eleCount == 0) {
                eleCount = 1;
                currEle = i;
            }
            else if(i == currEle) eleCount++;
            else eleCount--;
        }
        
        // return currEle; // if guranteed that maxEle do exist
        // Track the maxEle
        int cnt = 0;
        for(int i : arr) {
            if(i == currEle) cnt++;
        }
        if(cnt > n/2) return currEle;
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 2, 1, 3, 3, 2, 2};
        int n = arr.length;
        
        System.out.println("Majority Element occuring >n/2 times: " + majorityElement(arr, n));
    }
}

// BETTER SOLUTION
/*
import java.util.Map;
import java.util.HashMap;

class MajorityElement {
    static int majorityElement(int[] arr, int n) {
        Map<Integer, Integer> mpp = new HashMap<>();
        
        for(int i=0; i<n; i++) {
            int val = mpp.getOrDefault(arr[i], 0);
            mpp.put(arr[i], val+1);
        }
        
        for(Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if(it.getValue() > n/2) {
                return it.getKey();
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 2, 1, 3, 3, 2, 2};
        int n = arr.length;
        
        System.out.println("Majority Element occuring >n/2 times: " + majorityElement(arr, n));
    }
}
*/