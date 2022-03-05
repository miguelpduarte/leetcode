class Solution {
    public int coinChange(int[] coins, int amount) {
        return coinChangeAux(coins, amount, 0);
    }

    private int coinChangeAux(int[] coins, int curr_amount, int n_coins_so_far) {
        // Finished
        if (curr_amount == 0) {
            return n_coins_so_far;
        }

        int lowest_n_coins = Integer.MAX_VALUE;

        for (int coin : coins) {
            if (coin <= curr_amount) {
                int n_coins_curr = coinChangeAux(coins, curr_amount - coin, n_coins_so_far + 1);
                if (n_coins_curr < lowest_n_coins && n_coins_curr != -1) {
                    lowest_n_coins = n_coins_curr;
                }
            }
        }

        if (lowest_n_coins == Integer.MAX_VALUE) {
            // No coin can reduce to 0
            return -1;
        }

        return lowest_n_coins;
    }
}