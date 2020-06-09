public class Knapsack {
    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
//        return KSRec(profits,weights,0,capacity);
//        Integer[][] memo = new Integer[ profits.length][capacity+1];
//        return KSMemo(memo, profits, weights, 0, capacity);
        int[][] memo = new int[ profits.length][capacity+1];
        return KSDP(memo, profits, weights, capacity);

    }

    private int KSDP(int[][] memo, int[] profits, int[] weights, int capacity) {
        for(int i = 0;i<profits.length;i++)
            memo[i][0]= 0;
        for(int i = 0;i<=capacity;i++){
            if(weights[0]<=i)
                memo[0][i] = profits[0];
        }

        for(int i = 1;i<profits.length;i++){
            for(int j = 1;j<capacity+1;j++){
                int p1 = 0,p2;
                if(weights[i]<=j){
                    p1 = profits[i]+memo[i-1][j-weights[i]];
                }
                p2 = memo[i-1][j];
                memo[i][j] = Math.max(p1,p2);
            }
        }
        return memo[profits.length-1][capacity];
    }

    private int KSMemo(Integer[][] memo, int[] profits, int[] weights, int index, int capacity) {
        if (index == profits.length)
            return 0;
        if (memo[index][capacity] != null)
            return memo[index][capacity];
        int p1 = 0;
        if (weights[index] <= capacity) {
            p1 = profits[index] + KSMemo(memo, profits, weights, index + 1, capacity - weights[index]);
        }
        int p2 = KSMemo(memo, profits, weights, index + 1, capacity);
        memo[index][capacity] = Math.max(p1, p2);
        return memo[index][capacity];
    }

    private int KSRec(int[] profits, int[] weights, int index, int capacity) {
        if (index == profits.length)
            return 0;
        int p1 = 0;
        if (weights[index] <= capacity) {
            p1 = profits[index] + KSRec(profits, weights, index + 1, capacity - weights[index]);
        }
        int p2 = KSRec(profits, weights, index + 1, capacity);
        return Math.max(p1, p2);
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
        maxProfit = ks.solveKnapsack(profits, weights, 6);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }
}
