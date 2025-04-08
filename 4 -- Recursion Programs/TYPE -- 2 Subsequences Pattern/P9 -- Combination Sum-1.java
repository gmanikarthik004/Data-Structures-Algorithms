import java.util.List;
import java.util.ArrayList;

class CombinationSum1 {
    public static void findCombinations(int idx, int[] arr, int target, List<List<Integer>> result, List<Integer> ds) {
        int n = arr.length;
        // Base Case
        if(idx == n) {
            if(target == 0) {
                // Valid Combination
                result.add(new ArrayList<>(ds));
            }
            return;
        }
        // Pick
        if(arr[idx] <= target) {
            ds.add(arr[idx]);
            findCombinations(idx, arr, target - arr[idx], result, ds);
            ds.remove(ds.size() - 1);
        }
        // Not Pick
        findCombinations(idx + 1, arr, target, result, ds);
    }
    
    public static void main(String args[]) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;
        
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(0, arr, target, result, new ArrayList<>());
        
        System.out.print("Possible Combinations are: [");
        for(List<Integer> i : result) {
            System.out.print("[ ");
            for(int j : i) {
                System.out.print(j + " ");
            }
            System.out.print("]");
        }
        System.out.print("]");
    }
}