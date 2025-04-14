// RECURSIVE SOLUTION: T.C: O(3^N * 3^N) && S.C: O(N)
/*
class Solution {
    public int findMax(int i, int j1, int j2, int n, int m, int[][] grid) {
        int maxCherries = 0;
        // Base-Cases
        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) return (int)-1e8; // Out-of-boundry
        if(i == n-1) { // Destination
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        
        for(int dj1 = -1; dj1 <= 1; dj1++) {
            for(int dj2 = -1; dj2 <= 1; dj2++) {
                int cherries = 0;
                if(j1 == j2) cherries = grid[i][j1];
                else cherries = grid[i][j1] + grid[i][j2];
                cherries += findMax(i+1, j1+dj1, j2+dj2, n, m, grid, dp);
                maxCherries = Math.max(maxCherries, cherries);
            }
        }

        return maxCherries;
    }
    public int cherryPickup(int[][] grid) {
        // Grid Dimensions
        int n = grid.length;
        int m = grid[0].length;

        int maxCherries = findMax(0, 0, m-1, n, m, grid);
        return maxCherries;
    }
}
*/

// MEMOIZATION SOLUTION: T.C: O(N*M*M*9) && S.C: O(N*M*M) * O(N)
/*
class Solution {
    public int findMax(int i, int j1, int j2, int n, int m, int[][] grid, int[][][] dp) {
        int maxCherries = 0;
        // Base-Cases
        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) return (int)-1e8; // Out-of-boundry
        if(i == n-1) { // Destination
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];
        
        for(int dj1 = -1; dj1 <= 1; dj1++) {
            for(int dj2 = -1; dj2 <= 1; dj2++) {
                int cherries = 0;
                if(j1 == j2) cherries = grid[i][j1];
                else cherries = grid[i][j1] + grid[i][j2];
                cherries += findMax(i+1, j1+dj1, j2+dj2, n, m, grid, dp);
                maxCherries = Math.max(maxCherries, cherries);
            }
        }

        return dp[i][j1][j2] = maxCherries;
    }
    public int cherryPickup(int[][] grid) {
        // Grid Dimensions
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int maxCherries = findMax(0, 0, m-1, n, m, grid, dp);
        return maxCherries;
    }
}
*/

// TABULATION SOLUTION: T.C: O(N*M*M*9) && S.C: O(N*M*M)
/*
class Solution {
    public int cherryPickup(int[][] grid) {
        // Grid Dimensions
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        // Base-Case
        for(int j1 = 0; j1 < m; j1++) {
            for(int j2 = 0; j2 < m; j2++) {
                if(j1 == j2) dp[n-1][j1][j2] = grid[n-1][j1];
                else dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2]; 
            }
        }

        for(int i = n-2; i >= 0; i--) {
            for(int j1 = 0; j1 < m; j1++) {
                for(int j2 = 0; j2 < m; j2++) {
                    int maxCherries = 0;
                    for(int dj1 = -1; dj1 <= 1; dj1++) {
                        for(int dj2 = -1; dj2 <= 1; dj2++) {
                            int cherries = 0;
                            if(j1 == j2) cherries = grid[i][j1];
                            else cherries = grid[i][j1] + grid[i][j2];
                            if(j1+dj1 >= 0 && j1+dj1 < m && j2+dj2 >= 0 && j2+dj2 < m)
                                cherries += dp[i+1][j1+dj1][j2+dj2];
                            else
                               cherries += (int)-1e8;
                             
                            maxCherries = Math.max(maxCherries, cherries);
                        }
                    }
                    dp[i][j1][j2] = maxCherries; 
                }
            }
        }

        return dp[0][0][m-1];
    }
}
*/

// SPACE-OPTIMIZATION SOLUTION: T.C: O(N*M*M*9) && S.C: O(M*M)
/*
class Solution {
    public int cherryPickup(int[][] grid) {
        // Grid Dimensions
        int n = grid.length;
        int m = grid[0].length;

        int prev[][] = new int[m][m];

        // Base-Case
        for(int j1 = 0; j1 < m; j1++) {
            for(int j2 = 0; j2 < m; j2++) {
                if(j1 == j2) prev[j1][j2] = grid[n-1][j1];
                else prev[j1][j2] = grid[n-1][j1] + grid[n-1][j2]; 
            }
        }

        for(int i = n-2; i >= 0; i--) {
            int curr[][] = new int[m][m];
            for(int j1 = 0; j1 < m; j1++) {
                for(int j2 = 0; j2 < m; j2++) {
                    int maxCherries = 0;
                    for(int dj1 = -1; dj1 <= 1; dj1++) {
                        for(int dj2 = -1; dj2 <= 1; dj2++) {
                            int cherries = 0;
                            if(j1 == j2) cherries = grid[i][j1];
                            else cherries = grid[i][j1] + grid[i][j2];
                            if(j1+dj1 >= 0 && j1+dj1 < m && j2+dj2 >= 0 && j2+dj2 < m)
                                cherries += prev[j1+dj1][j2+dj2];
                            else
                               cherries += (int)-1e8;
                             
                            maxCherries = Math.max(maxCherries, cherries);
                        }
                    }
                    curr[j1][j2] = maxCherries; 
                }
            }
            prev = curr;
        }

        return prev[0][m-1];
    }
}
*/