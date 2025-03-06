import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

class NumberHashing2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        System.out.print("Enter array elements: ");
        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }
        
        Map<Integer, Integer> mpp = new HashMap<>();
        for(int i=0; i<n; i++) {
            mpp.put(arr[i], mpp.getOrDefault(arr[i], 0)+1);
        }
        
        System.out.print("Enter no.of queries you have? ");
        int q = sc.nextInt();
        
        while(q-- != 0) {
            System.out.print("Enter your query: ");
            int query = sc.nextInt();
            System.out.println("Fetching...");
            System.out.println(mpp.getOrDefault(query, 0));
        }
        sc.close();
    }
}