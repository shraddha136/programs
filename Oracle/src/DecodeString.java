import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        if(s == null || s.length() == 0){
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        Stack<StringBuilder> character = new Stack<>();
        Stack<Integer> num = new Stack<>();
        while(i<s.length()){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int n = 0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    n = n * 10 + s.charAt(i)-'0';
                    i++;
                }
                num.push(n);
            }else if(c == '['){
                character.push(sb);
                sb = new StringBuilder();
                i++;
            }else if(c == ']'){
                StringBuilder curr = character.pop();
                int n = num.pop();
                for(int j = 0;j<n;j++){
                    curr.append(sb);
                }
                sb = curr;
                i++;
            }else{
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
        System.out.println(new DecodeString().decodeString("3[a2[c]]"));
        System.out.println(new DecodeString().decodeString("2[abc]3[cd]ef"));
        System.out.println(new DecodeString().decodeString("abc3[cd]xyz"));
    }
}
