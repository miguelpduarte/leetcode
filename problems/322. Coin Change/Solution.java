class Solution {
    public int coinChange(int[] coins, int amount) {
        // For an index i, holds the number of coins needed to make up this value, or -1 if not yet known or not possible
        int[] known_ncoins = new int[amount + 1];

        // 0 coins make up the 0 amount
        known_ncoins[0] = 0;

        // Instead of subtracting from amount, accumulate up to it and store intermediate known change ncoins in known_ncoins
        // Each iteration will figure out the best way of getting the change for i
        for (int i = 1; i <= amount; ++i) {
            known_ncoins[i] = -1;
            for (int coin: coins) {
                // The coin is not larger than the current desired value and we know how many coins are necessary to give change for i - coin (the change after using this coin)
                // The first condition can be seen as i - coin >= 0, to avoid accessing negative index in array.
                //     It would mean we would overshoot the change by using a larger coin than the desired amount
                // The second condition ensures that we have "somewhere to go" after using the coin under consideration, that we have not hit a _dead end_
                if (coin <= i && known_ncoins[i - coin] != -1) {
                    if (known_ncoins[i] == -1) {
                        // No possibility until now, we are using the current coin + whatever was used before
                        known_ncoins[i] = 1 + known_ncoins[i - coin];
                    } else {
                        // There was already a possibility, only update if it is better
                        known_ncoins[i] = Math.min(known_ncoins[i], 1 + known_ncoins[i - coin]);
                    }
                }
            }
        }

        return known_ncoins[amount];

        // The previous solution could also be improved via memoization.
        // The issue was that a lot of computation was repeated by reaching the same change value with different coin combinations.
        // TODO: Compare both methods. Iterative is likely much faster, but memoization may have a very efficient native implementation
    }
}