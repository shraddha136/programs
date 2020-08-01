import java.util.*;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        findCombo(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void findCombo(int[] candidates, int index, int target, ArrayList<Integer> list, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (target < 0)
            return;
        for (int i = index; i < candidates.length; i++) {
            if (i == index || candidates[i] != candidates[i - 1]) {
                list.add(candidates[i]);
                findCombo(candidates, i + 1, target - candidates[i], list, result);
                list.remove(list.size() - 1);
            }

        }

    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum2().combinationSum2(new int[]{2,3,6,7}, 7));
        System.out.println(new CombinationSum2().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
        System.out.println(new CombinationSum2().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5));
        System.out.println(new CombinationSum2().combinationSum2(new int[]{2,3,6,7}, 7));
    }
}
