public class Stocks3 {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int minPrice = prices[0];
        int maxPrice = prices[prices.length - 1];
        int[][] dp = new int[2][prices.length];
        for(int i = 1;i<prices.length;i++){//update minPrice with a lower buying price.
            minPrice = Math.min(minPrice,prices[i]);
            dp[0][i] = Math.max(dp[0][i - 1],prices[i] - minPrice);
        }
        for(int i = prices.length - 2; i>=0;i--){//update maxPrice with a higher selling price.
            maxPrice = Math.max(maxPrice,prices[i]);
            dp[1][i] = Math.max(dp[1][i+1],maxPrice - prices[i]);
        }
        int maxProfit = dp[1][0];//2nd buy at day 0, sell on the last day
        for(int i = 1;i<prices.length - 1;i++){
            maxProfit = Math.max(maxProfit,dp[0][i - 1] + dp[1][i]);//sell on day i - 1, buy on day i
        }
        maxProfit = Math.max(maxProfit,dp[0][prices.length - 1]);//1st buy at day 0, sell on the last day
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        System.out.println(new Stocks3().maxProfit(a));
    }
}
