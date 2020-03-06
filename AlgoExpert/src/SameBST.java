import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class SameBST {

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        // Write your code here.
        if (arrayOne.size() != arrayTwo.size())
            return false;
        if(arrayOne.size()==0)
            return true;
        if (arrayOne.get(0).intValue() ==(arrayTwo.get(0).intValue())) {
            List<Integer> a1Small = getSmall(arrayOne, arrayOne.get(0));
            List<Integer> a2Small = getSmall(arrayTwo, arrayTwo.get(0));
            List<Integer> a1Large = getLarge(arrayOne, arrayOne.get(0));
            List<Integer> a2Large = getLarge(arrayTwo, arrayTwo.get(0));
            return sameBsts(a1Small, a2Small) && sameBsts(a1Large, a2Large);
        } else
            return false;
    }

    private static List<Integer> getSmall(List<Integer> array, Integer integer) {
        List<Integer> smalls = new ArrayList<>();
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) <= integer)
                smalls.add(array.get(i));
        }
        return smalls;
    }

    private static List<Integer> getLarge(List<Integer> array, Integer integer) {
        List<Integer> larges = new ArrayList<>();
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) > integer)
                larges.add(array.get(i));
        }
        return larges;
    }

    public static void main(String[] args) {
        List<Integer> a1 = new ArrayList<>(Arrays.asList(5, 2, -1, 100, 45, 12, 8, -1, 8, 10, 15, 8, 12, 94, 81, 2, -34));
        List<Integer> a2 = new ArrayList<>(Arrays.asList(5, 8, 10, 15, 2, 8, 12, 45, 100, 2, 12, 94, 81, -1, -1, -34, 8));
        System.out.println(sameBsts(a1, a2));
         a1 = new ArrayList<>(Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11));
        a2 = new ArrayList<>(Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81));
        System.out.println(sameBsts(a1, a2));
    }

}
