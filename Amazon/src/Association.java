import java.util.Arrays;
import java.util.List;
import java.util.*;

public class Association {
    static class PairString {
        String first;
        String second;

        public PairString(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    private Map<String, List<String>> map;
    private Set<String> visited;

    Association() {
        map = new HashMap<>();
        visited = new HashSet<>();
    }

    public List<String> largestItemAssociation(List<PairString> itemAssociation) {
        // write your code here
        List<String> result = new ArrayList<>();
        buildGraph(itemAssociation);
        for (String key : map.keySet()) {
            if (!visited.contains(key)) {
                List<String> curr = dfs(key);
                Collections.sort(curr);
                if(curr.size()>result.size()){
                    result = curr;
                }
                else if (curr.size() == result.size() && compare(curr, result) < 0) {
                    result = curr;
                }
            }
        }
        return result;
    }

    private int compare(List<String> curr, List<String> result) {
        int i = 0;
        while (i<curr.size()){
            if(curr.get(i).compareTo(result.get(i))<0){
                return -1;
            }else if(curr.get(i).compareTo(result.get(i))>0){
                return 1;
            }
            i++;
        }
        return 0;
    }

    private List<String> dfs(String key) {
        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.push(key);
        while(!stack.isEmpty()){
            String curr = stack.pop();
            result.add(curr);
            visited.add(curr);
            for(String c : map.get(curr)){
                if(!visited.contains(c)){
                    stack.push(c);
                }
            }
        }
        return result;
    }

    private void buildGraph(List<PairString> itemAssociation) {
        for (PairString pairString : itemAssociation) {
            String f = pairString.first;
            String s = pairString.second;
            map.putIfAbsent(f, new ArrayList<>());
            map.putIfAbsent(s, new ArrayList<>());
            map.get(f).add(s);
            map.get(s).add(f);
        }
    }

    public static void main(String[] args) {
        PairString[] a = {new PairString("Item1", "Item2"), new PairString("Item3", "Item4"), new PairString("Item4", "Item5"),new PairString("Item1", "Item6")};
        System.out.println(new Association().largestItemAssociation(Arrays.asList(a)));
    }
}
