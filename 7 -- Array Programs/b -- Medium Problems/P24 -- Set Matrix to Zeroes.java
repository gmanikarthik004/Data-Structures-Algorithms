class SetMatrixToZeroes {
    // BETTER SOLUTION
    /*
    static void setZeroes(int[][] matrix, int N, int M) {
        int[] row = new int[N];
        int[] col = new int[M];
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                    if(row[i] == 1 || col[j] == 1) {
                        matrix[i][j] = 0; // Set to Zero;
                    }
            }
        }
    }
    */

    // OPTIMAL SOLUTION
    static void setZeroes(int[][] matrix, int N, int M) {
        // int[] row = new int[N]; => matrix[..][0]
        // int[] col = new int[M]; => matrix[0][..]
        
        // Step-1 Traverse the matrix, and mark firstRow and firstCol accordingly.
        int col0 = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(matrix[i][j] == 0) {
                    // Mark i-th row
                    matrix[i][0] = 0;
                    // Mark j-th col
                    if(j != 0) {
                        matrix[0][j] = 0;
                    } else{
                        col0 = 0;
                    }
                }
            }
        }
        
        // Step-2 Traverse from i=1, j=1 to i=n, j=m and mark 0
        for(int i = 1; i < N; i++) {
            for(int j = 1; j < M; j++) {
                if(matrix[i][j] == 1) {
                    // Check if 1 is eligible to become zero
                    if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        
        // Step-3 First mark the firstRow and then mark firstCol
        if(matrix[0][0] == 0) {
            for(int j = 0; j < M; j++) {
                matrix[0][j] = 0;
            }
        }
        
        if(col0 == 0) {
           for(int i = 0; i < N; i++) {
                matrix[i][0] = 0;
           } 
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
        {0, 1, 1, 1},
        {1, 0, 0, 1}, 
        {1, 1, 0, 1}, 
        {1, 1, 1, 1}};
        
        System.out.println("Before making B-Matrix as 0's: ");
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // int N = matrix.length; // To get no.of rows
        // int M = matrix[0].length; // To get no.of cols
        
        setZeroes(matrix, matrix.length, matrix[0].length);
        
        System.out.println("After making B-Matrix as 0's: ");
        for(int i = 0; i < matrix[0].length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}