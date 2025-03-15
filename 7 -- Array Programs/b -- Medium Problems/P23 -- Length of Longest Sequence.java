// import java.util.Arrays;
import java.util.HashSet;

class LongestSequence {
    // OPTIMAL SOLUTION
    static int findLongestSequence(int[] arr, int n) {
        HashSet<Integer> hSet = new HashSet<>();
        for(int i : arr) {
            hSet.add(i);
        }
        
        int largestSeq = 1;
        for(int it : hSet) {
            // Check if it is start of an sequence
            if(!hSet.contains(it - 1)) {
                int x = it;
                int curCnt = 1;
                
                while(hSet.contains(x + 1)) {
                    curCnt++;
                    x += 1;
                }
                
                largestSeq = Math.max(largestSeq, curCnt);
            }
        }
        
        return largestSeq;
    }
    
    // BRUTE SOLUTION
    /*
    static int findLongestSequence(int[] arr, int n) {
        Arrays.sort(arr);
        
        int currMax = 0, longestSeq = 1, lastSmallest = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(arr[i] - 1 == lastSmallest) { // Part-of-seq
               currMax += 1;
               lastSmallest = arr[i];
            } 
            else if(arr[i] == lastSmallest) continue;
            else if(arr[i] != lastSmallest) { // Not-part-of-seq
                currMax = 1;
                lastSmallest = arr[i];
            }
            
            longestSeq = Math.max(longestSeq, currMax);
        }
        
        return longestSeq;
    }
    */
    
    public static void main(String[] args) {
        int[] arr = {100, 102, 100, 101, 101, 4, 3, 2, 2, 1, 1, 1, 103};
        int n = arr.length;
        
        System.out.println("Length of the longest consecutive sequence: " + findLongestSequence(arr, n));
    }
}