import java.util.*;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {


        int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> result = new ArrayList<>();
        generateCombos(candidates, 0, k, n, new ArrayList<>(), result);
        return result;
    }


    private void generateCombos(int[] candidates, int index, int max, int target, List<Integer> current, List<List<Integer>> result) {
        if (index >= candidates.length || target < 0) {
            return;
        }

        if (target == 0 && current.size() == max) {
            result.add(new ArrayList<>(current));
        }

        for (int i = index; i < candidates.length; i++) {
            current.add(candidates[i]);
            generateCombos(candidates, i + 1, max, target - candidates[i], current, result);
            current.remove(current.size() - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum3().combinationSum3(3,7));
    }
}
