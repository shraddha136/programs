import java.util.Arrays;

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        if(coins == null || coins.length == 0){
            return 0;
        }
        return getChange(amount, coins, 0);
    }

    private int getChange(int amount, int[] coins, int index){
        if(amount == 0){
            return 1;
        }
        if(index >= coins.length){
            return 0;
        }

        int p1 = 0;
        if(amount>=coins[index]){
            p1 = getChange(amount - coins[index],coins,index);
        }
        int p2 = getChange(amount,coins,index+1);
        return p1+p2;
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] =0;

        for(int coin: coins){
            for(int i = 0;i<amount;i++){
                if(coin<=i){
                    dp[i] = Math.min(dp[i],1+dp[i-coin]);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
    public static void main(String[] args) {
        int[] a = {1,2,5};
        System.out.println(new CoinChange2().coinChange(a,11));
    }
}
