import javafx.util.Pair;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int[] a = {9, 3, 2, 1, 6};
        System.out.println(get(a));
    }

    private static List<List<Integer>> get(int[] a) {
        Map<Integer, Set<Pair<Integer, Integer>>> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int sum = a[i] + a[j];
                map.putIfAbsent(sum, new HashSet<>());
                map.get(sum).add(new Pair<Integer, Integer>(i, j));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0 ;j < a.length; j++) {
               if(i != j){
                   int target = a[j] - a[i];
                   if(map.containsKey(target)){
                       for(Pair<Integer,Integer> p : map.get(target)){
                           int f = p.getKey();
                           int s = p.getValue();
                           if(s < i && f != i && f != j){
                               result.add(Arrays.asList(a[i], a[j], a[f], a[s]));
                           }
                       }
                   }
               }
            }
        }
        return result;
    }
}
