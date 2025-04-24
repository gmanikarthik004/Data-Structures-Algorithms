// TABULATION: T.C: O(N * M) && S.C: O(N * M)
/*
class Solution {
    public int longestPalindromeSubseq(String s) {
        String reverseString = new StringBuilder(s).reverse().toString();

        int N = s.length(), M = reverseString.length();

        int dp[][] = new int[N + 1][M + 1];

        for(int j = 0; j <= M; j++) dp[0][j] = 0;
        for(int i = 0; i <= N; i++) dp[i][0] = 0;

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(s.charAt(i - 1) == reverseString.charAt(j - 1)) 
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else 
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        
        return dp[N][M];
    }
}
*/

// SPACE-OPTIMIZATION: T.C: O(N * M) && S.C: O(M)
class Solution {
    public int longestPalindromeSubseq(String s) {
        String reverseString = new StringBuilder(s).reverse().toString();

        int N = s.length(), M = reverseString.length();

        int prevRow[] = new int[M + 1];

        for(int j = 0; j <= M; j++) prevRow[j] = 0;

        for(int i = 1; i <= N; i++) {
            int curRow[] = new int[M + 1];
            for(int j = 1; j <= M; j++) {
                if(s.charAt(i - 1) == reverseString.charAt(j - 1)) 
                    curRow[j] = 1 + prevRow[j - 1];
                else 
                    curRow[j] = Math.max(curRow[j - 1], prevRow[j]);
            }
            prevRow = curRow;
        }
        
        return prevRow[M];
    }
}