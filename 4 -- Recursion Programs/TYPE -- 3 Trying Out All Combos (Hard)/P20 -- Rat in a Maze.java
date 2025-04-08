import java.util.List;
import java.util.ArrayList;

class RatInMaze {

    public static void possiblePaths(int i, int j, int[][] maze, int N, int[] dRow, int[] dCol,
                                     int[][] visited, String dirStr, String move, List<String> ans) {
        // Base Case: Reached destination
        if (i == N - 1 && j == N - 1) {
            ans.add(move);
            return;
        }

        for (int idx = 0; idx < 4; idx++) {
            int nextRow = i + dRow[idx];
            int nextCol = j + dCol[idx];

            // Valid move check
            if (nextRow >= 0 && nextCol >= 0 && nextRow < N && nextCol < N &&
                maze[nextRow][nextCol] == 1 && visited[nextRow][nextCol] == 0) {

                visited[i][j] = 1;

                possiblePaths(nextRow, nextCol, maze, N, dRow, dCol, visited, dirStr,
                              move + dirStr.charAt(idx), ans);

                visited[i][j] = 0; // Backtracking
            }
        }
    }

    public static List<String> findPaths(int[][] maze, int N) {
        int[][] visited = new int[N][N];
        List<String> ans = new ArrayList<>();
        String dirStr = "DLRU";  // D=Down, L=Left, R=Right, U=Up
        int[] dRow = {+1, 0, 0, -1};
        int[] dCol = {0, -1, +1, 0};

        if (maze[0][0] == 1)
            possiblePaths(0, 0, maze, N, dRow, dCol, visited, dirStr, "", ans);

        return ans;
    }

    public static void main(String[] args) {
        int N = 4;

        int[][] maze = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}
        };

        List<String> result = findPaths(maze, N);

        System.out.println("Possible Paths: ");
        System.out.println(result);
    }
}
