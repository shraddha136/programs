import java.util.Arrays;

class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] amounts = new int[amount + 1];
        Arrays.fill(amounts, Integer.MAX_VALUE);
        int temp = 0;
        amounts[0] = 0;
        for (int coin : coins) {
            for (int j = 0; j <= amount; j++) {
                if (coin <= j) {
                    if (amounts[j - coin] == Integer.MAX_VALUE)
                        temp = amounts[j - coin];
                    else
                        temp = 1 + amounts[j - coin];
                    amounts[j] = Math.min(amounts[j], temp);
                }
            }
        }
        return amounts[amount] == Integer.MAX_VALUE ? -1 : amounts[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2};
        int amt = 3;
        System.out.println(new CoinChange().coinChange(coins, amt));
    }
}
