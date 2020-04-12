import java.util.ArrayList;
        import java.util.List;

public class PalindromeSubstrings {
    public List<List<Character>> allSubstring(String s) {
        List<List<Character>> subset = new ArrayList<>();
        subset.add(new ArrayList<>());

        for (char c : s.toCharArray()) {
            int n = subset.size();
            for (int i = 0; i < n; i++) {
                List<Character> currSet = new ArrayList<>(subset.get(i));
                currSet.add(c);
                subset.add(currSet);
            }
        }
        return subset;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeSubstrings().allSubstring("aabbbaa"));
    }
}
