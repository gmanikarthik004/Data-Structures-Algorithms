import java.util.ArrayList;
// import java.util.Arrays;

class IntersectionOfArrays {
    // BRUTE FORCE
    /*
    static ArrayList<Integer> intersectionFunction(int[] a1, int n1, int[] a2, int n2) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        int[] visited = new int[n2];
        Arrays.fill(visited, 0);
        
        for(int i=0; i<n1; i++) {
            for(int j=0; j<n2; j++) {
                if(a1[i] == a2[j] && visited[j] == 0) {
                    ans.add(a2[j]);
                    visited[j] = 1;
                    break;
                }
                if(a2[j] > a1[i]) break;
            }
        }
        
        return ans;
    }
    */

    static ArrayList<Integer> intersectionFunction(int[] a1, int n1, int[] a2, int n2) {
        // Initialize the pointers
        int i = 0, j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(i<n1 && j<n2) {
            if(a1[i] < a2[j]) {
                i++;
            }
            else if(a1[i] > a2[j]) {
                j++;
            }
            else {
                ans.add(a1[i]);
                i++; j++;
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        int[] a1 = {1, 2, 2, 3, 3, 4, 5, 6};
        int[] a2 = {2, 3, 3, 5, 6, 6, 7};
        
        for(int i : a1) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i : a2) {
            System.out.print(i + " ");
        }
        
        System.out.println();
        ArrayList<Integer> res = intersectionFunction(a1, a1.length, a2, a2.length);
        System.out.println("Intersection of 2 Arrays: " + res);
    }
}