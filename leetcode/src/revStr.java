import java.util.Arrays;

public class revStr {
    public static void reverseString(char[] s) {
         rev(new String(s));
    }

    private static void rev(String s) {
        if(s.length()==0)
            return ;
        char c = s.charAt(0);
        rev(s.substring(1));
    }

    public static void main(String[] args) {
        reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }
}
