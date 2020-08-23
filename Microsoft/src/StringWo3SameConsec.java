public class                                            StringWo3SameConsec {
    public static String stringWithout3IdenticalConsecLetters(String str){
        if(str == null || str.length()==0){
            return str;
        }

        char[] c = str.toCharArray();
        int start = 0;
        int end = 0;
        int count = 0;
        while(end < c.length){
            char curr = c[end];
            while(end < c.length && curr == c[end]){
                end++;
                count++;
            }
            if(count >= 3){
                while(end-start >= 3){
                    c[start++] = ' ';
                }
            }
            start = end;
            count = 0;
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : c){
           if(ch != ' '){
               sb.append(ch);
           }
        }
        return sb.toString();
    }
    public static String stringWithout3IdenticalConsecLetters2(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int cnt = 1;
        for(int r=1;r<s.length();r++) {
            char c = s.charAt(r);
            if(c == s.charAt(r-1))
                cnt++;
            else {
                cnt = 1;
            }
            if(cnt < 3)
                sb.append(c);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(stringWithout3IdenticalConsecLetters2("eedaaad"));
        System.out.println(stringWithout3IdenticalConsecLetters2("xxxtxxx"));
        System.out.println(stringWithout3IdenticalConsecLetters2("uuuuxaaaaxuuu"));
    }
}
