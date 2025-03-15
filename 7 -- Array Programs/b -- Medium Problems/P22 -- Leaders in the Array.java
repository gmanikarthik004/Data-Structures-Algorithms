import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

class LeadersInArray {
    static ArrayList<Integer> findLeader(int[] arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        int maxFromRight = arr[n - 1]; // Rightmost element is always a leader
        ans.add(maxFromRight);
        
        for (int i = n - 2; i >= 0; i--) { // Traverse from right to left
            if (arr[i] >= maxFromRight) { 
                maxFromRight = arr[i]; 
                ans.add(maxFromRight);
            }
        }
        
        // Reverse the list to maintain original order
        Collections.reverse(ans);
        return ans;
    }
    
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        int n = arr.length;
        
        System.out.println("Given array: " + Arrays.toString(arr)); 
        
        ArrayList<Integer> res = findLeader(arr, n);
        System.out.println("Leaders in the given array are: " + res);
    }
}
