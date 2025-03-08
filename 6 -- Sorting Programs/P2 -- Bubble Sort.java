class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        
        System.out.print("Before Sorting: ");
        for(int i : arr) {
            System.out.print(i + " ");
        }
        
        System.out.println();
        
        // Insertion Sort
        for(int i=n-1; i>=1; i--) {
            int didSwap = 0;
            for(int j=0; j<=i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    // Swap the arr[j] & arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    didSwap++;
                }
            }
            if(didSwap == 0) {
               System.out.println("Kuch Swapping Nahi hua!! Bz already sorted...");
               break;
            }
        }
       
        System.out.print("After Sorting: ");
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}