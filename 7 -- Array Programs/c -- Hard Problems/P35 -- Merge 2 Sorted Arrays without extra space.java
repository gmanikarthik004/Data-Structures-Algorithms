import java.util.*;

class Merge2SortedArrays {
    // BRUTE SOLUTION -- T.C: 2 * O(N+M) && S.C: O(N+M)
    /*
    public static void mergeArrays(int[] a1, int n, int[] a2, int m) {
        int[] a3 = new int[n+m];
        int left = 0, right = 0, idx = 0;
        
        // Put into a3
        while(left < n && right < m) {
            if(a1[left] <= a2[right]) {
                a3[idx++] = a1[left++];
            } else {
                a3[idx++] = a2[right++];
            }
        }
        
        // Leftover elements in a1
        while(left < n) {
            a3[idx++] = a1[left++];
        }
        
        // Leftover elements in a2
        while(right < m) {
            a3[idx++] = a2[right++];
        }
        
        // Put back into a1 && a2
        for(int i = 0; i < a3.length; i++) {
            if(i < n) a1[i] = a3[i];
            else a2[i-n] = a3[i];
        }
    }
    */ 

    // OPTIMAL SOLUTION - 1
    /*
    public static void mergeArrays(int[] a1, int n, int[] a2, int m) {
        int left = n - 1; // Of a1[]
        int right = 0; // Of a2[]
        
        while(left >= 0 && right < m) {
            if(a1[left] > a2[right]) {
                // Swap a1[left] && a2[right]
                int temp = a1[left];
                a1[left] = a2[right];
                a2[right] = temp;
                
                left--; right++;
            }
            else {
                break; // Already sorted order
            }
        }
        
        Arrays.sort(a1);
        Arrays.sort(a2);
    }
    */

    // OPTIMAL SOLUTION - 2 => USING GAP METHOD OF SHELL SORT
    public static void mergeArrays(int[] a1, int n, int[] a2, int m) {
        // Find the initial gap
        int length = n + m;
        int gap = (length / 2) + (length % 2); // Take ceil
        
        while(gap > 0) {
            // 2 pointers
            int leftPtr = 0;
            int rightPtr = leftPtr + gap;
            
            // Compare leftPtr && rightPtr
            while(rightPtr < length) {
                // 3 Conditions
                // left in arr1 and right in arr2
                if(leftPtr < n && rightPtr >= n) {
                    swapFn(a1, a2, leftPtr, rightPtr - n);
                }
                // Both in arr2 and arr2
                else if(leftPtr >= n) {
                    swapFn(a2, a2, leftPtr - n, rightPtr - n);
                }
                // Both in arr1 and arr1
                else {
                    swapFn(a1, a1, leftPtr, rightPtr);
                }
                leftPtr++; rightPtr++;
            }
            if(gap == 1) break;
            gap = gap / 2 + gap % 2;
        }
    }
    
    public static void swapFn(int[] a1, int[] a2, int idx1, int idx2) {
        if(a1[idx1] > a2[idx2]) {
            // Swap ele1 & ele2
            int temp = a1[idx1];
            a1[idx1] = a2[idx2];
            a2[idx2] = temp;
        }
    }
    public static void main(String[] args) {
        int a1[] = {1, 3, 5, 7}, n = a1.length;
        int a2[] = {0, 2, 6, 8, 9}, m = a2.length;
        
        mergeArrays(a1, n, a2, m);
        
        System.out.println("After merging: ");
        System.out.println("Array 1: " + Arrays.toString(a1));
        System.out.println("Array 2: " + Arrays.toString(a2));
    }
}

