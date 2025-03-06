import java.util.Scanner;

class palindromeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Which fibanocci number you need? ");
        int N = sc.nextInt();
        
        System.out.println("Fibanocci Number: " +fibanocciNumber(N));
    }

    static int fibanocciNumber(int N) {
        if(N <= 1) return N;
        
        return fibanocciNumber(N-1) + fibanocciNumber(N-2);
    }
}