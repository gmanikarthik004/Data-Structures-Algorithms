import java.util.ArrayList;

class MergeSort {
    static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int leftPtr = low;
        int rightPtr = mid+1;
        
        while(leftPtr <= mid && rightPtr <= high) {
            if(arr[leftPtr] <= arr[rightPtr]) {
                temp.add(arr[leftPtr]);
                leftPtr++;
            }
            else {
                temp.add(arr[rightPtr]);
                rightPtr++;
            }
        }
        
        // Still elements are leftover
        while(leftPtr <= mid) {
            temp.add(arr[leftPtr]);
            leftPtr++;
        }
        
        while(rightPtr <= high) {
            temp.add(arr[rightPtr]);
            rightPtr++;
        }
        
        // Add temp into originalArray
        for(int i=low, j=0; i<=high; i++, j++) {
            arr[i] = temp.get(j);
        }
    }
    
    static void mergeSort(int[] arr, int low, int high) {
        if(low>=high) return; // Base-Case
        
        int mid = (low + high)/2;

        // Step-1 Divide
        mergeSort(arr, low, mid); // Left-Most
        mergeSort(arr, mid+1, high); // Right-Most
        // Step-2 Merge
        merge(arr, low, mid, high);
    }
    
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4, 1, 5, 2, 6, 4};
        int n = arr.length;
        
        System.out.print("Before Sorting: ");
        for(int i : arr) {
            System.out.print(i + " ");
        }
        
        System.out.println();
        // MergeSort
        mergeSort(arr, 0, n-1);
        
        System.out.print("After Sorting: ");
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}