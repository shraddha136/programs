public class LongestPalSubSeq {
    public int LPSQ(String s){
        if(s == null || s.length()==0)
            return 0;
        return lcsq(s,0,s.length()-1);
    }

    private int lcsq(String s, int i, int j) {
        if(i>j)
            return 0;
        if(i==j)
            return 1;
        if(s.charAt(i)==s.charAt(j)){
            return 2 + lcsq(s,i+1,j-1);
        }else{
            return Math.max(lcsq(s,i+1,j),lcsq(s,i,j-1));
        }
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalSubSeq().LPSQ("abdbca"));
        System.out.println(new LongestPalSubSeq().LPSQ("cddpd"));
        System.out.println(new LongestPalSubSeq().LPSQ("pqr"));
    }
}
