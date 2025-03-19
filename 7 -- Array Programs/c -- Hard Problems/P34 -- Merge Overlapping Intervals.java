import java.util.*;

class MergeIntervals {
    // BRUTE FORCE -- T.C: O(N logN) + O(2N) && SC: O(N)
    /*
    public static List<List<Integer>> mergeOverLappingIntervals(int[][] arr) {
        // Sort the array based on start time
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            int startInterval = arr[i][0], endInterval = arr[i][1];
            
            // Skip the already mergedIntervals
            if(!ans.isEmpty() && endInterval <= ans.get(ans.size()-1).get(1)) continue;
            
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j][0] <= endInterval) {
                    // Extend the range
                    endInterval = Math.max(endInterval, arr[j][1]);
                } else {
                    break;
                }
            }
            ans.add(Arrays.asList(startInterval,endInterval));
        }
        return ans;
    }
    */
    
    // OPTIMAL SOLUTION -- T.C: O(N logN) + O(N) && SC: O(N)
    public static List<List<Integer>> mergeOverLappingIntervals(int[][] arr) {
        // Sort the array based on start time
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        
        List<List<Integer>> ans = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(ans.isEmpty() || arr[i][0] > ans.get(ans.size()-1).get(1)) {
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            } else {
                ans.get(ans.size()-1).set(1, Math.max(ans.get(ans.size()-1).get(1), arr[i][1]));
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,6},{8,9},{9,11},{8,10},{2,4},{15,18},{16,17}};
        
        List<List<Integer>> result = mergeOverLappingIntervals(arr);
        System.out.print("Merged Intervals: [ ");
        for(List<Integer> it : result) {
            System.out.print("[" + it.get(0) + "," + it.get(1) + "] ");
        }
        System.out.print("]");
    }
}