class CommonSq {
    static String findLCS(int n, int m, String s1, String s2){
        int dp[][] = new int[n + 1][m + 1];

        for(int j = 0; j <= m; j++) dp[0][j] = 0;
        for(int i = 0; i <= n; i++) dp[i][0] = 0;

        // Fill the dp table
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        int longestLCS = dp[n][m];
        char[] lcs = new char[longestLCS];
        int idx = longestLCS - 1;

        int i = n, j = m;
        while(i > 0 && j > 0) {
            if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs[idx] = s1.charAt(i - 1);
                idx--;

                i--; j--;
            } 
            else if(dp[i][j - 1] > dp[i - 1][j]) {
                j--;
            } 
            else {
                i--;
            }
        }

        return new String(lcs);
    }

    public static void main(String[] args) {
        String s1 = "abcde", s2 = "bdgek";
        System.out.println("Longest Common Subsequence: " + findLCS(s1.length(), s2.length(), s1, s2));
    }
}