import javafx.util.Pair;

import java.util.*;

public class TargetSumPro {
    public static void main(String[] args) {
        int[] a = {9, 3, 2, 1, 6};
        System.out.println(getSum(a));
    }

    private static List<List<Integer>> getSum(int[] a) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer,List<Pair<Integer,Integer>>> map = new HashMap<>();
        for(int i = 0;i<a.length;i++){
            for(int j = i+1;j<a.length;j++){
                if(!map.containsKey(a[i]+a[j])){
                    map.put(a[i]+a[j], new ArrayList<Pair<Integer,Integer>>());
                }
                map.get(a[i]+a[j]).add(new Pair<>(i,j));
            }
        }

        for(int i = 0;i<a.length;i++){
            for(int j = 0;j<a.length;j++){
                if(i != j){
                    int target = a[j]-a[i];
                    if(map.containsKey(target)){
                        List<Pair<Integer,Integer>> list = map.get(target);
                        for(Pair<Integer,Integer> pair: list){
                            int one = pair.getKey();
                            int two = pair.getValue();
                            if(two < i && j != one && j != two){
                                result.add(new ArrayList(Arrays.asList(a[one],a[two],a[i],a[j])));
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
