class Solution {
    public int maxProfit(int[] prices) {
        int total_profit_so_far = 0;
        int min_so_far = prices[0];
        int max_so_far = prices[0];

        for (int i = 1, pricesLength = prices.length; i < pricesLength; i++) {
            int price = prices[i];

            if (price < max_so_far) {
                // The new value is smaller than the maximum, we can sell what we have so far and buy again to make more profit
                int sold_profit = max_so_far - min_so_far;
                total_profit_so_far += sold_profit;
                min_so_far = max_so_far = price;
            } else {
                max_so_far = price;
            }
        }

        // At the end we end with the stock "purchased", at least on the last day, sell it to make the total profit correct
        // (Many times this will add only 0)
        int sold_profit = max_so_far - min_so_far;
        total_profit_so_far += sold_profit;

        return total_profit_so_far;
    }
}