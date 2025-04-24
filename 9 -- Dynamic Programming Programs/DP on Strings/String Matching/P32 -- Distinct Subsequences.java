// RECURSION: T.C: O(2^N * 2^M) && S.C: O(N + M)
/*
class Solution {
	public static int cntDistinct(int i, int j, String S, String T) {
		if(j < 0) return 1;
		if(i < 0) return 0;
		
		if(S.charAt(i) == T.charAt(j)) {
			return cntDistinct(i - 1, j - 1, S, T) + cntDistinct(i - 1, j, S, T);
		}
		else
			return cntDistinct(i - 1, j, S, T);
	}
	public static int numDistinct(String S, String T) {
		int N = S.length(), M = T.length();
		return cntDistinct(N - 1, M - 1, S, T);
	}
}
*/

// MEMOIZATION: T.C: O(N * M) && S.C: O(N + M) + O(N * M)
/*
class Solution {
	public static int cntDistinct(int i, int j, String S, String T, int[][] dp) {
		if(j == 0) return 1;
		if(i == 0) return 0;
		
		if(dp[i][j] != -1) return dp[i][j];

		if(S.charAt(i - 1) == T.charAt(j - 1)) {
			return dp[i][j] = cntDistinct(i - 1, j - 1, S, T, dp) + cntDistinct(i - 1, j, S, T, dp);
		}
		else
			return dp[i][j] = cntDistinct(i - 1, j, S, T, dp);
	}
	public static int numDistinct(String S, String T) {
		int N = S.length(), M = T.length();
		int[][] dp = new int[N + 1][M + 1];
		for(int row[] : dp) {
			Arrays.fill(row, -1);
		}

		return cntDistinct(N, M, S, T, dp);
	}
}
*/

// TABULATION: T.C: O(N * M) && S.C: O(N * M)
/*
class Solution {
	public static int numDistinct(String S, String T) {
		int N = S.length(), M = T.length();
		int[][] dp = new int[N + 1][M + 1];
		
		for(int i = 0; i <= N; i++) dp[i][0] = 1;
		for(int j = 1; j <= M; j++) dp[0][j] = 0;

		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if(S.charAt(i - 1) == T.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				}
				else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[N][M];
	}
}
*/

// SPACE OPTIMIZATION (2-Arrays): T.C: O(N * M) && S.C: O(M)
/*
class Solution {
	public static int numDistinct(String S, String T) {
		int N = S.length(), M = T.length();
		int prev[] = new int[M + 1];
		
		prev[0] = 1;

		for(int i = 1; i <= N; i++) {
			int cur[] = new int[M + 1];
			cur[0] = 1;
			for(int j = 1; j <= M; j++) {
				if(S.charAt(i - 1) == T.charAt(j - 1)) {
					cur[j] = prev[j - 1] + prev[j];
				}
				else {
					cur[j] = prev[j];
				}
			}
			prev = cur;
		}

		return prev[M];
	}
}
*/

// SPACE OPTIMIZATION (1-Array): T.C: O(N * M) && S.C: O(M)
/*
class Solution {
	public static int numDistinct(String S, String T) {
		int N = S.length(), M = T.length();
		int prev[] = new int[M + 1];
		
		prev[0] = 1;

		for(int i = 1; i <= N; i++) {
			for(int j = M; j >= 1; j--) {
				if(S.charAt(i - 1) == T.charAt(j - 1)) {
					prev[j] = prev[j - 1] + prev[j];
				}
			}
		}

		return prev[M];
	}
}
*/
