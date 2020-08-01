import java.util.*;

public class MaxNonOverlappingSubString {
    Map<Character, Integer> left;
    Map<Character, Integer> right;

    MaxNonOverlappingSubString() {
        left = new HashMap<>();
        right = new HashMap<>();
    }

    public List<String> maxNumOfSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        getLeftAndRightIndices(s);
        return getSubStrings(s, new ArrayList<String>());
    }

    private void getLeftAndRightIndices(String s) {
        for (char c : s.toCharArray()) {
            left.put(c, s.length());
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            left.put(c, Math.min(left.get(c), i));
            right.put(c, i);
        }
    }

    private List<String> getSubStrings(String s, List<String> result) {
        int rightIdx = -1;
        for (int i = 0; i < s.length(); ++i) {
            if (i == left.get(s.charAt(i))) {
                int newRightIdx = getRightIndex(s, i);
                if (newRightIdx != -1) {
                    if (i > rightIdx) {
                        result.add("");
                    }
                    rightIdx = newRightIdx;
                    result.set(result.size() - 1, s.substring(i, rightIdx + 1));
                }
            }
        }
        return result;
    }

    private int getRightIndex(String s, int index) {
        int rightIdx = right.get(s.charAt(index));
        for (int id = index; id <= rightIdx; ++id) {
            if (left.get(s.charAt(id)) < index) {
                return -1;
            }
            rightIdx = Math.max(rightIdx, right.get(s.charAt(id)));
        }
        return rightIdx;
    }

    public static void main(String[] args) {
        String s = "baddacxb";
        System.out.println(new MaxNonOverlappingSubString().maxNumOfSubstrings(s));
    }
}
