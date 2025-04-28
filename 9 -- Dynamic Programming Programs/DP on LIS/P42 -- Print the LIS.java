import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class LIS {
    public static List<Integer> printLIS(int[] arr, int N) {
        int[] dp = new int[N];
        Arrays.fill(dp, 1);
        int[] hash = new int[N];
        
        int maxLIS = 1, lastIdx = 0; // Idx of LastLIS formed
        
        for(int idx = 0; idx < N; idx++) {
            hash[idx] = idx;
            for(int prevIdx = 0; prevIdx < idx; prevIdx++) {
                if(arr[prevIdx] < arr[idx] && dp[prevIdx] + 1 > dp[idx]) {
                    dp[idx] = dp[prevIdx] + 1;
                    hash[idx] = prevIdx;
                }
            }
            if(dp[idx] > maxLIS) {
                maxLIS = dp[idx];
                lastIdx = idx;
            }
        }
        
        List<Integer> LIS = new ArrayList<>();
        LIS.add(arr[lastIdx]);
        
        while(hash[lastIdx] != lastIdx) {
            lastIdx = hash[lastIdx];
            LIS.add(arr[lastIdx]);
        }
        
        Collections.reverse(LIS);
        return LIS;
    }
    
    public static void main(String args[]) {
        int arr[] = {5, 4, 11, 1, 16, 8};
        
        System.out.println("Longest Increasing Subsequence: ");
        List<Integer> lis = printLIS(arr, arr.length);
        for(int i : lis)
            System.out.print(i + " ");
    }
}
