import java.util.Stack;

public class Decode {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> str = new Stack<>();
        String res = "";


        int index = 0;
        while(index < s.length()){
            char c = s.charAt(index);
            if(Character.isDigit(c)){
                int n = 0;
                while(index<s.length() && Character.isDigit(s.charAt(index))){
                    n = n * 10 + s.charAt(index)-'0';
                    index++;
                }
                counts.push(n);
            }else if(Character.isAlphabetic(c)){
                res += c;
                index++;
            }else if(c == '['){
                str.push(res);
                res = "";
                index++;
            }else if(c==']'){
                StringBuilder sb = new StringBuilder(str.pop());
                int n = counts.pop();
                for(int i = 0;i<n;i++){
                    sb.append(res);
                }
                res = sb.toString();
                index++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new Decode().decodeString("3[a2[c]]"));
    }

}
