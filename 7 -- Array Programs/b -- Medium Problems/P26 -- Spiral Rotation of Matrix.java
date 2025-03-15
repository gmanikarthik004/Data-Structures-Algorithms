import java.util.ArrayList;

class SpiralRotation {
    static ArrayList<Integer> spiralRotation(int[][] matrix, int n, int m)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        
        int topR = 0, bottomR = n-1, leftC = 0, rightC = m-1;
        
        // Right -> Bottom -> Left -> Top
        while(topR <= bottomR && leftC <= rightC) {
            // Move from left to right
            for(int i = leftC; i <= rightC; i++) {
                ans.add(matrix[topR][i]);
            }
            topR++;
            
            // Move from top to bottom
            for(int i = topR; i <= bottomR; i++) {
                ans.add(matrix[i][rightC]);
            }
            rightC--;
            
            // Move from right to left
            // Check if atleast 1-Row exists, then only move from rightToLeft
            if(topR <= bottomR) {
                for(int i = rightC; i >= leftC; i--) {
                    ans.add(matrix[bottomR][i]);
                }
                bottomR--;
            }
            
            // Move from bottom to top
            // Check if atleast 1-Column exists, then only move from bottomTotop
            if(leftC <= rightC) {
                for(int i = bottomR; i >= topR; i--) {
                    ans.add(matrix[i][leftC]);
                }
                leftC++;
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}};
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        ArrayList<Integer> res = spiralRotation(matrix, n, m);
        System.out.println("Spiral Rotation of the given matrix: " + res);
    }
}