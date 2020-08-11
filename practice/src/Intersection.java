//import java.util.*;
//
//public class Intersection {
//    public int[] intersection(int[] nums1, int[] nums2) {
//        List<int[]> l1 = Arrays.asList(nums1);
//        List<int[]> l2 = Arrays.asList(nums2);
//        Collections.sort(l1);
//        Collections.sort(l2);
//        int one = 0;
//        int two = 0;
//
//        int size = Math.min(l1.size(), l2.size());
//        int[] result = new int[size];
//        int index = 0;
//        while (one < l1.size() && two < l2.size()) {
//            if (l1.get(one) == l2.get(two)) {
//                result[index++] = l1.get(one);
//                while (one < l1.size() - 1 && l1.get(one).equals(l1.get(one + 1))) {
//                    one++;
//                }
//                while (two < l2.size() - 1 && l2.get(two).equals(l2.get(two + 1))) {
//                    two++;
//                }
//            } else {
//                if (l1.get(one) < l2.get(two)) {
//                    while (one < l1.size() - 1 && l1.get(one).equals(l1.get(one + 1))) {
//                        one++;
//                    }
//                } else {
//                    while (two < l2.size() - 1 && l2.get(two).equals(l2.get(two + 1))) {
//                        two++;
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//}
