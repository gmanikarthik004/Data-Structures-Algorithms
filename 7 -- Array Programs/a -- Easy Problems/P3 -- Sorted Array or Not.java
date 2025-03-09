class SortedArray {
    static boolean isSorted(int[] arr, int n) {
        for(int i=1; i<n; i++) {
            if(arr[i] >= arr[i-1]) {
                
            }
            else {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int arr[] = {5, 4, 3, 2, 1};
        int n = arr.length;
        
        if(isSorted(arr, n)) System.out.println("Yes, sorted!");
        else System.out.println("Not sorted!");
    }
}