public class ValidPalindrome2 {
    public boolean validPalindrome(String s) {
        int x = isPalRemoveOne(s);
        return x != -2;
    }

    private int isPalRemoveOne(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else{
                if(isPal(s,i,j-1))
                    return i;
                if(isPal(s,i+1,j))
                    return j;
                return -2;
            }
        }
        return -2;
    }

    private boolean isPal(String s,int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome2().validPalindrome("abca"));
    }
}
