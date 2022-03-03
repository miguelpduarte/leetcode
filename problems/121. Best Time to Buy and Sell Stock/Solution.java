class Solution {
    public int maxProfit(int[] prices) {
        int max_profit = 0;

        for (int i = 0; i < prices.length; ++i) {
            int curr_max_profit = maxProfitBuyAt(i, prices);
            max_profit = Math.max(max_profit, curr_max_profit);
        }

        return max_profit;
    }

    private int maxProfitBuyAt(int day_bought, int[] prices) {
        int max_profit = 0;
        int bought_at = prices[day_bought];

        for (int i = day_bought + 1; i < prices.length; ++i) {
            int sold_at = prices[i];
            int profit = sold_at - bought_at;

            max_profit = Math.max(max_profit, Math.max(profit, 0));
        }

        return max_profit;
    }
}