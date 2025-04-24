class Solution {
    public void fillDP(String s1, int N, String s2, int M, int[][] dp) {
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
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int N = str1.length(), M = str2.length();

        int[][] dp = new int[N + 1][M + 1];

        // Fill the dp using LCS
        fillDP(str1, N, str2, M, dp);

        // Traverse the dp to find shortest superseq
        int i = N, j = M;
        String res = "";

        while(i > 0 && j > 0) {
            if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                res += str1.charAt(i - 1); // or res += str2.charAt(j - 1)
                i--; j--;
            }
            else if(dp[i][j - 1] > dp[i - 1][j]) {
                res += str2.charAt(j - 1);
                j--;
            }
            else {
                res += str1.charAt(i - 1);
                i--;
            }
        }

        while(i > 0) {
            res += str1.charAt(i - 1);
            i--;
        }

        while(j > 0) {
            res += str2.charAt(j - 1);
            j--;
        }

        return new StringBuilder(res).reverse().toString();
    }
}