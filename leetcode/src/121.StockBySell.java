class StockBySell {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            profit = Math.max(profit, price - minPrice);
        }
        return profit;
    }

    public static void main(String[] args) {
//        int prices[] = {7,6,4,3,1};
        int prices[] = {7,1,5,3,6,4};
        System.out.println(new StockBySell().maxProfit(prices));
    }
}
