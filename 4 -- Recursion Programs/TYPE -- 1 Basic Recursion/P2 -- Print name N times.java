// T.C: O(N) & S.C(Stack Space): O(N)

import java.util.Scanner;

class Recursion_2 {
    static void printName(int i, int n) {
        if(i > n) return;
        
        System.out.println("Mani Karthik");
        
        printName(i+1, n);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many times?");
        int n = sc.nextInt();
        
        printName(1, n);

        sc.close();
    }
}