import java.util.ArrayList;
import java.util.Collections;

class SubsetSum1 {
    public static void findSubsets(int idx, int[] arr, ArrayList<Integer> result, int sum) {
        // Base-case
        if(idx == arr.length) {
            result.add(sum);
            return;
        }
        // Pick
        findSubsets(idx + 1, arr, result, sum + arr[idx]);
        // Don't Pick
        findSubsets(idx + 1, arr, result, sum);
    }
    
    public static void main(String args[]) {
        int[] arr = {1, 2, 1};
        
        ArrayList<Integer> result = new ArrayList <>();
        int sum = 0;
        findSubsets(0, arr, result, sum);
        Collections.sort(result);
        
        System.out.println("Subsets Sum: ");
        System.out.print("[ ");
        for(int i : result) {
            System.out.print(i + " ");
        }
        System.out.print("]");
    }
}