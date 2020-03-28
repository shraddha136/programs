import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParentheses {
    static class Parens {
        String s;
        int open;
        int close;

        public Parens(String s, int open, int close) {
            this.s = s;
            this.open = open;
            this.close = close;
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Queue<Parens> queue = new LinkedList<>();
        queue.offer(new Parens("", 0, 0));
        while (!queue.isEmpty()) {
            Parens currStr = queue.poll();
            if (currStr.open == n && currStr.close == n)
                result.add(currStr.s);
            else {
                if (currStr.open < n) {
                    queue.offer(new Parens(currStr.s + "(", currStr.open + 1, currStr.close));
                }
                if (currStr.open > currStr.close) {
                    queue.offer(new Parens(currStr.s + ")", currStr.open, currStr.close + 1));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(2));
    }
}
