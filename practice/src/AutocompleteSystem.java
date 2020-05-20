import java.util.*;

class AutocompleteSystem {

    class Node{
        String sentence;
        int times;
        public Node(String sentence, int times){
            this.sentence = sentence;
            this.times = times;
        }
    }
    HashMap<String,Integer> map;
    List<String> list;
    public AutocompleteSystem(String[] sentences, int[] times) {
        map = new HashMap<>();
        for(int i = 0;i<sentences.length;i++){
            map.put(sentences[i],times[i]);
        }
    }

    String key = "";
    public List<String> input(char c) {
        List<String> result = new ArrayList<>();

        if(c == '#'){
            map.put(key, map.getOrDefault(key, 0) + 1);
            key = "";
        }else{
            List<Node> list = new ArrayList<>();
            key += c;
            for(String currKey:map.keySet()){
                if(currKey.indexOf(key)==0){
                    list.add(new Node(currKey,map.get(currKey)));
                }
                Collections.sort(list,
                        new Comparator<Node>() {
                            @Override
                            public int compare(Node o1, Node o2) {
                                return o1.times == o2.times?o1.sentence.compareTo(o2.sentence):o2.times-o1.times;
                            }
                        });
            }
            for(int i = 0;i<Math.min(3,list.size());i++){
                result.add(list.get(i).sentence);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] sentences = {"i love you","island","iroman","i love leetcode"};
        int[] times = {5,3,2,2};
        char[] i = {'i',' ','a','#'};
        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(sentences,times);
        for(char c:i)
            System.out.println(autocompleteSystem.input(c));
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */