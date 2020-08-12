import java.util.*;

public class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Stack<Integer> ints = new Stack<>();
        Stack<String> str = new Stack<>();
        String res = "";
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int n = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    n = n * 10 + (s.charAt(i) - '0');
                    i++;
                }
                ints.push(n);
            } else if (c == '[') {
                str.push(res);
                res = "";
                i++;
            } else if (c == ']') {
                String st = str.pop();
                int n = ints.pop();
                StringBuilder sb = new StringBuilder(st);
                for (int j = 0; j < n; j++) {
                    sb.append(res);
                }
                res = sb.toString();
                i++;
            } else {
                res += c;
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String a = "3[a2[c]]";
        System.out.println(new DecodeString().decodeString(a));
    }
}
