// Repeatedly select the minElement & put it at it's correct position.

class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        
        System.out.print("Before Sorting: ");
        for(int i : arr) {
            System.out.print(i + " ");
        }
        
        System.out.println();
        
        // Selection Sort
        for(int i=0; i<=n-2; i++) {
            int mini = i;
            for(int j=i; j<=n-1; j++) {
                if(arr[j] < arr[i]) mini = j;
            }
            // Swap arr[i] & arr[mini]
            int temp = arr[i];
            arr[i] = arr[mini];
            arr[mini] = temp;
        }
       
        System.out.print("After Sorting: ");
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}