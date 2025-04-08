import java.util.List;
import java.util.ArrayList;

class CombinationSum3 {
    public static void findCombinations(int idx, int target, List<List<Integer>> result, List<Integer> ds, int k) {
        // Early Pruning
        if(target > 0 || ds.size() > k) return;
        // Base Condition
        if(target == 0 && ds.size() == k) {
            result.add(new ArrayList<>(ds));
            return;
        }

        for(int i = idx; i <= Math.min(9, target); i++) {
            ds.add(i);
            findCombinations(i + 1, target - i, result, ds, k);
            ds.remove(ds.size() - 1);
        }
    }
    
    public static void main(String args[]) {
        int k = 3;
        int n = 7;
        
        List<List<Integer>> result = new ArrayList<>();
        findCombinations(1, n, result, new ArrayList<>(), k);
        
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