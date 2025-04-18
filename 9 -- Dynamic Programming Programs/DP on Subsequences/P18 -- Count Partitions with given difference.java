// RECURSION: T.C: O(2^N) && S.C: O(N)
/*
class Solution {
	public static int mod = (int)1e9 ^ 7;
	public static int findCnt(int idx, int target, int[] arr) {
		if(idx == 0) {
			if(arr[0] == 0 && target == 0) return 2;
			if(target == 0 || arr[0] == target) return 1;
			return 0;
		}

		int notPick = findCnt(idx-1, target, arr);
		int pick = 0;
		if(arr[idx] <= target) pick = findCnt(idx-1, target - arr[idx], arr);

		return (pick + notPick) % mod;
	}
	public static int countPartitions(int n, int d, int[] arr) {
		int totalSum = 0;
		for(int i : arr) {
			totalSum += i;
		}

		// Edge-case
		if ((totalSum - d) < 0 || (totalSum-d)%2 != 0) return 0;

		return findCnt(n-1, (totalSum-d)/2, arr);
	}
}
*/

// MEMOIZATION: T.C: O(N * TARGET) && S.C: O(N) + O(N * TARGET)
/*
class Solution {
	public static int mod = (int)1e9 ^ 7;
	public static int findCnt(int idx, int target, int[] arr, int dp[][]) {
		if(idx == 0) {
			if(arr[0] == 0 && target == 0) return 2;
			if(target == 0 || arr[0] == target) return 1;
			return 0;
		}

		if(dp[idx][target] != -1) return dp[idx][target];

		int notPick = findCnt(idx-1, target, arr, dp);
		int pick = 0;
		if(arr[idx] <= target) pick = findCnt(idx-1, target - arr[idx], arr, dp);

		return dp[idx][target] = (pick + notPick) % mod;
	}
	public static int countPartitions(int n, int d, int[] arr) {
		int totalSum = 0;
		for(int i : arr) {
			totalSum += i;
		}

		// Edge-case
		if ((totalSum - d) < 0 || (totalSum-d)%2 != 0) return 0;

		int target = (totalSum-d)/2;
		int dp[][] = new int[n][target + 1];
		for(int row[] : dp) {
			Arrays.fill(row, -1);
		}

		return findCnt(n-1, target, arr, dp);
	}
}
*/

// TABULATION: T.C: O(N * TARGET) && S.C: O(N * TARGET)
/*
class Solution {
	public static int mod = (int)1e9 ^ 7;
	public static int countPartitions(int n, int d, int[] arr) {
		int totalSum = 0;
		for(int i : arr) {
			totalSum += i;
		}

		// Edge-case
		if ((totalSum - d) < 0 || (totalSum-d)%2 != 0) return 0;

		int target = (totalSum-d)/2;

		int dp[][] = new int[n][target + 1];

		if(arr[0] == 0) dp[0][0] = 2;
		else dp[0][0] = 1;

		if(arr[0] != 0 && arr[0] <= target) dp[0][arr[0]] = 1;

		for(int idx = 1; idx < n; idx++) {
			for(int k = 0; k <= target; k++) {
				int notPick = dp[idx - 1][k];
				int pick = 0;
				if(arr[idx] <= k) pick = dp[idx - 1][k - arr[idx]];

				dp[idx][k] = (pick + notPick) % mod;
			}
		}

		return dp[n-1][target];
	}
}
*/

// SPACE-OPTIMIZATION: T.C: O(N * TARGET) && S.C: O(TARGET)
/*
class Solution {
	public static int mod = (int)1e9 ^ 7;
	public static int countPartitions(int n, int d, int[] arr) {
		int totalSum = 0;
		for(int i : arr) {
			totalSum += i;
		}

		// Edge-case
		if ((totalSum - d) < 0 || (totalSum-d)%2 != 0) return 0;

		int target = (totalSum-d)/2;

		int prevRow[] = new int[target + 1];

		if(arr[0] == 0) prevRow[0] = 2;
		else prevRow[0] = 1;

		if(arr[0] != 0 && arr[0] <= target) prevRow[arr[0]] = 1;

		for(int idx = 1; idx < n; idx++) {
			int curRow[] = new int[target + 1];
			curRow[0] = 0;
			for(int k = 0; k <= target; k++) {
				int notPick = prevRow[k];
				int pick = 0;
				if(arr[idx] <= k) pick = prevRow[k - arr[idx]];

				curRow[k] = (pick + notPick) % mod;
			}
			prevRow = curRow;
		}

		return prevRow[target];
	}
}
*/