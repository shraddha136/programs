import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NextPerm {
    public void nextPermutation(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(new ArrayList<>());

        for (int n : nums) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                List<Integer> currPrem = queue.poll();
                for (int j = 0; j <= currPrem.size(); j++) {
                    List<Integer> newPrem = new ArrayList<>(currPrem);
                    newPrem.add(j,n);
                    if (newPrem.size() == nums.length)
                        result.add(newPrem);
                    else
                        queue.offer(newPrem);
                }
            }
        }
        System.out.println(result);

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        new NextPerm().nextPermutation(nums);
    }
}
