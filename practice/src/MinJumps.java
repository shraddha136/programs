class ArrayJump {

    public int countMinJumps(int[] jumps) {
        int[] dp = new int[jumps.length];
        return this.countMinJumpsRecursive(dp, jumps, 0);
    }

    private int countMinJumpsRecursive(int[] dp, int[] jumps, int currentIndex) {
        if(currentIndex == jumps.length-1)
            return 0;
        if(jumps[currentIndex]==0)
            return Integer.MAX_VALUE;
        if(dp[currentIndex]!=0)
            return dp[currentIndex];
        int minJUmp = 0;
        int start = currentIndex+1;
        int end = currentIndex+jumps[currentIndex];
        for(int i = start;i<=end && i<jumps.length;i++){
            int min = countMinJumpsRecursive(dp,jumps,i);
            if(min!=0)
                minJUmp = Math.min(minJUmp,min+jumps[i]);
        }
        dp[currentIndex] = minJUmp;
        return dp[currentIndex];
    }

    public static void main(String[] args) {
        ArrayJump aj = new ArrayJump();
        int[] jumps = {1,2,5,2,1,2};
        System.out.println(aj.countMinJumps(jumps));
        jumps = new int[]{2,3,4,5};
        System.out.println(aj.countMinJumps(jumps));
    }
}
