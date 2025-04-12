// RECURSION-BASED SOLUTION -- T.C = O(3^N) S.C = O(N)
/*
class NinjaTraining {
    public static int findMaxMerit(int day, int lastTask, int meritMatrix[][]) {
        // Base-Case -- Day-0
        if(day == 0) {
            int maxi = 0;
            for(int i = 0; i <= 2; i++) {
                if(i != lastTask) {
                    maxi = Math.max(maxi, meritMatrix[0][i]);
                }
            }
            return maxi;
        }
        
        int maxiMerit = 0;
        for(int i = 0; i <= 2; i++) {
            if(i != lastTask) {
                int meritPt = meritMatrix[day][i] + findMaxMerit(day - 1, i, meritMatrix);
                maxiMerit = Math.max(maxiMerit, meritPt);
            }
        }
        return maxiMerit;
    }
    public static void main(String args[]) {
        int meritMatrix[][] = 
        {
            {10, 40, 70},
            {20, 50, 80},
            {30, 60, 90}
        };
        int n = meritMatrix.length;
        
        System.out.println("Maximum meritPoints ninga can earn: " + findMaxMerit(n - 1, 3, meritMatrix));
    }
}
*/

// MEMOIZATION-BASED SOLUTION -- T.C = O(N * 4 * 3) S.C = O(N*4) + O(N)
/*
import java.util.Arrays;
class Solution {
    public static int findMaxMerit(int day, int lastTask, int meritMatrix[][], int dp[][]) {
        // Base-Case -- Day-0
        if(day == 0) {
            int maxi = 0;
            for(int i = 0; i <= 2; i++) {
                if(i != lastTask) {
                    maxi = Math.max(maxi, meritMatrix[0][i]);
                }
            }
            return maxi;
        }

        if(dp[day][lastTask] != -1) return dp[day][lastTask];
        
        int maxiMerit = 0;
        for(int i = 0; i <= 2; i++) {
            if(i != lastTask) {
                int meritPt = meritMatrix[day][i] + findMaxMerit(day - 1, i, meritMatrix, dp);
                maxiMerit = Math.max(maxiMerit, meritPt);
            }
        }
        return dp[day][lastTask] = maxiMerit;
    }
    public static int ninjaTraining(int n, int points[][]) {
        int dp[][] = new int[n][4];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return findMaxMerit(n - 1, 3, points, dp);
    }
}
*/

// TABULATION-BASED SOLUTION -- T.C = O(N * 4 * 3) S.C = O(N * 4)
/*
class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        int dp[][] = new int[n][4];

        // Base-Case
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int day = 1; day < n; day++) {
            for(int lastTask = 0; lastTask < 4; lastTask++) {
                dp[day][lastTask] = 0;

                for(int task = 0; task < 3; task++) {
                    if(task != lastTask) {
                        dp[day][lastTask] = Math.max(dp[day][lastTask], points[day][task] + dp[day-1][task]);
                    }
                }
            }
        }

        return dp[n-1][3];
    }
}
*/

// SPACE-OPTIMIZED SOLUTION -- T.C = O(N * 4 * 3) S.C = O(1)
/*
class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        int prev[] = new int[4];

        // Base-Case
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int day = 1; day < n; day++) {
            int curr[] = new int[4];
            for(int lastTask = 0; lastTask < 4; lastTask++) {
                for(int task = 0; task < 3; task++) {
                    if(task != lastTask) {
                        curr[lastTask] = Math.max(curr[lastTask], points[day][task] + prev[task]);
                    }
                }
            }
            prev = curr;
        }

        return prev[3];
    }
}
*/
