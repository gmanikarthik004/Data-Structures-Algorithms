import java.util.ArrayList;
import java.util.List;

class N_Queen_Problem {

    // Solves the N-Queen problem using backtracking
    public static void solveNQueen(int col, char[][] board, List<List<String>> nQueen,
                                   int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal, int boardLength) {
        // Base case: All queens placed
        if (col == boardLength) {
            nQueen.add(constructResult(board));
            return;
        }

        for (int row = 0; row < boardLength; row++) {
            // Check if it's safe to place a queen
            if (leftRow[row] == 0 &&
                upperDiagonal[boardLength - 1 + col - row] == 0 &&
                lowerDiagonal[row + col] == 0) {

                board[row][col] = 'Q';
                leftRow[row] = 1;
                upperDiagonal[boardLength - 1 + col - row] = 1;
                lowerDiagonal[row + col] = 1;

                solveNQueen(col + 1, board, nQueen, leftRow, upperDiagonal, lowerDiagonal, boardLength);

                // Backtrack
                board[row][col] = '*';
                leftRow[row] = 0;
                upperDiagonal[boardLength - 1 + col - row] = 0;
                lowerDiagonal[row + col] = 0;
            }
        }
    }

    // Converts 2D board array to List<String> representation
    public static List<String> constructResult(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }

    // Main method
    public static void main(String[] args) {
        int n = 4;

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '*';
            }
        }

        List<List<String>> nQueen = new ArrayList<>();
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];

        solveNQueen(0, board, nQueen, leftRow, upperDiagonal, lowerDiagonal, n);

        // Print results
        System.out.println("N-Queen Solutions are:");
        int count = 1;
        for (List<String> solution : nQueen) {
            System.out.println("\nSolution " + count + ":");
            for (String row : solution) {
                for (char ch : row.toCharArray()) {
                    System.out.print(ch + " ");
                }
                System.out.println();
            }
            count++;
        }
    }
}
