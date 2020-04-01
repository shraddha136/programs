import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
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
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{1, 2, 3,4}));
    }
}
