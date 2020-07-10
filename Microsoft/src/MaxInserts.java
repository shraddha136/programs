public class MaxInserts {
    public static int maxInsertA(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        int aCount = 0;
        int result = 0;

        for(int start = 0;start < s.length();start++){
            if(s.charAt(start)=='a'){
                aCount++;
            }
            if(aCount == 3){
                return -1;
            }
            if(s.charAt(start)!='a'){
                result += 2-aCount;
                aCount = 0;
            }
        }
        if(aCount>=0){
            result += 2 - aCount;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxInsertA("aabab"));
        System.out.println(maxInsertA("dog"));
        System.out.println(maxInsertA("aa"));
        System.out.println(maxInsertA("baaa"));
        System.out.println(maxInsertA("aaba"));
    }
}
