// import java.util.ArrayList;

class MoveZeroesToEnd {
    // BRUTE FORCE
    /*
    static void moveZeroes(int[] arr, int n) {
        ArrayList<Integer> temp = new ArrayList<>();

        // Step-1 Move all non-zeroes to temp array
        for(int i=0; i<n; i++) {
            if(arr[i] != 0) {
                temp.add(arr[i]);
            }
        }

        // Step-2 Move elements from temp back to original array
        for(int i=0; i<temp.size(); i++) {
            arr[i] = temp.get(i);
        }

        // Step-3 Fill remaining with zeroes
        for(int i=temp.size(); i<n; i++) {
            arr[i] = 0;
        }
    }
    */

    // OPTIMAL SOLUTION
    static void moveZeroes(int[] arr, int n) {
        int j = -1;
        // Step-1 Find first zero-element idx
        for(int i=0; i<n; i++) {
            if(arr[i] == 0) {
                j = i;
                break;
            }
        }

        if(j==-1) return; // No zeroes
        
        // Step-2 Start processing from j+1
        for(int i=j+1; i<n; i++) {
            if(arr[i] != 0) {
                // swap arr[j] & arr[i]
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

                j++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        int n = arr.length;

        // moveZeroes(arr, n); // BruteForce
        moveZeroes(arr, n);

        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}