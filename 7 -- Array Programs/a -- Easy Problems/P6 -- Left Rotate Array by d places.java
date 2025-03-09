class LeftRotateByD {
    // Brute Force -- T.C -> O(n+d) && S.C -> O(d)
    /* 
    static void leftRotate(int[] arr, int n, int d) {
        d = d % n;
        
        // Step-1 Put d elements into temp -- O(d)
        int[] temp = new int[d];
        for(int i=0; i<d; i++) {
            temp[i] = arr[i];
        }
        
        // Step-2 Shifting -- O(n-d)
        for(int i=d; i<n; i++) {
            arr[i-d] = arr[i];
        }
        
        // Step-3 Put back into originalArray -- O(d)
        for(int i=n-d; i<n; i++) {
            arr[i] = temp[i-(n-d)];
        }
    }
    */

    // Optimal Solution
    static void reverseArray(int[] arr, int start, int end) {
        while(start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        int d = 3;
        d = d % n;
        
        // leftRotate(arr, n, d); // BruteForce

        reverseArray(arr, 0, d-1); // Reverse first d elements
        reverseArray(arr, d, n-1); // Reverse remaining n-d elements
        reverseArray(arr, 0, n-1); // Reverse the entire array

        // Right-Rotate for k times -- LeetCode
        /*
        reverseArray(nums, 0, n-k-1);
        reverseArray(nums, n-k, n-1);
        reverseArray(nums, 0, n-1);
        */
        
        System.out.print("After rotating: ");
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}