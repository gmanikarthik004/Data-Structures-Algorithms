class NextPermutation {
    static int[] nextGreaterPermutation(int[] arr, int n) {
        // Step-1 Find Breakpoint
        int breakPt = -1;
        for(int i = n-2; i >= 0; i--) {
            if(arr[i] < arr[i+1]) {
                breakPt = i;
                break;
            }
        }
        // If still breakPt == -1, given permutation is the greatest
        if(breakPt == -1) return reverseArray(arr, 0, n);
        
        // Step-2 Find little greater element than breakPt and swap it
        for(int i = n-1; i > breakPt; i--) {
            if(arr[i] > arr[breakPt]) {
                int temp = arr[breakPt];
                arr[breakPt] = arr[i];
                arr[i] = temp;
                
                break;
            }
        }
        
        // Step-3 Place remaining elements in sorted order
        return reverseArray(arr, breakPt+1, n-1);
    }
    
    static int[] reverseArray(int[] arr, int start, int end) {
        while(start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            
            start++; end--;
        }
        return arr;
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 4, 3, 0, 0};
        int n = arr.length;
        
        int[] res = nextGreaterPermutation(arr, n);
        System.out.print("Next Greater Permutation: [ ");
        for(int i : res) {
            System.out.print(i + " ");
        }
        System.out.print("]");
    }
}