class SecondLargestAndSmallest {
    static int secondLN(int[] arr, int n) {
        int largest = arr[0], sLargest = -1;
        for(int i : arr) {
            if(i > largest) {
                sLargest = largest;
                largest = i;
            }
            else if(i < largest && i > sLargest) {
                sLargest = i;
            }
        }
        return sLargest;
    }
    
    static int secondSN(int[] arr, int n) {
        int smallest = arr[0], sSmallest = Integer.MAX_VALUE;
        for(int i : arr) {
            if(i < smallest) {
                sSmallest = smallest;
                smallest = i;
            }
            else if(i > smallest && i < sSmallest) {
                sSmallest = i;
            }
        }
        return sSmallest;
    }
    
    public static void main(String[] args) {
        int arr[] = {4, 2, 29, 5, 30, 22};
        int n = arr.length;
        
        System.out.println("Second Largest Number: " + secondLN(arr, n));
        System.out.println("Smallest Number: " + secondSN(arr, n));
    }
}