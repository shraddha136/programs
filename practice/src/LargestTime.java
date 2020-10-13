import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestTime {
    public String largestTimeFromDigits(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new LinkedList<>());

        for (int num : nums) {
            int qs = queue.size();
            for (int i = 0; i < qs; i++) {
                List<Integer> oldPerm = queue.poll();
                int n = oldPerm.size();
                for (int j = 0; j <= n; j++) {
                    List<Integer> newPerm = new LinkedList<>(oldPerm);
                    newPerm.add(j, num);
                    if (newPerm.size() == nums.length)
                        result.add(newPerm);
                    else
                        queue.add(newPerm);
                }
            }
        }

        String max = "";
        int maxTime = 0;
        for (List<Integer> curr : result) {
            int hr = curr.get(0) * 10 + curr.get(1);
            int min = curr.get(2) * 10 + curr.get(3);
            int time = hr * 60 + min;
            if (validTime(hr, min) && time >= maxTime) {
                maxTime = time;
                max = (hr < 10 ? "0"+hr : hr) + ":" + (min < 10 ? "0"+min : min);
            }
        }
        return max;
    }

    private boolean validTime(int hr, int min) {
        return 0 <= hr && hr <= 23 && 0 <= min && min <= 59;
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 3, 0};
        System.out.println(new LargestTime().largestTimeFromDigits(a));
        a = new int[]{5, 5, 5, 5};
        System.out.println(new LargestTime().largestTimeFromDigits(a));
    }
}
