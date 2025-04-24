// RECURSION + MEMOIZATION: T.C: O(N * M) && S.C: O(N * M) + O(N + M)
/* 
class Solution 
{
    public static int longestSeq(int idx1, String s1, int idx2, String s2, int dp[][]) {
        if(idx1 == 0 || idx2 == 0) return 0;

        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        
        if(s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1)) {
            return dp[idx1][idx2] = 1 + longestSeq(idx1 - 1, s1, idx2 - 1, s2, dp);
        }

        return dp[idx1][idx2] = Math.max(longestSeq(idx1 - 1, s1, idx2, s2, dp), longestSeq(idx1, s1, idx2 - 1, s2, dp));
    }
    public static int getLengthOfLCS(String str1, String str2)
    {
        int n = str1.length(), m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return longestSeq(n, str1, m, str2, dp);
    }
}
*/

// TABULATION: T.C: O(N * M) && S.C: O(N * M)
/*
class Solution 
{
    public static int getLengthOfLCS(String str1, String str2)
    {
        int n = str1.length(), m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        
        for(int j = 0; j <= m; j++) dp[0][j] = 0;        
        for(int i = 0; i <= n; i++) dp[i][0] = 0;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[n][m];
    }
}
*/

// SPACE OPTIMIZATION: T.C: O(N * M) && S.C: O(M)
/*
class Solution 
{
    public static int getLengthOfLCS(String str1, String str2)
    {
        int n = str1.length(), m = str2.length();
        int prevRow[] = new int[m + 1];
        
        for(int j = 0; j <= m; j++) prevRow[j] = 0;

        for(int i = 1; i <= n; i++) {
            int curRow[] = new int[m + 1];
            for(int j = 1; j <= m; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1))
                    curRow[j] = 1 + prevRow[j-1];
                else
                    curRow[j] = Math.max(prevRow[j], curRow[j - 1]);
            }
            prevRow = curRow;
        }

        return prevRow[m];
    }
}
*/