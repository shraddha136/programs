import java.util.Arrays;

public class ReverseWords {
    public static void reverseWords(char[] sentence) {
        //TODO: Write - Your - Code
        String revString = rev(sentence);
        StringBuilder sb = new StringBuilder();
        for(String word:revString.split(" ")){
            sb.append(rev(word.toCharArray()));
            sb.append(" ");
        }
        String result = sb.toString();
        sentence = new char[result.length()-1];
        sentence = result.substring(0,result.length()-1).toCharArray();
    }

    private static String rev(char[] str) {
        int i = 0;
        int j = str.length - 1;
        while (i < j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(str);
    }

    static char[] getArray(String t) {
        char[] s = new char[t.length() + 1];
        int i = 0;
        for (; i < t.length(); ++i) {
            s[i] = t.charAt(i);
        }
        return s;
    }

    public static void main(String[] args) {
        char[] s = getArray("Hello World!");
        System.out.println(s);
        reverseWords(s);
        System.out.println(s);
    }
}
