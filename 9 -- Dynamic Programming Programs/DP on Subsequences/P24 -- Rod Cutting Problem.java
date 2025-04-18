// RECURSION: T.C: > O(2^N) && S.C: > O(targetLength)
/*
class Solution {
	public static int maxProfit(int idx, int targetLength, int[] price) {
		if(idx == 0) {
			return targetLength * price[0];
		}
		int notPick = maxProfit(idx - 1, targetLength, price);
		int pick = Integer.MIN_VALUE;
		int rodLength = idx + 1;
		if(rodLength <= targetLength) 
			pick = price[idx] + maxProfit(idx, targetLength - rodLength, price);
		
		return Math.max(pick, notPick);
	}
	public static int cutRod(int price[], int n) {
		int size = price.length;
		int targetLength = n;

		return maxProfit(size - 1, targetLength, price);
	}
}
*/

// MEMOIZATION: T.C: O(N * targetLength) && S.C: O(N * targetLength) + O(targetLength)
/*
import java.util.Arrays;
class Solution {
	public static int maxProfit(int idx, int targetLength, int[] price, int dp[][]) {
		if(idx == 0) {
			return targetLength * price[0];
		}

		if(dp[idx][targetLength] != -1) return dp[idx][targetLength];
		int notPick = maxProfit(idx - 1, targetLength, price, dp);
		int pick = Integer.MIN_VALUE;
		int rodLength = idx + 1;
		if(rodLength <= targetLength) 
			pick = price[idx] + maxProfit(idx, targetLength - rodLength, price, dp);
		
		return dp[idx][targetLength] = Math.max(pick, notPick);
	}
	public static int cutRod(int price[], int n) {
		int size = price.length;
		int targetLength = n;

		int dp[][] = new int[size][targetLength + 1];
		for(int row[] : dp) {
			Arrays.fill(row, -1);
		}
		return maxProfit(size - 1, targetLength, price, dp);
	}
}
*/

// TABULATION: T.C: O(N * targetLength) && S.C: O(N * targetLength)
/*
class Solution {
	public static int cutRod(int price[], int n) {
		int size = price.length;
		int targetLength = n;

		int dp[][] = new int[size][targetLength + 1];

		for(int N = 0; N <= targetLength; N++) {
			dp[0][N] = N * price[0];
		}

		for(int idx = 1; idx < size; idx++) {
			for(int N = 0; N <= targetLength; N++) {
				int notPick = 0 + dp[idx - 1][N];
				int pick = Integer.MIN_VALUE;
				int rodLength = idx + 1;
				if(rodLength <= N)
					pick = price[idx] + dp[idx][N - rodLength];
				
				dp[idx][N] = Math.max(pick, notPick);
 			}
		}

		return dp[size - 1][targetLength];
	}
}
*/

// SPACE-OPTIMIZATION (2-Arrays): T.C: O(N * targetLength) && S.C: O(targetLength)
/*
class Solution {
	public static int cutRod(int price[], int n) {
		int size = price.length;
		int targetLength = n;

		int prevRow[] = new int[targetLength + 1];

		for(int N = 0; N <= targetLength; N++) {
			prevRow[N] = N * price[0];
		}

		for(int idx = 1; idx < size; idx++) {
			int curRow[] = new int[targetLength + 1];
			for(int N = 0; N <= targetLength; N++) {
				int notPick = 0 + prevRow[N];
				int pick = Integer.MIN_VALUE;
				int rodLength = idx + 1;
				if(rodLength <= N)
					pick = price[idx] + curRow[N - rodLength];
				
				curRow[N] = Math.max(pick, notPick);
 			}
			prevRow = curRow;
		}

		return prevRow[targetLength];
	}
}
*/

// SPACE-OPTIMIZATION (1-Array): T.C: O(N * targetLength) && S.C: O(targetLength)
/*
class Solution {
	public static int cutRod(int price[], int n) {
		int size = price.length;
		int targetLength = n;

		int prevRow[] = new int[targetLength + 1];

		for(int N = 0; N <= targetLength; N++) {
			prevRow[N] = N * price[0];
		}

		for(int idx = 1; idx < size; idx++) {
			for(int N = 0; N <= targetLength; N++) {
				int notPick = 0 + prevRow[N];
				int pick = Integer.MIN_VALUE;
				int rodLength = idx + 1;
				if(rodLength <= N)
					pick = price[idx] + prevRow[N - rodLength];
				
				prevRow[N] = Math.max(pick, notPick);
 			}
		}

		return prevRow[targetLength];
	}
}
*/
