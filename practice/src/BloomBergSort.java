import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class BloomBergSort {
    public static void main(String[] args) {
        String[] alphabet = {"a", "b", "c", "ch", "d", "dd", "e", "f", "ff", "g", "ng", "h", "i", "l", "ll", "m", "n", "o", "p", "ph", "r", "rh", "s", "t", "th", "u", "w", "y"};

        String[] input = {"dd r", "n a h", "d e a", "dd", "ng a h"};
        System.out.println(Arrays.toString(Sort(alphabet, input)));
    }

    private static String[] Sort(String[] alphabet, String[] input) {
        Arrays.sort(input, new CustomSort(alphabet));
        return compress(input);
    }

    private static String[] compress(String[] input) {
        for (int i = 0; i < input.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (String s : input[i].split(" ")) {
                sb.append(s);
            }
            input[i] = sb.toString();
        }
        return input;
    }

    private static class CustomSort implements Comparator<String> {
        private final Map<String, Integer> alphabetMap;

        public CustomSort(String[] alphabet) {
            alphabetMap = getMap(alphabet);
        }

        private static Map<String, Integer> getMap(String[] alphabet) {
            Map<String, Integer> alphabetMap = new HashMap<>();
            for (int i = 0; i < alphabet.length; i++) {
                alphabetMap.put(alphabet[i], i);
            }
            return alphabetMap;
        }

        @Override
        public int compare(String o1, String o2) {
            return compareString(o1.split(" "), o2.split(" "));
        }

        private int compareString(String[] o1, String[] o2) {
            int index = 0;
            while (index < o1.length && index < o2.length) {
                if (alphabetMap.get(o1[index]) < alphabetMap.get(o2[index])) {
                    return -1;
                } else if (alphabetMap.get(o1[index]) > alphabetMap.get(o2[index])) {
                    return 0;
                }
                index++;
            }
            if (index == o1.length && index == o2.length) {
                return 0;
            } else if (index < o2.length) {
                return -1;
            } else {
                return 1;
            }

        }
    }
}
