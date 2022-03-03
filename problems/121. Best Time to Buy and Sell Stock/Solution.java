class Solution {
    public int maxProfit(int[] prices) {
        int max_profit_so_far = 0;
        int bought_at = prices[0];

        for (int i = 1; i < prices.length; ++i) {
            // Found new lowest price. Update the bought at value and skip iteration
            if (prices[i] < bought_at) {
                bought_at = prices[i];
                continue;
            }

            int curr_profit = prices[i] - bought_at;
            if (curr_profit > max_profit_so_far) {
                max_profit_so_far = curr_profit;
            }
        }

        return max_profit_so_far;
    }
}