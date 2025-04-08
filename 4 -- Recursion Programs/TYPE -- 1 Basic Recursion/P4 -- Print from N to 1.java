import java.util.Scanner;

class Recursion_4 {
    // M-1 Using Recursion
    /*
    static void printN(int n, int i) {
        if(n < i) return;
        
        System.out.print(n + " ");
        
        printN(n-1, i);
    }
    */

    // Using Backtracking
    static void printN(int i, int n) {
        if(i > n) return;

        printN(i+1, n);
        System.out.print(i + " ");
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many times?");
        int n = sc.nextInt();
        
        // printN(n, 1); // For 1st-method
        printN(1, n); // For 2nd-method
    }
}