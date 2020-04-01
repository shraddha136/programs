import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();

        HashMap<Integer, String> map = new HashMap<Integer, String>() {
            {
                put(3, "Fizz");
                put(5, "Buzz");
            }
        };

        for (int i = 1; i <= n; i++) {
            StringBuilder ans = new StringBuilder();
            for (int m : map.keySet()) {
                if (i % m == 0)
                    ans.append(map.get(m));
            }
            if (ans.length() == 0)
                ans.append(i);
            list.add(ans.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new FizzBuzz().fizzBuzz(15));
    }
}
