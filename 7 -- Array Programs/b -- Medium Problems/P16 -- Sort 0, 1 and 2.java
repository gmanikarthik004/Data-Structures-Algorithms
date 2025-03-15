class DNFAlgo {
    static void sort012(int[] arr, int n) {
        int low = 0, mid = 0, high = n - 1;
        
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else { // arr[mid] == 2
                swap(arr, mid, high);
                high--;
            }
        }
    }
    
    static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
    
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0};
        int n = arr.length;
        
        System.out.println("Before Sorting the 0's, 1's and 2's: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        sort012(arr, n);
        
        System.out.println("After Sorting the 0's, 1's and 2's: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
