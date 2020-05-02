public class Knapsack {
    public int knapSack(int[] weights, int[] values, int maxWeight) {
        return KS(0,weights,values,maxWeight);
    }

    private int KS(int index, int[] weights, int[] values, int maxWeight) {
        if(index == values.length || maxWeight <= 0)
            return 0;
        int val1 = 0;
        if(weights[index]<=maxWeight)
         val1 = values[index] + KS(index+1,weights,values,maxWeight-weights[index]);
        int val2 = KS(index+1,weights,values,maxWeight);
        return Math.max(val1,val2);
    }

    public static void main(String[] args) {
        int[] values = {1,6,10,16};
        int[] weights = {1, 2, 3,5};
        System.out.println(new Knapsack().knapSack(weights, values, 7));
        System.out.println(new Knapsack().knapSack(weights, values, 6));
    }
}
