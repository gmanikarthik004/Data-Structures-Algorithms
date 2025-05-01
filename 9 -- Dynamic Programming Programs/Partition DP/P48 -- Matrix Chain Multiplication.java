// RECURSION: EXPONENTIAL && S.C: O(N)
/*
class Solution {
	public static int minCost(int i, int j, int[] arr) {
		if(i == j) return 0;

		int mini = (int)1e9;
		for(int k = i; k <= j - 1; k++) {
			int steps = arr[i - 1] * arr[k] * arr[j] + minCost(i, k, arr) + minCost(k + 1, j, arr);
			mini = Math.min(mini, steps);
		}
		return mini;
	}
	public static int matrixMultiplication(int[] arr , int N) {
		return minCost(1, N - 1, arr);
	}
}
*/

// MEMOIZATION: T.C: O(N^3) && S.C: O(N) + O(N*N)
/*
import java.util.Arrays; 

public class Solution {
	public static int minCost(int i, int j, int[] arr, int dp[][]) {
		if(i == j) return 0;

		if(dp[i][j] != -1) return dp[i][j];
		
		int mini = (int)1e9;
		for(int k = i; k <= j - 1; k++) {
			int steps = arr[i - 1] * arr[k] * arr[j] + minCost(i, k, arr, dp) + minCost(k + 1, j, arr, dp);
			mini = Math.min(mini, steps);
		}
		return dp[i][j] = mini;
	}
	
	public static int matrixMultiplication(int[] arr , int N) {
		int dp[][] = new int[N][N];
		for(int row[] : dp) 
			Arrays.fill(row, -1);
		
		return minCost(1, N - 1, arr, dp);
	}
}
*/

// TABULATION: T.C: O(N^3) && S.C: O(N^2)
/*
class Solution {
	public static int matrixMultiplication(int[] arr , int N) {
		int dp[][] = new int[N][N];

		for(int i = 1; i < N; i++) dp[i][i] = 0;

		for(int i = N-1; i >= 1; i--) {
			for(int j = i + 1; j <= N-1; j++) {
				int mini = (int)1e9;
				for(int k = i; k <= j - 1; k++) {
					int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
					mini = Math.min(mini, steps);
				}
				dp[i][j] = mini;
			}
		}
		
		return dp[1][N - 1];
	}
}
*/

// 