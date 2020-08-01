import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReversePolish {
    public int evalRPN(String[] tokens) {
        int result = 0;

        Stack<Integer> stack = new Stack<>();
        for (String c : tokens) {
            if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
                result = performOp(c, stack);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(c));
            }
        }
        return result;
    }

    private int performOp(String c, Stack<Integer> stack) {
        int op1 = stack.pop();
        int op2 = stack.pop();

        if (c.equals("+")) {
            return op1 + op2;
        } else if (c.equals("-")) {
            return op2 - op1;
        } else if (c.equals("*")) {
            return op1 * op2;
        } else if (c.equals("/")) {
            return op2 / op1;
        }
        return 0;
    }

    int solve(int n, List<String> blocks) {

        Stack<Integer> s = new Stack<Integer>();

        int totalScore = 0;
        int currentScore = 0;

        for (int i = 0; i < n; ++i) {
            String current = blocks.get(i);

            if ("Z".equals(current)) {
                if (!s.empty()) {
                    int val = Integer.valueOf(s.pop());
                    totalScore = totalScore - val;
                }
            } else if ("X".equals(current)) {
                if (!s.empty()) {
                    int val = Integer.valueOf(s.pop());
                    currentScore = 2 * val;
                    s.push(currentScore);
                    totalScore += currentScore;
                }
            } else if ("+".equals(current)) {
                if (!s.empty() && s.size() >= 2) {
                    int first = Integer.valueOf(s.pop());
                    int second = Integer.valueOf(s.pop());
                    currentScore = first + second;
                    s.push(first);
                    s.push(currentScore);
                    totalScore += currentScore;
                }
            } else {
                currentScore = Integer.valueOf(current);
                s.push(currentScore);
                totalScore += currentScore;
            }

            //System.out.println("Stack: " + s +" totalScore: " + totalScore);
        }

        return totalScore;
    }

    public static void main(String[] args) {
//        String[] s = {"2","1","+","3","*"};
//        System.out.println(new ReversePolish().evalRPN(s));
        String[] s = {"1", "2", "+", "X", "X", "Z", "3", "Z", "Z"};
        System.out.println(new ReversePolish().solve(8, Arrays.asList(s)));
    }
}
