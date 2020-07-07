public class MaxNetworkRank {
    public int networkRand(int[] A, int[] B, int N){
        int[] ranks = new int[N+1];
        for(int i = 0;i<A.length;i++){
            ranks[A[i]]++;
            ranks[B[i]]++;
        }
        int maxRank = -1;
        for(int i = 0;i < A.length; i++){
            maxRank = Math.max(maxRank,ranks[A[i]]+ranks[B[i]]-1);
        }
        return maxRank;
    }

    public static void main(String[] args) {
        int[] a = { 1,2,3,3 };
        int[] b = { 2,3,1,4};
        int n = 4;
        System.out.println(new MaxNetworkRank().networkRand(a,b,n));
    }
}
