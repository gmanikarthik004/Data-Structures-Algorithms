import java.util.Arrays;

class ArraysClass {
    public static void main(String[] args) {
        int[] arr_1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        // M-1 BinarySearch
        System.out.println("BinarySearch: "+Arrays.binarySearch(arr_1, 7));
        
        // M-2 Sort
        Integer[] arr_2 = { 10, 2, 32, 12, 15, 76, 17, 48, 79, 9 };
        Arrays.sort(arr_2);
        
        System.out.println("Sorted Array:");
        for(int i : arr_2) {
            System.out.print(i + " ");
        }
        
        System.out.println();
        
        // M-3 Fill
        System.out.println("After fill:");
        Arrays.fill(arr_2, 10);
        for(int i : arr_2) {
            System.out.print(i + " ");
        }
    }
}