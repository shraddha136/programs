import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Perms {
    public static List<String> permute(String str) {
        char[] nums = str.toCharArray();
        Queue<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();
        queue.add("");

        for (char num : nums) {
            int n = queue.size();
            for (int k = 0; k < n; k++) {
                String currPerm = queue.poll();
                for (int j = 0; j <= currPerm.length(); j++) {
                    StringBuilder newPerm = new StringBuilder(currPerm);
                    newPerm.insert(j, num);
                    if (newPerm.length() == nums.length) {
                        result.add(String.valueOf(newPerm));
                    } else
                        queue.add(String.valueOf(newPerm));
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(permute("oidbcaf"));
    }
}