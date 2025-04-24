// RECURSION: T.C: (Exponential) && S.C: O(N + M) 
/*
class Solution {
    public boolean findMatch(int i, String text, int j, String pattern) {
        if(i < 0 && j < 0) return true;
        if(i >= 0 && j < 0) return false;
        if(i < 0 && j >= 0) {
            for(int k = 0; k <= j; k++) {
                if(pattern.charAt(k) != '*') return false;
            }
            return true;
        }

        if(pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '?') {
            return findMatch(i - 1, text, j - 1, pattern);
        }

        if(pattern.charAt(j) == '*') {
            return findMatch(i, text, j - 1, pattern) || findMatch(i - 1, text, j, pattern);
        }
        
        return false;
    }

    public boolean isMatch(String s, String p) {
        int N = s.length(), M = p.length();

        return findMatch(N-1, s, M-1, p);
    }
}
*/

// MEMOIZATION: T.C: O(N * M) && S.C: O(N * M) + O(N + M)
/*
class Solution {
    public boolean findMatch(int i, String text, int j, String pattern, int dp[][]) {
        if(i == 0 && j == 0) return true;
        if(i > 0 && j == 0) return false;
        if(i == 0 && j > 0) {
            for(int k = 1; k <= j; k++) {
                if(pattern.charAt(k - 1) != '*') return false;
            }
            return true;
        }

        if(dp[i][j] != -1) return dp[i][j] == 1;

        boolean ans;
        if(pattern.charAt(j - 1) == text.charAt(i - 1) || pattern.charAt(j - 1) == '?') {
            ans = findMatch(i - 1, text, j - 1, pattern, dp);
        }
        else if(pattern.charAt(j - 1) == '*') {
            ans = findMatch(i, text, j - 1, pattern, dp) || findMatch(i - 1, text, j, pattern, dp);
        }
        else {
            ans = false;
        }

        dp[i][j] = ans ? 1 : 0;
        return ans;
    }

    public boolean isMatch(String s, String p) {
        int N = s.length(), M = p.length();
        int[][] dp = new int[N + 1][M + 1];
        for (int[] row : dp) 
            Arrays.fill(row, -1);

        return findMatch(N, s, M, p, dp);
    }
}
*/

// TABULATION: T.C: O(N * M) && S.C: O(N * M)
/*
class Solution {
    public boolean isMatch(String s, String p) {
        int N = s.length(), M = p.length();
        boolean[][] dp = new boolean[N + 1][M + 1];

        dp[0][0] = true;
        
        // When pattern is empty
        for(int i = 1; i <= N; i++) dp[i][0] = false;

        // Pattern can match empty string only if it's all '*'
        for (int j = 1; j <= M; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill the dp
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if(p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
                else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[N][M];
    }
}
*/

// SPACE OPTIMIZATION: T.C: O(N * M) && S.C: O(M)
/*
class Solution {
    public boolean isMatch(String s, String p) {
        int N = s.length(), M = p.length();
        boolean prevRow[] = new boolean[M + 1];

        prevRow[0] = true;

        // Pattern can match empty string only if it's all '*'
        for (int j = 1; j <= M; j++) {
            if (p.charAt(j - 1) == '*') {
                prevRow[j] = prevRow[j - 1];
            }
        }

        // Fill the dp
        for(int i = 1; i <= N; i++) {
            boolean curRow[] = new boolean[M + 1];
            curRow[0] = false;
            for(int j = 1; j <= M; j++) {
                if(p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
                    curRow[j] = prevRow[j - 1];
                }
                else if(p.charAt(j - 1) == '*') {
                    curRow[j] = curRow[j - 1] || prevRow[j];
                }
                else {
                    curRow[j] = false;
                }
            }
            prevRow = curRow;
        }

        return prevRow[M];
    }
}
*/ 



