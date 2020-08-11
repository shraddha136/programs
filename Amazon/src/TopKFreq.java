import java.util.*;

public class TopKFreq {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList[] bucket = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(entry.getKey());
        }
        int[] result = new int[k];
        int index = 0;
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size(); j++) {
                    result[index++] = (int) bucket[i].get(j);
                    k--;
                    if (k == 0) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

//    public List<String> topKFrequent(String[] words, int k) {
//        Map<String, Integer> map = new HashMap<>();
//        for (String word : words) {
//            map.put(word, map.getOrDefault(word, 0) + 1);
//        }
//
//        ArrayList<String>[] count = new ArrayList[words.length + 1];
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            if (count[entry.getValue()] == null) {
//                count[entry.getValue()] = new ArrayList<>();
//            }
//            count[entry.getValue()].add(entry.getKey());
//        }
//
//        List<String> result = new ArrayList<>();
//        for (int i = count.length - 1; i >= 0; i--) {
//            if (count[i] != null) {
//                for (int j = 0; j < count[i].size(); j++) {
//                    if (k > 0) {
//                        result.add(count[i].get(j));
//                        k--;
//                    }
//                    if (k == 0) {
//                        return result;
//                    }
//                }
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(new TopKFreq().topKFrequent(a, 2)));
    }
}
