import java.util.List;
import java.util.ArrayList;

class PrintSubsequences {
    public static void findSubsequence(int idx, int arr[], List<Integer> ans, List<List<Integer>> result) {
        int n = arr.length;
        
        // Base-Case
        if(idx >= n) {
            result.add(new ArrayList<>(ans));
            return;
        }
        
        ans.add(arr[idx]); // Pick the index
        findSubsequence(idx + 1, arr, ans, result);
        ans.remove(ans.size() - 1); // Not-Pick the index
        findSubsequence(idx + 1, arr, ans, result);
    }
    public static void main(String args[]) {
        int arr[] = {3, 1, 2};
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        System.out.println("Possible Subsequences are: ");
        findSubsequence(0, arr, ans, result);
        
        for(List<Integer> list : result) {
            System.out.println(list);
        }
    }
}