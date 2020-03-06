public class makeChange {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        // Write your code here.
        int[] ways = new int[n+1];
        ways[0] = 1;
        for(int m = 0;m<denoms.length;m++){
            for(int i = 0;i<ways.length;i++){
                if(i>=denoms[m]){
                    ways[i] += ways[i-denoms[m]];
                }
            }
        }

        return ways[n];
    }

    public static void main(String[] args) {
        System.out.println(numberOfWaysToMakeChange(0,new int[]{2,3,4,7}));
    }
}
