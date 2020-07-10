import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxConcat {
    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0) {
            return 0;
        }

        List<String> allWords = getUnique(arr);
        String[] max = new String[1];
        getMaxUnique(allWords, "", max, 0);
        return max[0].length();
    }

    private void getMaxUnique(List<String> allWords, String concat, String[] max, int index) {
        if (index == allWords.size()  && concat.length() > max[0].length()) {
            if(allUnique(concat)){
                max[0] = concat;
            }
            return;
        }
        if (index == allWords.size()) {
            return;
        }
        getMaxUnique(allWords, concat + allWords.get(index), max, index + 1);
        getMaxUnique(allWords, concat, max, index + 1);


    }

    private boolean allUnique(String word) {
        Set<Character> chars = new HashSet<>();
        for (char c : word.toCharArray()) {
            chars.add(c);
        }
        return word.length() == chars.size();
    }

    private List<String> getUnique(List<String> arr) {
        List<String> result = new ArrayList<>();
        for (String word : arr) {
            if (allUnique(word)) {
                result.add(word);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("cha");
        list.add("r");
        list.add("act");
        list.add("ers");
        System.out.println(new MaxConcat().maxLength(list));
    }
}
