// Recursion + Memoization: T.C: O(N * N) + O(N) && S.C: O(N) + O(N * N)
/*
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int findCost(int i, int j, int[] cutArray, int[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int minCost = Integer.MAX_VALUE;
        for (int idx = i; idx <= j; idx++) {
            int cost = cutArray[j + 1] - cutArray[i - 1]
                     + findCost(i, idx - 1, cutArray, dp)
                     + findCost(idx + 1, j, cutArray, dp);

            minCost = Math.min(minCost, cost);
        }

        return dp[i][j] = minCost;
    }

    public int minCost(int n, int[] cuts) {
        List<Integer> li = new ArrayList<>();
        li.add(0);
        for(int cut : cuts) 
            li.add(cut);
        li.add(n);

        Collections.sort(li);

        int[] cutArray = new int[li.size()];
        for(int i = 0; i < li.size(); i++)
            cutArray[i] = li.get(i);

        int c = cuts.length;  // Original number of cuts
        int[][] dp = new int[c + 2][c + 2];  // Full size to accommodate 0 and n
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return findCost(1, c, cutArray, dp);
    }
}
*/

// TABULATION: T.C: O(N * N * N) && S.C: O(N * N)
/*
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
class Solution {
    public int minCost(int n, int[] cuts) {
        List<Integer> li = new ArrayList<>();
        li.add(0);
        for(int cut : cuts) 
            li.add(cut);
        li.add(n);

        Collections.sort(li);

        int[] cutArray = new int[li.size()];
        for(int i = 0; i < li.size(); i++)
            cutArray[i] = li.get(i);

        int c = cuts.length;  // Original number of cuts
        int[][] dp = new int[c + 2][c + 2];  // Full size to accommodate 0 and n

        for(int i = c; i >= 1; i--) {
            for(int j = 1; j <= c; j++) {
                if(i > j) continue;
                int minCost = Integer.MAX_VALUE;
                for (int idx = i; idx <= j; idx++) {
                    int cost = cutArray[j + 1] - cutArray[i - 1] + dp[i][idx - 1] + dp[idx + 1][j];
                    minCost = Math.min(minCost, cost);
                }

                dp[i][j] = minCost;
            }
        }

        return dp[1][c];
    }
}
*/