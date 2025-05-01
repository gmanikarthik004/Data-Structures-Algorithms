// RECURSION + MEMOIZATION: T.C: O(N^2) && S.C: O(N) + O(N)S.Space
/*
import java.util.Arrays;
class Solution {
    public int findMinCuts(int i, int N, String s, int[] dp) {
        if(i == N) return -1;

        if(dp[i] != -1) return dp[i];
        
        int minCuts = Integer.MAX_VALUE;
        for(int j = i; j < N; j++) {
            if(isPalindrome(i, j, s)) {
                int cost = 1 + findMinCuts(j + 1, N, s, dp);
                minCuts = Math.min(minCuts, cost);
            }
        }

        return dp[i] = minCuts;
    }

    public boolean isPalindrome(int left, int right, String str) {
        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++; right--;
        }
        return true;
    }

    public int minCut(String s) {
        int N = s.length();
        int[] dp = new int[N];
        Arrays.fill(dp, -1);

        return findMinCuts(0, N, s, dp);
    }
}
*/

// TABULATION: T.C: O(N ^ 2) && S.C: O(N)
/*
class Solution {
    public boolean isPalindrome(int left, int right, String str) {
        while(left < right) {
            if(str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++; right--;
        }
        return true;
    }
    public int minCut(String s) {
        int N = s.length();
        int[] dp = new int[N + 1];

        dp[N] = -1;

        for(int i = N - 1; i >= 0; i--) {
            int minCuts = Integer.MAX_VALUE;
            for(int j = i; j < N; j++) {
                if(isPalindrome(i, j, s)) {
                    int cost = 1 + dp[j + 1];
                    minCuts = Math.min(minCuts, cost);
                }
            }

            dp[i] = minCuts;  
        }
        return dp[0];
    }
}
*/
