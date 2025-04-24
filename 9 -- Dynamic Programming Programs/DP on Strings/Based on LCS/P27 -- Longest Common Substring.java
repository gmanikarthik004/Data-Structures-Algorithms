// TABULATION: T.C: O(N * M) && S.C: O(N * M)
/*
class Solution {
    public static int lcs(String str1, String str2){
        int N = str1.length(), M = str2.length();

        int dp[][] = new int[N + 1][M + 1];

        for(int j = 0; j <= M; j++) dp[0][j] = 0;
        for(int i = 0; i <= N; i++) dp[i][0] = 0;

        int longestSubstring = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    longestSubstring = Math.max(longestSubstring, dp[i][j]);
                }
                else dp[i][j] = 0;
            }
        }

        return longestSubstring;
    }
}
*/

// SPACE-OPTIMIZATION: T.C: O(N * M) && S.C: O(M)
class Solution {
    public static int lcs(String str1, String str2){
        int N = str1.length(), M = str2.length();

        int prevRow[] = new int[M + 1];

        for(int j = 0; j <= M; j++) prevRow[j] = 0;

        int longestSubstring = 0;
        for(int i = 1; i <= N; i++) {
            int curRow[] = new int[M + 1];
            for(int j = 1; j <= M; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    curRow[j] = 1 + prevRow[j-1];
                    longestSubstring = Math.max(longestSubstring, curRow[j]);
                }
                else curRow[j] = 0;
            }
            prevRow = curRow;
        }

        return longestSubstring;
    }
} 