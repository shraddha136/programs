import java.util.*;

public class HoursOfVariation {
    public int getVariationCount(Integer[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int validVariation = 0;
        List<Integer> list = new ArrayList(Arrays.asList(nums));
        Set<List<Integer>> allPermutations = getPerms(list);
        for (List<Integer> newList : allPermutations) {
            if (isValidVariation(newList)) {
                validVariation++;
            }
        }
        return validVariation;
    }

    private boolean isValidVariation(List<Integer> list) {
        int h = list.get(0) * 10 + list.get(1);
        int m = list.get(2) * 10 + list.get(3);
        return 0 <= h && h <= 23 && 0 <= m && m <= 59;
    }

    private Set<List<Integer>> getPerms(List<Integer> asList) {
        Set<List<Integer>> allPerms = new HashSet<>();
        Collections.sort(asList);
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(new ArrayList<>());
        for (int n : asList) {
            int size = queue.size();
            for (int x = 0; x < size; x++) {
                List<Integer> currentPerm = queue.poll();
                for (int j = 0; j <= currentPerm.size(); j++) {
                    List<Integer> newList = new ArrayList<>(currentPerm);
                    newList.add(j,n);
                    if (newList.size() == asList.size()) {
                        allPerms.add(newList);
                    } else {
                        queue.offer(newList);
                    }
                }
            }
        }
        return allPerms;
    }

    public static void main(String[] args) {
        System.out.println(new HoursOfVariation().getVariationCount(new Integer[]{2,1,2,1}));
        System.out.println(new HoursOfVariation().getVariationCount(new Integer[]{1,0,0,2}));
        System.out.println(new HoursOfVariation().getVariationCount(new Integer[]{1,4,8,2}));
        System.out.println(new HoursOfVariation().getVariationCount(new Integer[]{4,4,4,4}));
    }
}
