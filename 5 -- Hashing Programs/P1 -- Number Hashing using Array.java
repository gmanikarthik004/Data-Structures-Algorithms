import java.util.Scanner;

class Hashing_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter array size: ");
        int N = sc.nextInt();
        
        int[] arr = new int[N];
        System.out.print("Print Array elements: ");
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        
        // HashArray/Freq Array -- Pre-Computing
        int[] hashArr = new int[13];
        for(int i=0; i<N; i++) {
            hashArr[arr[i]]+=1;
        }
        
        // Fetch userQueries
        System.out.print("Enter how many queries you have: ");
        int q = sc.nextInt();
        
        while(q-- != 0) {
            System.out.print("Enter your query: ");
            int num = sc.nextInt();
            System.out.println("Fetching...");
            System.out.println(hashArr[num]);
        }
        sc.close();
    }
}