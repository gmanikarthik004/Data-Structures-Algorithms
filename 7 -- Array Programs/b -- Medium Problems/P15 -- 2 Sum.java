// BETTER APPROACH -- USING HASHMAP
// Disclaimer: Best for returning the indexes
/*
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

class TwoSum {
    static int[] twoSum(int[] arr, int target, int n) {
        int[] ans = {-1, -1}; // Initialize result array

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            int remNumber = target - num;

            // Check if complement exists in map
            if (map.containsKey(remNumber)) {
                ans[0] = map.get(remNumber);
                ans[1] = i;
                return ans; // Return immediately when a pair is found
                // return true;
            }

            // Store the current number and its index
            map.put(num, i);
        }
        return ans; // Return {-1, -1} if no pair is found
        // return false;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        // Type-1 To return indexes
        
        int[] res = twoSum(arr, target, arr.length);
        System.out.println(Arrays.toString(res)); // Expected Output: [0, 1]
        
        
        // Type-2 To return true/false
        // if(twoSum(arr, target, arr.length)) {
        //     System.out.println("Yes, there exists 2 no's that add upto the given target");
        // } else {
        //     System.out.println("No, there doesn't exist 2 no's that add upto the given target");
        // }
    }
}
*/

// OPTIMAL SOLUTION 
// Disclaimer: Best for returning true/false
import java.util.Arrays;

class TwoSum {
    static boolean twoSum(int[] arr, int target, int n) {
        Arrays.sort(arr);
        int left = 0, right = n-1;
        
        while(left < right) {
           int sum = arr[left] + arr[right];
           
           if(sum == target) return true;
           else if(sum < target) left++;
           else right--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        
        // Type-2 To return true/false
        if(twoSum(arr, target, arr.length)) {
            System.out.println("Yes, there exists 2 no's that add upto the given target");
        } else {
            System.out.println("No, there doesn't exist 2 no's that add upto the given target");
        }
    }
}



