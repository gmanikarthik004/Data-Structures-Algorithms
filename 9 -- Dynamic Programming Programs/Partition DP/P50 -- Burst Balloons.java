// RECURSION + MEMOIZATION: T.C: O(N*N*N) && S.C: O(N*N) + O(N)stack-space
/*
class Solution {
    public int findMax(int i, int j, int[] numsArray, int[][] dp) {
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        
        int maxCoins = Integer.MIN_VALUE;
        for(int idx = i; idx <= j; idx++) {
            int coins = numsArray[i - 1] * numsArray[idx] * numsArray[j + 1]
                      + findMax(i, idx - 1, numsArray, dp)
                      + findMax(idx + 1, j, numsArray, dp);
            
            maxCoins = Math.max(maxCoins, coins);
        }

        return dp[i][j] = maxCoins;
    }

    public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int ele : nums) list.add(ele);
        list.add(1);

        int[] numsArray = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            numsArray[i] = list.get(i);
        }
        
        int n = nums.length; // Initial Length of nums
        int[][] dp = new int[n + 2][n + 2];
        for(int row[] : dp) Arrays.fill(row, -1);

        return findMax(1, n, numsArray, dp); 
    }
}
*/

// TABULATION: T.C: O(N*N*N) && S.C: O(N*N)
/*
class Solution {
    public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int ele : nums) list.add(ele);
        list.add(1);

        int[] numsArray = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            numsArray[i] = list.get(i);
        }
        
        int n = nums.length; // Initial Length of nums
        int[][] dp = new int[n + 2][n + 2];

        for(int i = n; i >= 1; i--) {
            for(int j = i; j <= n; j++) {
            int maxCoins = Integer.MIN_VALUE;
            for(int idx = i; idx <= j; idx++) {
                int coins = numsArray[i - 1] * numsArray[idx] * numsArray[j + 1]
                        + dp[i][idx - 1]
                        + dp[idx + 1][j];
                
                maxCoins = Math.max(maxCoins, coins);
            }

            dp[i][j] = maxCoins;
            }
        }

        return dp[1][n]; 
    }
}
*/

//