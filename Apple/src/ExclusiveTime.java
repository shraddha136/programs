import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTime {
    public int[] exclusiveTime(int n, List< String > logs) {
        Stack < Integer > stack = new Stack< >();
        int[] res = new int[n];
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int i = 1, prev = Integer.parseInt(s[2]);
        while (i < logs.size()) {
            s = logs.get(i).split(":");
            if (s[1].equals("start")) {
                if (!stack.isEmpty())
                    res[stack.peek()] += Integer.parseInt(s[2]) - prev;
                stack.push(Integer.parseInt(s[0]));
                prev = Integer.parseInt(s[2]);
            } else {
                res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(s[2]) + 1;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        String[] list = {"0:start:0","1:start:2","1:end:5","2:start:6","2:end:9","0:end:12"};
        System.out.println(Arrays.toString(new ExclusiveTime().exclusiveTime(n, Arrays.asList(list))));
    }
}
