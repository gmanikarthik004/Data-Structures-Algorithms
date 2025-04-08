import java.util.List;
import java.util.ArrayList;

class Subset2 {
    public static void findSubsets(int idx, int[] arr, List<List<Integer>> result, List<Integer> ds) {
        result.add(new ArrayList<>(ds));
        
        for(int i = idx; i < arr.length; i++) {
            if(i != idx && arr[i] == arr[i-1]) continue;
            ds.add(arr[i]);
            findSubsets(i + 1, arr, result, ds);
            ds.remove(ds.size() - 1);
        }
    }
    
    public static void main(String args[]) {
        int[] arr = {1, 2, 2};
        
        List<List<Integer>> result = new ArrayList<>();
        findSubsets(0, arr, result, new ArrayList<>());
        
        System.out.println("Unique Subsets are: ");
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