import java.util.Scanner;

class Recursion_3 {
    /* Method-1 Using Recursion
    static void printN(int i, int n) {
        if(i > n) return;
        
        System.out.print(i + " ");
        
        printN(i+1, n);
    }
    */

    // Method-2 Using Backtracking
    static void printN(int i, int n) {
        if(i < 1) return;

        printN(i-1, n);
        System.out.print(i + " ");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many times?");
        int n = sc.nextInt();
        
        // printN(1, n); // For 1st-method
        printN(n, n); // For 2nd-method
    }
}