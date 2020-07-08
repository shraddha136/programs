import java.util.Stack;

public class LexicographSmallStr {
    //Lexicographically smallest string formed by removing at most one character.

    //use a stack
    //push until you find a char that is smaller than peek
    //if k > 0 && stack is not empty pop
    public static void main(String[] args) {
        System.out.println(lexSmall("abcxd"));
    }

    private static String lexSmall(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int k = 1;
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            while(!stack.isEmpty() && k > 0 && stack.peek()>c){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
