// USING DP
/*
class Solution {
    public int findLongestPalindrome(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();

        int N = s1.length(), M = s2.length();
        int dp[][] = new int[N+1][M+1];

        for(int j = 0; j <= M; j++) dp[0][j] = 0;
        for(int i = 0; i <= N; i++) dp[i][0] = 0;

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[N][M];
    }
    public int minInsertions(String s) {
        int strLength = s.length();
        int longestPalindrome = findLongestPalindrome(s);

        return strLength - longestPalindrome;
    }
}
*/

// USING SPACE-OPTIMIZATION
class Solution {
    public int findLongestPalindrome(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();

        int N = s1.length(), M = s2.length();
        int prevRow[] = new int[M+1];

        for(int j = 0; j <= M; j++) prevRow[j] = 0;

        for(int i = 1; i <= N; i++) {
            int curRow[] = new int[M+1];
            for(int j = 1; j <= M; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    curRow[j] = 1 + prevRow[j - 1];
                else
                    curRow[j] = Math.max(curRow[j - 1], prevRow[j]);
            }
            prevRow = curRow;
        }
        return prevRow[M];
    }
    public int minInsertions(String s) {
        int strLength = s.length();
        int longestPalindrome = findLongestPalindrome(s);

        return strLength - longestPalindrome;
    }
}