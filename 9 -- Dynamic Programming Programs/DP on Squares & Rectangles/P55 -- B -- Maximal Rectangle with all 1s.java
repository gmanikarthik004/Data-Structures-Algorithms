// FIND THE MAXIMAL RECTANGLE WITH ALL 1's
import java.util.Stack;
class Solution {
    static int findMaxArea(int[] heights, int N) {
        int[] prevSmaller = new int[N];
        int[] nextSmaller = new int[N];
        
        Stack<Integer> st = new Stack<>();
        
        // Fill the prevSmallest
        for(int i = 0; i < N; i++) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            prevSmaller[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        
        st.clear();

        // Fill the nextSmallest
        for(int i = N - 1; i >= 0; i--) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            nextSmaller[i] = st.isEmpty() ? N: st.peek();
            st.push(i);
        }
        
        // Find maxArea
        int maxArea = 0;
        for(int i = 0; i < N; i++) {
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            int height = heights[i];
            int area = width * height;
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) 
            return 0;

        int M = matrix[0].length;
        int[] heights = new int[M];
        int maxArea = 0;

        for(char[] row : matrix) {
            for(int col = 0; col < M; col++) {
                heights[col] = row[col] == '1'? heights[col] + 1 : 0;
            }
            int area = findMaxArea(heights, M); // Updated heights array
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
