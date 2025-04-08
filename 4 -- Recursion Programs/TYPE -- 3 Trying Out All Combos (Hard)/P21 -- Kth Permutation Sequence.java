import java.util.List;
import java.util.ArrayList;

class KthPermutation {
    public static String findPermutation(int N, int K) {
        String seq = "";
        // Create N-1 sized list & Find its factorial
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;
        for(int i = 1; i < N; i++) {
            numbers.add(i);
            fact *= i;
        }
        numbers.add(N); // LastElement
        
        K = K - 1; // Bz 0-based indexing
        
        while(true) {
            seq = seq + numbers.get(K / fact);
            numbers.remove(K / fact);
            
            if(numbers.size() == 0) break;
            
            K = K % fact; // New K
            fact = fact / numbers.size(); // New fact
        }
        
        return seq;
    }
    public static void main(String args[]) {
        int N = 3; // [1, 2, 3, 4]
        int K = 3;
        
        System.out.println("The K-th permutation seq. : " + findPermutation(N, K));
    }
}