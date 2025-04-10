// RECURSION-BASED SOLUTION -- T.C = O(2^N) S.C = O(N)
/*
class Fibanocci {
    public static int findFib(int N) {
        if(N <= 1) return N;
        return findFib(N - 1) + findFib(N - 2);
    }
    public static void main(String args[]) {
        int N = 5;
        
        System.out.println(N + "th Fibanocci Number: " + findFib(N));
    }
}
*/

// MEMOIZATION-BASED SOLUTION -- T.C = O(N) S.C = O(N) + O(N)
/*
import java.util.Arrays;

class Fibanocci {
    public static int findFib(int N, int[] dp) {
        if(N <= 1) return N;
        if(dp[N] != -1) return dp[N];
        return dp[N] = findFib(N - 1, dp) + findFib(N - 2, dp);
    }
    public static void main(String args[]) {
        int N = 5;
        int[] dp = new int[N + 1];
        Arrays.fill(dp, -1);
        
        System.out.println(N + "th Fibanocci Number: " + findFib(N, dp));
    }
}
*/

// TABULATION-BASED SOLUTION -- T.C = O(N) S.C = O(N)
/*
class Fibanocci {
    public static void main(String args[]) {
        int N = 5;
        int[] dp = new int[N + 1];
        
        // Base-case
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        System.out.println(N + "th Fibanocci Number: " + dp[N]);
    }
}
*/

// SPACE-OPTIMIZED SOLUTION -- T.C = O(N) S.C = O(1)
/*
class Fibanocci {
    public static void main(String args[]) {
        int N = 6;
        int firstPrev = 1, secondPrev = 0, currentVal; 
        for(int i = 2; i <= N; i++) {
            currentVal = firstPrev + secondPrev;
            secondPrev = firstPrev;
            firstPrev = currentVal;
        }
        
        System.out.println(N + "th Fibanocci Number: " + firstPrev);
    }
}
*/