 import java.util.*;

public class FindSubsets {
    static void findAllSubsets(List<Integer> v, List<HashSet<Integer>> sets) {
        //TODO: Write - Your - Code

        sets.add(new HashSet<>());
        for(int n:v){
            int size = sets.size();
            for(int i = 0;i<size;i++){
                HashSet<Integer> oldValue = new HashSet<>(sets.get(i));
                oldValue.add(n);
                sets.add(oldValue);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] myints = new Integer[] {2,5,7};
        List<Integer> v = new ArrayList<Integer>();
        for (Integer i : myints) {
            v.add(i);
        }
        List<HashSet<Integer>> subsets = new ArrayList<HashSet<Integer>>();

        findAllSubsets(v, subsets);

        for (int i = 0; i < subsets.size(); ++i) {
            System.out.print("{ ");
            for (Integer it : subsets.get(i)) {
                System.out.print(it + " ");
            }
            System.out.println("}");
        }
    }
}
