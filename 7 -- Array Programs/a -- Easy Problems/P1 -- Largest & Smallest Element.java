class LargestAndSmallest {
    static int largestNumber(int[] arr, int n) {
        int largest = arr[0];
        for(int i : arr) {
            if(i > largest) {
                largest = i;
            }
        }
        return largest;
    }
    
    static int smallestNumber(int[] arr, int n) {
        int smallest = arr[0];
        for(int i : arr) {
            if(i < smallest) {
                smallest = i;
            }
        }
        return smallest;
    }
    
    public static void main(String[] args) {
        int arr[] = {4, 2, 29, 5, 30, 22};
        int n = arr.length;
        
        System.out.println("Largest Number: " + largestNumber(arr, n));
        System.out.println("Smallest Number: " + smallestNumber(arr, n));
    }
}