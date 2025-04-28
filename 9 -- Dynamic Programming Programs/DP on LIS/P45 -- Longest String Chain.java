import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public boolean isPossible(String word1, String word2) {
        if(word1.length() != word2.length() + 1) return false;

        int left = 0, right = 0;
        while(left < word1.length()) {
            if(right < word2.length() && word1.charAt(left) == word2.charAt(right)) {
                left++; right++;
            }
            else {
                left++;
            }
        }
 
        return (left == word1.length() && right == word2.length());
    }

    public int longestStrChain(String[] words) {
        int N = words.length;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        Arrays.sort(words, Comparator.comparingInt(String::length));

        int maxLength = 1;
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(isPossible(words[i], words[j]) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}