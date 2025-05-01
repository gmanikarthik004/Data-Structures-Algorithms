class Solution {
    public int countSquares(int[][] matrix) {
        int N = matrix.length, M = matrix[0].length;

        int[][] dp = new int[N][M];

        // Copy firstRow and firstCol the same
        for(int j = 0; j < M; j++) dp[0][j] = matrix[0][j];
        for(int i = 0; i < N; i++) dp[i][0] = matrix[i][0];

        // Start filling DP table
        for(int i = 1; i < N; i++) {
            for(int j = 1; j < M; j++) {
                if(matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }

        // Sum it up to get totalSquares
        int no_of_squares = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                no_of_squares += dp[i][j];
            }
        }

        return no_of_squares;
    }
}