// RECURSION + MEMOIZATION: T.C: O(N * M) && S.C: O(N + M) + O(N * M) 
/*
class Solution {
    public static int findEDist(int i, String str1, int j, String str2, int dp[][]) {
        if(i == 0) return j;
        if(j == 0) return i;
        
        if(dp[i][j] != -1) return dp[i][j];

        if(str1.charAt(i - 1) == str2.charAt(j - 1))
            return dp[i][j] = 0 + findEDist(i - 1, str1, j - 1, str2, dp);
        else {
            int insert = 1 + findEDist(i, str1, j - 1, str2, dp);
            int delete = 1 + findEDist(i - 1, str1, j,str2, dp);
            int replace = 1 + findEDist(i - 1, str1, j - 1, str2, dp);

            return dp[i][j] = Math.min(replace, Math.min(insert, delete));
        }
    }
    public static int editDistance(String str1, String str2) {
        int N = str1.length(),  M = str2.length();
        int dp[][] = new int[N + 1][M + 1];
        for(int row[] : dp) Arrays.fill(row, -1);

        return findEDist(N, str1, M, str2, dp);
    }
}
*/

// TABULATION: T.C: O(N * M) && S.C: O(N * M)
/* 
class Solution {
    public static int editDistance(String str1, String str2) {
        int N = str1.length(),  M = str2.length();
        int dp[][] = new int[N + 1][M + 1];

        for(int j = 0; j <= M; j++) dp[0][j] = j;
        for(int i = 0; i <= N; i++) dp[i][0] = i;

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) 
                    dp[i][j] = dp[i - 1][j - 1];
                else 
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
            }
        }

        return dp[N][M];
    }
}
*/

// SPACE OPTIMIZATION(2-ARRAYS) : T.C: O(N * M) && S.C: O(M)
/*
class Solution {
    public static int editDistance(String str1, String str2) {
        int N = str1.length(),  M = str2.length();
        int prevRow[] = new int[M + 1];
        
        prevRow[0] = 0;
        for(int j = 0; j <= M; j++) prevRow[j] = j;

        for(int i = 1; i <= N; i++) {
            int curRow[] = new int[M + 1];
            curRow[0] = i;
            for(int j = 1; j <= M; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) 
                    curRow[j] = prevRow[j - 1];
                else 
                    curRow[j] = 1 + Math.min(prevRow[j - 1], Math.min(prevRow[j], curRow[j - 1]));
            }
            prevRow = curRow;
        }

        return prevRow[M];
    }
}
*/
 

