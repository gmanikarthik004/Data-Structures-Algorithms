class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int minCost = prices[0], maxProfit = 0;
        for(int i = 1; i < n; i++) {
            int cost = prices[i] - minCost;
            maxProfit = Math.max(maxProfit, cost);
            minCost = Math.min(minCost, prices[i]); 
        }

        return maxProfit;
    }
}