class SudokuSolver {
    public static boolean solve(char[][] board) {
        for(int row = 0; row < 9; row++) {
            for(int col = 0; col < 9; col++) {
                // Check if empty('.')
                if(board[row][col] == '.') {
                    for(char ch = '1'; ch <= '9'; ch++) {
                        if(isValidPlace(row, col, board, ch)) {
                            board[row][col] = ch; // Mark
                            
                            if(solve(board)) {
                                return true;
                            } else {
                                board[row][col] = '.'; // Unmark
                            }
                        }
                    }
                    return false; // None can be placed
                }
            }
        }
        // If everything is solved
        return true;
    }
    public static boolean isValidPlace(int row, int col, char[][] board, char ch) {
        for(int i = 0; i < 8; i++) {
            // Check over a row
            if(board[row][i] == ch) 
                return false;
            // Check over a col
            if(board[i][col] == ch) 
                return false;
            // Check over a 3*3 sub-matrix
            if(board[3*(row/3) + i/3][3*(col/3) + i%3] == ch) return false;
        }
        return true; // If valid place to put
    }
    public static void solveSudoko(char[][] board) {
        solve(board);
    }
    public static void main(String args[]) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        
        System.out.println("Unsolved Sudoko: ");
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        
        solveSudoko(board);
        System.out.println();
        
        System.out.println("Solved Sudoko: ");
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}