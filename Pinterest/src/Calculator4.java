import java.util.Stack;

public class Calculator4 {
    public int calculate(String s) {
        int res = 0;
        if (s == null || s.length() == 0) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        stack.push(0);
        s = s.replace(" ", "");
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            if (c == '(') {
                int j = i + 1;
                while (j < s.length() && s.charAt(j) != ')') {
                    j++;
                }
                String m = s.substring(i, j);
                int p = calculate(m);
                stack.push(operate(sign, p, stack.pop()));
            } else if (Character.isDigit(s.charAt(i))) {
                int n = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    n = n * 10 + s.charAt(i) - '0';
                    i++;
                }

                stack.push(operate(sign, n, stack.pop()));
            } else {
                sign = c;
                i++;
            }
        }
        return stack.pop();
    }

    private int operate(char sign, int op1, int op2) {
        switch (sign) {
            case '+':
                return op1 + op2;
            case '-':
                return op2 - op1;
            case '*':
                return op1 * op2;
            case '/':
                return op2 / op1;
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(new Calculator4().calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
