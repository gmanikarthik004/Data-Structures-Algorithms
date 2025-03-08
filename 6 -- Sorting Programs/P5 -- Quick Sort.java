class QuickSortClass {
    static int partitionFn(int[] arr, int low, int high) {
        int pivotElement = arr[low]; // Pivot is selected as the first element
        int i = low; // `i` should start from `low`
        int j = high; // `j` should start from `high`
        
        while (i < j) {
            while (arr[i] <= pivotElement && i < high) { // Fix: i should be < high
                i++;
            }
            while (arr[j] > pivotElement && j > low) { // Fix: j should be > low
                j--;
            }
            if (i < j) { // Swap only if i < j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Swap pivot with arr[j]
        arr[low] = arr[j];
        arr[j] = pivotElement;
        
        return j; // Return the partition index
    }
    
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionElement = partitionFn(arr, low, high);
            quickSort(arr, low, partitionElement - 1); // Left Part
            quickSort(arr, partitionElement + 1, high); // Right Part
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 5, 7, 8, 1, 3};
        int n = arr.length;
        
        System.out.print("Before Sorting: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // QuickSort Fn
        quickSort(arr, 0, n - 1);
        
        System.out.print("After Sorting: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
