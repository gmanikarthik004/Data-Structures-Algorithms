class RotateBy90 {
    static void rotateBy90Deg(int[][] matrix, int n) {
        // Step-1 Transpose the Matrix
        for(int i = 0; i <= n-2; i++) {
            for(int j = i+1; j <= n-1; j++) {
                // swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Step-2 Reverse each row
        for(int i = 0; i < n; i++) {
            reverseRow(matrix, i, 0, n-1);
        }
    }
    
    static void reverseRow(int[][] matrix, int row, int start, int end) {
        while(start < end) {
            int temp = matrix[row][start];
            matrix[row][start] = matrix[row][end];
            matrix[row][end] = temp;
            
            start++; end--;
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int n = matrix.length;
        
        System.out.println("Before Rotating by 90 deg clockwise: ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        rotateBy90Deg(matrix, n);
        
        System.out.println("After Rotating by 90 deg clockwise: ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}