// RECURSION BASED: T.C: O(2^N) && S.C: O(N)
/*
class Solution {
    public static int findCnt(int idx, int newTarget, int[] arr) {
        if(idx == 0) {
            if(newTarget == 0 && arr[0] == 0) return 2;
            if(newTarget == 0 || arr[0] == newTarget) return 1;
            return 0;
        }

        int notPick = findCnt(idx-1, newTarget, arr);
        int pick = 0;
        if(arr[idx] <= newTarget) 
            pick = findCnt(idx-1, newTarget-arr[idx], arr);

        return pick + notPick;
    }
    public static int targetSum(int n, int target, int[] arr) {
        int totalSum = 0;
        for(int i : arr) {
            totalSum += i;
        }

        if((totalSum - target) < 0 || (totalSum - target) % 2 != 0) return 0;

        int newTarget = (totalSum - target) / 2;
        return findCnt(n-1, newTarget, arr);
    }
}
*/

// MEMOIZATION: T.C: O(N * TARGET) && S.C: O(N) + O(N * TARGET)
/*
class Solution {
    public static int findCnt(int idx, int newTarget, int[] arr, int dp[][]) {
        if(idx == 0) {
            if(newTarget == 0 && arr[0] == 0) return 2;
            if(newTarget == 0 || arr[0] == newTarget) return 1;
            return 0;
        }

        if(dp[idx][newTarget] != -1) return dp[idx][newTarget];

        int notPick = findCnt(idx-1, newTarget, arr, dp);
        int pick = 0;
        if(arr[idx] <= newTarget) 
            pick = findCnt(idx-1, newTarget-arr[idx], arr, dp);

        return dp[idx][newTarget] = pick + notPick;
    }
    public static int targetSum(int n, int target, int[] arr) {
        int totalSum = 0;
        for(int i : arr) {
            totalSum += i;
        }

        if((totalSum - target) < 0 || (totalSum - target) % 2 != 0) return 0;

        int newTarget = (totalSum - target) / 2;

        int dp[][] = new int[n][newTarget + 1];
        for(int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return findCnt(n-1, newTarget, arr, dp);
    }
}
*/

// TABULATION: T.C: O(N * TARGET) && S.C: O(N * TARGET)
/*
class Solution {
    public static int targetSum(int n, int target, int[] arr) {
        int totalSum = 0;
        for(int i : arr) {
            totalSum += i;
        }

        if((totalSum - target) < 0 || (totalSum - target) % 2 != 0) return 0;

        int newTarget = (totalSum - target) / 2;

        int dp[][] = new int[n][newTarget + 1];

        if(arr[0] == 0) dp[0][0] = 2;
        else dp[0][0] = 1;

        if(arr[0] != 0 && arr[0] <= newTarget) dp[0][arr[0]] = 1;
        
        for(int idx = 1; idx < n; idx++) {
            for(int Target = 0; Target <= newTarget; Target++) {
                int notPick = dp[idx-1][Target];
                int pick = 0;
                if(arr[idx] <= Target) pick = dp[idx-1][Target-arr[idx]];

                dp[idx][Target] = pick + notPick;
            }
        }

        return dp[n-1][newTarget];
    }
}
*/

// SPACE OPTIMIZATION: T.C: O(N * TARGET) && S.C: O(TARGET)
/*
class Solution {
    public static int targetSum(int n, int target, int[] arr) {
        int totalSum = 0;
        for(int i : arr) {
            totalSum += i;
        }

        if((totalSum - target) < 0 || (totalSum - target) % 2 != 0) return 0;

        int newTarget = (totalSum - target) / 2;

        int prevRow[] = new int[newTarget + 1];

        if(arr[0] == 0) prevRow[0] = 2;
        else prevRow[0] = 1;

        if(arr[0] != 0 && arr[0] <= newTarget) prevRow[arr[0]] = 1;
        
        for(int idx = 1; idx < n; idx++) {
            int curRow[] = new int[newTarget + 1];
            for(int Target = 0; Target <= newTarget; Target++) {
                int notPick = prevRow[Target];
                int pick = 0;
                if(arr[idx] <= Target) pick = prevRow[Target-arr[idx]];

                curRow[Target] = pick + notPick;
            }
            prevRow = curRow;
        }

        return prevRow[newTarget];
    }
}
*/