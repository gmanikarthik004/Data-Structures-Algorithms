class Solution {
    public int findLCS(int N, String s1, int M, String s2) {
        int prevRow[] = new int[M + 1];

        for(int j = 0; j <= M; j++) prevRow[j] = 0;

        for(int i = 1; i <= N; i++) {
            int curRow[] = new int[M + 1];
            for(int j = 1; j <= M; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    curRow[j] = 1 + prevRow[j - 1];
                else
                    curRow[j] = Math.max(curRow[j - 1], prevRow[j]);
            }
            prevRow = curRow;
        }

        return prevRow[M];
    }
    public int minDistance(String word1, String word2) {
        int N = word1.length(), M = word2.length(); 

        int deletions = N - findLCS(N, word1, M, word2);
        int insertions = M - findLCS(N, word1, M, word2);

        return deletions + insertions;

        // return N + M - 2 * findLCS(N, word1, M, word2);
    }
}