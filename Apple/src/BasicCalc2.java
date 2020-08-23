import java.util.Stack;

public class BasicCalc2 {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        s = s.trim().replace(" ", "");

        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                n = n * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(c) || i == s.length() - 1) {
                if (sign == '-') {
                    stack.push(-n);
                }
                if (sign == '+') {
                    stack.push(n);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * n);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / n);
                }
                sign = s.charAt(i);
                n = 0;
            }
        }
        for (int i : stack) {
            result += i;
        }
        return result;
    }

    private int operate(int op1, int op2, char sign) {
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
        System.out.println(new BasicCalc2().calculate("3+2*2"));
        System.out.println(new BasicCalc2().calculate(" 3+5 / 2 "));
    }
}
