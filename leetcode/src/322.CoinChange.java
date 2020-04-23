import java.util.Arrays;

class CoinChange {
    public int coinChange(int[] coins, int amount) {
//        int[] amounts = new int[amount + 1];
//        Arrays.fill(amounts, Integer.MAX_VALUE);
//        int temp = 0;
//        amounts[0] = 0;
//        for (int coin : coins) {
//            for (int j = 0; j <= amount; j++) {
//                if (coin <= j) {
//                    if (amounts[j - coin] == Integer.MAX_VALUE)
//                        temp = amounts[j - coin];
//                    else
//                        temp = 1 + amounts[j - coin];
//                    amounts[j] = Math.min(amounts[j], temp);
//                }
//            }
//        }
//        return amounts[amount] == Integer.MAX_VALUE ? -1 : amounts[amount];
        if(coins == null || coins.length == 0)
            return 0;
        if(amount == 0)
            return 0;
        int[] amounts = new int[amount+1];
//        Arrays.fill(amounts,Integer.MAX_VALUE);
        Arrays.sort(coins);
        for(int coin:coins){
            for(int i = 0; i< amounts.length; i++){
                if(i>=coin){
                    if(i%coin == 0){
                        amounts[i] = i/coin;
                    }else{
                        amounts[i] = Math.min(amounts[i],(i/coin)+amounts[i-(i/coin)*coin]);
                    }
                }
            }
        }
        return amounts[amount]== 0?-1:amounts[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2,5,10,1};
        int amt = 27;
        System.out.println(new CoinChange().coinChange(coins, amt));
    }
}
