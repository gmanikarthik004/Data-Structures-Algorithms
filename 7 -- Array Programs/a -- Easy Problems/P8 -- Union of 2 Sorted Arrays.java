/* 
// BRUTE FORCE
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Main {
    static int[] unionOfArrays(int[] a1, int n1, int[] a2, int n2) {
        Set<Integer> st = new HashSet<Integer>();
        
        // Step-1 Traverse over array1
        for(int i=0; i<n1; i++) {
            st.add(a1[i]);
        }
        // Traverse over array2
        for(int i=0; i<n2; i++) {
            st.add(a2[i]);
        }
        
        // Step-2 Create union and push elements to it
        int[] union = new int[st.size()];
        int idx = 0;
        for(int num : st) {
            union[idx++] = num;
        }
        return union;
    }
    
    public static void main(String[] args) {
        int[] a1 = {1, 1, 2, 3, 4, 5};
        int[] a2 = {2, 3, 4, 4, 5, 6};
        
        int[] result = unionOfArrays(a1, a1.length, a2, a2.length);
        System.out.println("Union of 2 Arrays: " + Arrays.toString(result));
    }
}
*/

// OPTIMAL SOLUTION
import java.util.ArrayList;

class UnionOfArrays {
    static ArrayList<Integer> unionOfArrays(int[] a1, int n1, int[] a2, int n2) {
        // Set the pointers for both arrays
        int i = 0, j = 0;
        // ArrayList to store the union
        ArrayList<Integer> union = new ArrayList<>();
        
        while(i < n1 && j < n2) {
            if(a1[i] < a2[j]) {
                addToUnion(union, a1[i]);
                i++;
            }
            else if(a1[i] > a2[j]) {
                addToUnion(union, a2[j]);
                j++;
            }
            else { // Both are equal
               addToUnion(union, a1[i]);
               i++; j++; 
            }
        }
        
        // If still elements are left in any of array
        while(i < n1) {
            addToUnion(union, a1[i]);
            i++;
        }
        while(j < n2) {
            addToUnion(union, a2[j]);
            j++;
        }
        
        return union;
    }
    
    static void addToUnion(ArrayList<Integer> union, int num) {
        if(union.isEmpty() || union.get(union.size() - 1) != num) {
            union.add(num);
        }
    }
    
    public static void main(String[] args) {
        int[] a1 = {1, 1, 2, 3, 4, 5};
        int[] a2 = {2, 3, 4, 4, 5, 6};
        
        for(int i : a1) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i : a2) {
            System.out.print(i + " ");
        }
        
        System.out.println();
        ArrayList<Integer> result = unionOfArrays(a1, a1.length, a2, a2.length);
        System.out.println("Union of 2 Arrays: " + result);
    }
}