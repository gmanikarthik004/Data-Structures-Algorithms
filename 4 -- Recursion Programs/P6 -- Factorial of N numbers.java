import java.util.Scanner;

class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = sc.nextInt();
        
        factorialFn(n, 1); // Call for M-1
        // System.out.println("Factorial:" + factorialFn(n)); // Call for M-2
    }
    
    // M-1 Parameterized Recursion
    static void factorialFn(int i, int fact) {
        if(i<1){
            System.out.println("Factorial: " + fact);
            return;
        }
        factorialFn(i-1, fact*i);
    }
    
    
    // M-2 Functional Recursion
    /*
    static int factorialFn(int n) {
        if(n == 0) return 1;

        return n * factorialFn(n-1);
    }
    */
}