import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Rearrange {
    // Variety-1 If No.of Positives == No.of Negatives => Optimal Solution
    /*
    public static ArrayList<Integer> rearrangeElements(int[] arr, int n) {
        // Pre-size the list for efficiency & fill with 0's
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));
        
        int posIdx = 0, negIdx = 1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > 0) {
                ans.set(posIdx, arr[i]);
                posIdx += 2;
            }
            else {
                ans.set(negIdx, arr[i]);
                negIdx += 2;
            }
        }
        
        return ans;
    }
    */

    // Variety-2 If No.of Positives != No.of Negatives => Brute Solution
    static ArrayList<Integer> rearrangeElements(int[] arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));
        
        // List for storing positives & negatives
        ArrayList<Integer> posInt = new ArrayList<>();
        ArrayList<Integer> negInt = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(arr[i] > 0) {
                posInt.add(arr[i]);
            }
            else {
                negInt.add(arr[i]);
            }
        }
        
        // Put them back into ansArrayList
        // Case-1 Positives > Negatives
        if(posInt.size() > negInt.size()) {
            // First push till negInt.size()
            for(int i = 0; i < negInt.size(); i++) {
                ans.set(2*i, posInt.get(i));
                ans.set(2*i + 1, negInt.get(i));
            }
            // Fill the remaining positives at the end
            int idx = 2 * negInt.size();
            for(int i = negInt.size(); i < posInt.size(); i++) {
                ans.set(idx, posInt.get(i));
                idx++;
            }
        } 
        else {
            // First push till posInt.size()
            for(int i = 0; i < posInt.size(); i++) {
                ans.set(2*i, posInt.get(i));
                ans.set(2*i + 1, negInt.get(i));
            }
            // Fill the remaining negatives at the end
            int idx = 2 * posInt.size();
            for(int i = posInt.size(); i < negInt.size(); i++) {
                ans.set(idx, negInt.get(i));
                idx++;
            }
        }
        
        // Case-2 Negatives > Positives
        return ans;
    }
    
    public static void main(String[] args) {
        // int[] arr = {3, 1, -2, -5, 2, -4}; // Input for variety-1
        int[] arr = {3, 1, -2, -5, 2, -4, 6, 10}; // Input for variety-2
        int n = arr.length;
        
        System.out.print("Before rearranging: " + Arrays.toString(arr));
        System.out.println();
        
        // ArrayList<Integer> res = rearrangeElements(arr, n); // Variety-1 Fn.
        ArrayList<Integer> res = rearrangeElements(arr, n); // Variety-2 Fn.
        
        System.out.print("After rearranging: " + res);
    }
}