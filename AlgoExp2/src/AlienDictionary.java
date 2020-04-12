import java.util.*;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        List<Character> sortedOrder = new ArrayList<>();
        if (words == null || words.length == 0)
            return sortedOrder.toString();
        //Step 1: Initialize
        HashMap<Character, Integer> inDegree = new HashMap<>();
        HashMap<Character, List<Character>> graph = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                inDegree.put(c, 0);
                graph.put(c, new ArrayList<>());
            }
        }

        //Step 2: build graph
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];
            if(first.startsWith(second) || second.startsWith(first))
                return "";
            for (int j = 0; j < Math.min(first.length(), second.length()); j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    graph.get(first.charAt(j)).add(second.charAt(j));
                    inDegree.put(second.charAt(j), inDegree.get(second.charAt(j))+1);
                    break;
                }
            }
        }

        //Step 3: find sources
        Queue<Character> sources = new LinkedList<>();
        for(Map.Entry<Character,Integer> entry:inDegree.entrySet()){
            if(entry.getValue()==0)
                sources.offer(entry.getKey());
        }

        //Step 4: find sorted order
        while(!sources.isEmpty()){
            Character source = sources.poll();
            sortedOrder.add(source);
            List<Character> children = graph.get(source);
            for(char c: children){
                inDegree.put(c,inDegree.get(c)-1);
                if(inDegree.get(c)==0)
                    sources.offer(c);
            }
        }
        if(sortedOrder.size()!=inDegree.size())
            return "";
        StringBuilder sb = new StringBuilder();
        for(char c:sortedOrder)
            sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(new AlienDictionary().alienOrder(words));
    }
}
