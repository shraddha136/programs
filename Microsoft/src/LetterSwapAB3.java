public class LetterSwapAB3 {

    //given string S with a's and b's, you can swap 1 a or b at a time for the other letter
    // such that no letter occurs more than 3 times
    //there are fixed pattern we need to consider:
    //3 consecutive : baaab , replace the middle a
    //4 consecutive : baaaab, replace the third a
    //5 consecutive : baaaaab, replace the third a

    public int minSwap(String s){
        int count = 0;
        int len = 0;
        for(int i = 0;i<s.length();i++){
            char cur = s.charAt(i);
            int j = i + 1;
            while(j < s.length() && cur == s.charAt(j)){
                j++;
            }
            len = j - i + 1;
            if(len >= 3){
                while(len > 5){
                    count++;
                    len -= 3;
                }
                count++;
            }
            i = j;
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(new LetterSwapAB3().minSwap("baaab"));
//        System.out.println(new LetterSwapAB3().minSwap("baaaabaaab"));
//        System.out.println(new LetterSwapAB3().minSwap("baaaaaaab"));
        System.out.println(new LetterSwapAB3().minSwap("baaaaaaaaaab"));
    }

}
