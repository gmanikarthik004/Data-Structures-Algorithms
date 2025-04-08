import java.util.List;
import java.util.ArrayList;

class CombinationSum2 {
    public static void findCombinations(int idx, int[] arr, int target, List<List<Integer>> result, List<Integer> ds) {
        // Base Condition
        if(target == 0) {
            result.add(new ArrayList<>(ds));
            return;
        }
        // Pick
        for(int i = idx; i < arr.length; i++) {
            if(i > idx && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;
            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], result, ds);
            ds.remove(ds.size() - 1);
        }
    }
    
    public static void main(String args[]) {
        int[] arr = {1, 1, 1, 2, 2};
        int target = 4;
        
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