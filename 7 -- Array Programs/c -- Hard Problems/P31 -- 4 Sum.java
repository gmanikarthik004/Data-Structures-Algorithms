import java.util.*;

class Four_Sum {
    // BRUTE SOLUTION -- 4 FOR LOOPS + SET
    /*
    public static List<List<Integer>> findQuadraplet(int[] arr, int n, int target) {
        Set<List<Integer>> st = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                for(int k = j+1; k < n; k++) {
                    for(int l = k+1; l < n; l++) {
                        long sum = (long)arr[i]+arr[j];
                        sum += arr[k];
                        sum += arr[l];
                        if(sum == target) {
                            List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                            temp.sort(null);
                            st.add(temp);
                        }
                    }
                }
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
    */
    
    // BETTER SOLUTION -- 3 FOR LOOPS + HASHSET + SET
    /*
    public static List<List<Integer>> findQuadraplet(int[] arr, int n, int target) {
        Set<List<Integer>> st = new HashSet<>();
        
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++) {
                Set<Long> hSet = new HashSet<>();
                for(int k = j+1; k < n; k++) {
                    long sum = (long)arr[i]+arr[j];
                    sum += arr[k];
                    
                    long fourthElement = target - sum;
                    if(hSet.contains(fourthElement)) {
                        // Make the Quadraplet
                        List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],(int)fourthElement);
                        temp.sort(null);
                        st.add(temp);
                    }
                    
                    hSet.add((long)arr[k]);
                }
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>(st);
        return ans;
    }
    */
    
    // OPTIMAL SOLUTION -- 2 FOR LOOPS + 3 POINTERS
    public static List<List<Integer>> findQuadraplet(int[] arr, int n, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(arr);
        
        for(int i = 0; i < n; i++) {
            if(i > 0 && arr[i] == arr[i - 1]) continue;
            for(int j = i + 1; j < n; j++) {
                if(j > i + 1 && arr[j] == arr[j-1]) continue;
                
                // Set 2 pointers
                int k = j+1;
                int l = n-1;
                
                while(k < l) {
                    long sum = (long)arr[i]+arr[j];
                    sum += arr[k];
                    sum += arr[l];
                    
                    if(sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(arr[l]);
                        ans.add(temp);
                        k++; l--;
                        
                        // skip the duplicates:
                        while (k < l && arr[k] == arr[k - 1]) k++;
                        while (k < l && arr[l] == arr[l + 1]) l--;
                    }
                    else if(sum > target) l--;
                    else k++;
                }
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int n = arr.length;
        int target = 9;
        
        List<List<Integer>> result = findQuadraplet(arr, n, target);
        System.out.println("Quadraplets are: ");
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