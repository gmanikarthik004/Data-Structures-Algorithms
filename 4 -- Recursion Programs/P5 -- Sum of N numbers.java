import java.util.Scanner;

class Summation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = sc.nextInt();
        
        // sumFn(n, 0); // Call for M-1
        sumFn(n); // Call for M-2
    }
    
    // M-1 Parameterized Recursion
    /*
    static void sumFn(int i, int sum) {
        if(i<1){
            System.out.println("Sum: " + sum);
            return;
        }
        sumFn(i-1, sum+i);
    }
    */
    
    // M-2 Functional Recursion
    static int sumFn(int n) {
        if(n == 0) return 0;

        return n + sumFn(n-1);
    }
}