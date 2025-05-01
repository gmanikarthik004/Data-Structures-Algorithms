/*
import java.util.Arrays;
class Solution {
    static final int MOD = 1000000007;

    public static long findWays(int i, int j, String exp, int isTrue, Long[][][] dp) {
        if (i > j) return 0;

        if (i == j) {
            if (isTrue == 1)
                return exp.charAt(i) == 'T' ? 1 : 0;
            else
                return exp.charAt(i) == 'F' ? 1 : 0;
        }

        if (dp[i][j][isTrue] != null) return dp[i][j][isTrue];

        long ways = 0;

        for (int idx = i + 1; idx <= j - 1; idx += 2) {
            long LT = findWays(i, idx - 1, exp, 1, dp);
            long LF = findWays(i, idx - 1, exp, 0, dp);
            long RT = findWays(idx + 1, j, exp, 1, dp);
            long RF = findWays(idx + 1, j, exp, 0, dp);

            char ch = exp.charAt(idx);

            if (ch == '&') {
                if (isTrue == 1) {
                    ways = (ways + (LT * RT) % MOD) % MOD;
                } else {
                    ways = (ways + (LF * RF) % MOD + (LT * RF) % MOD + (LF * RT) % MOD) % MOD;
                }
            } else if (ch == '|') {
                if (isTrue == 1) {
                    ways = (ways + (LT * RT) % MOD + (LT * RF) % MOD + (LF * RT) % MOD) % MOD;
                } else {
                    ways = (ways + (LF * RF) % MOD) % MOD;
                }
            } else if (ch == '^') {
                if (isTrue == 1) {
                    ways = (ways + (LT * RF) % MOD + (LF * RT) % MOD) % MOD;
                } else {
                    ways = (ways + (LT * RT) % MOD + (LF * RF) % MOD) % MOD;
                }
            }
        }

        dp[i][j][isTrue] = ways;
        return ways;
    }


    public static int evaluateExp(String exp) {
        int N = exp.length();
        Long[][][] dp = new Long[N][N][2];

        return (int)findWays(0, N - 1, exp, 1, dp);
    }
}
*/

