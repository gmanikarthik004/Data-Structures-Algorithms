class BuyAndSell {
    public static int getProfit(int[] prices) {
        int minPrice = prices[0], maxProfit = 0;
        
        for(int sell = 1; sell < prices.length; sell++) {
            int cost = prices[sell] - minPrice;
            maxProfit = Math.max(maxProfit, cost);
            minPrice = Math.min(minPrice, sell);
        }
        
        return maxProfit;
    }

    public static void main(String args[]) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        
        System.out.println("Maximum Profit that can be obtained by buying & selling the stock would be :" + getProfit(prices));
    }

}

