import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class StrangeSort {
    public String[] strangeSort(String[] nums, int[] mapping) {
        Arrays.sort(nums, new StrangeComparator(mapping));
        return nums;
    }

    private static class StrangeComparator implements Comparator<String> {
        Map<Integer, Integer> numberMap = new HashMap<>();
        Map<String, Integer> convertMap = new HashMap<>();

        StrangeComparator(int[] mapping) {
            for (int i = 0; i < mapping.length; i++) {
                numberMap.put(mapping[i], i);
            }
        }

        @Override
        public int compare(String s1, String s2) {
            return Integer.compare(convert(s1), convert(s2));
        }

        private int convert(String s1) {
            if (convertMap.containsKey(s1)) {
                return convertMap.get(s1);
            }
            int result = 0;
            for (char c : s1.toCharArray()) {
                result = result * 10 + (numberMap.get(c - '0'));
            }
            convertMap.put(s1, result);
            return result;
        }
    }


    public static void main(String[] args) {
        String[] nums = {"12", "02", "4", "023", "65", "83", "224", "50"};
        int[] mapping = {2, 1, 4, 8, 6, 3, 0, 9, 7, 5};
        System.out.println(Arrays.toString(new StrangeSort().strangeSort(nums, mapping)));
    }

    @Test
    public void arrayTest() {
        String[] nums = {"12", "02", "4", "023", "65", "83", "224", "50"};
        String[] expected = {"4", "224", "12", "83", "65", "2", "50", "19"};
        int[] mapping = {2, 1, 4, 8, 6, 3, 0, 9, 7, 5};
        String[] actual = new StrangeSort().strangeSort(nums,mapping);
        assertArrayEquals(expected, actual);
    }

}
