import java.util.*;

class Three_Sum {
    // BRUTE SOLUTION -- 3 FOR LOOPS + SET
    /*
    public static List<List<Integer>> findTriplet(int[] arr, int n) {
        Set<List<Integer>> st = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                for(int k = j+1; k < n; k++) {
                    if(arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        temp.sort(null);
                        st.add(temp);
                    }
                }
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
    */
    
    // BETTER SOLUTION -- 2 FOR LOOPS + HASHING + SET
    /*
    public static List<List<Integer>> findTriplet(int[] arr, int n) {
        Set<List<Integer>> st = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            Set<Integer> hSet = new HashSet<>();
            for(int j = i+1; j < n; j++) {
                // Calculate 3rd element
                int thirdE = -(arr[i] + arr[j]);
                
                if(hSet.contains(thirdE)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], thirdE);
                    temp.sort(null);
                    st.add(temp);
                }
                
                hSet.add(arr[j]);
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
    */
    
    // OPTIMAL SOLUTION -- 2 POINTERS && NO SET
    public static List<List<Integer>> findTriplet(int[] arr, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        
        for(int i = 0; i < n; i++) {
            // Skip duplicates
            if(i != 0 && arr[i] == arr[i-1]) continue;
            // 2 Pointers
            int j = i + 1;
            int k = n - 1;
            
            while(j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                // 3 Conditions
                if(sum > 0) {
                    k--;
                }
                else if(sum < 0) {
                    j++;
                }
                else{
                   List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                   ans.add(temp);
                   j++;
                   k--;
                   
                   // Skip duplicates
                   while(j < k && arr[j] == arr[j-1]) j++;
                   while(j < k && arr[k] == arr[k+1]) k--;
                }
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        int n = arr.length;
        
        List<List<Integer>> result = findTriplet(arr, n);
        System.out.println("Triplets are: ");
        for(List<Integer> it : result) {
            System.out.print("[ ");
            for(Integer i : it) {
                System.out.print(i+" ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }
}