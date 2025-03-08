class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {14, 9, 15, 12, 6, 8, 13};
        int n = arr.length;
        
        System.out.print("Before Sorting: ");
        for(int i : arr) {
            System.out.print(i + " ");
        }
        
        System.out.println();
        
        // Insertion Sort
        for(int i=0; i<n; i++) {
            int j=i;
            
            while(j>0 && arr[j-1]>arr[j]) {
                // swap arr[j-1] & arr[j]
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
                
                j--;
            }
        }
       
        System.out.print("After Sorting: ");
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}