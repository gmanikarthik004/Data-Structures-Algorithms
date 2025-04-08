import java.util.List;
import java.util.ArrayList;

class Subset2 {
    /* APPROACH-1
    public static void findPermutations(int[] nums, List<Integer> ds, boolean[] freq, List<List<Integer>>result) {
        if(ds.size() == nums.length) {
            result.add(new ArrayList<>(ds));
        }

        for(int i = 0; i < nums.length; i++) {
            if(!freq[i]) {
                ds.add(nums[i]);
                freq[i] = true;

                findPermutations(nums, ds, freq, result);

                freq[i] = false;
                ds.remove(ds.size() - 1);
            }
        }
    }
    */

    // APPROACH-2
    public static void findPermutations(int idx, int[] nums, List<List<Integer>>result) {
        // Base-Case
        if(idx == nums.length) {
            List<Integer> ds = new ArrayList <>();
            
            for(int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            
            result.add(new ArrayList<>(ds));
        }

        for(int i = idx; i < nums.length; i++) {
            swap(idx, i, nums);
            findPermutations(idx + 1, nums, result);
            swap(idx, i, nums);
        }
    }
    
    public static void swap(int start, int end, int[] nums) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
    
    public static void main(String args[]) {
        int[] nums = {1, 2, 3};
        
        List<List<Integer>> result = new ArrayList <>();

        findPermutations(0, nums, result);
        
        System.out.println("Unique Permutations: ");
        System.out.print("[ ");
        for(List<Integer> list : result) {
            System.out.print("[");
            for(int j : list) {
                System.out.print(j + " ");
            }
            System.out.print("]");
        }
        System.out.print(" ]");
    }
}