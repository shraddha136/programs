public class LongestCommonSubseq {
    public int lcs(String s, String t){
        if(s == null || t == null)
            return 0;
        return lcsCount(0,0,s,t);

    }

    private int lcsCount(int idx1, int idx2, String s, String t) {
        if(idx1 == s.length() || idx2 == t.length())
            return 0;
        if(s.charAt(idx1)==t.charAt(idx2))
            return 1 + lcsCount(idx1+1,idx2+1,s,t);
        else
            return Math.max(lcsCount(idx1,idx2+1,s,t),lcsCount(idx1+1,idx2,s,t));
    }

    public int lcsDP(String s, String t){
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i = 0;i<dp.length;i++)
            dp[i][0] = 0;
        for(int i = 0;i<dp[0].length;i++)
            dp[0][i] = 0;
        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[s.length()][t.length()];
    }
    public static void main(String[] args) {
        System.out.println(new LongestCommonSubseq().lcsDP("abcde","ace"));
    }
}
