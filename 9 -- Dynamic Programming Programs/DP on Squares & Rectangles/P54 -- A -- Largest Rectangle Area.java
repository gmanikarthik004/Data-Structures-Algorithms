import java.util.Stack;
class LargestRectangleArea {
    static int maxArea(int[] heights, int N) {
        int[] prevSmallest = new int[N];
        int[] nextSmallest = new int[N];
        
        Stack<Integer> st = new Stack<>();
        
        // Fill the prevSmallest
        for(int i = 0; i < N; i++) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            prevSmallest[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear(); // To use same for nextSmallest
        
        // Fill the nextSmallest
        for(int i = N - 1; i >= 0; i--) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            nextSmallest[i] = st.isEmpty() ? N : st.peek();
            st.push(i);
        }
        
        // Find maxArea
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            int width = nextSmallest[i] - prevSmallest[i] - 1;
            int height = heights[i];
            int area = width * height;
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }
    
    public static void main(String args[]) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        
        System.out.println("Largest Rectangle Area: " + maxArea(heights, heights.length));
    }
}