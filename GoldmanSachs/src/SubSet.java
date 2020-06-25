import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SubSet {

    public String createSubsets(String str){
        char[] cArray = str.toCharArray();
        List<List<Character>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        int maxLen = maxHeap.peek().length();
        boolean done = false;
        for(char c:cArray){
            int size = result.size();
            for(int i = 0;i<size;i++){
                List<Character> present = new ArrayList<>(result.get(i));
                present.add(c);
                result.add(present);
                if(present.size()==maxLen){
                    done = true;
                }
            }
            if(done){
                break;
            }
        }
        for(List<Character> word:result){
            String w = String.valueOf(word);

        }
    }

    static PriorityQueue<String> maxHeap  = new PriorityQueue<>((a,b)->(b.length()-a.length()));
    public static void main(String[] args){
        String str = "atdoer";
        String[] a = {"to", "toe", "top"};
        for(String x:a){
            maxHeap.offer(x);
        }
        System.out.println(new SubSet().createSubsets(str));
    }
}
/**
 * abc
 * ""
 * "" "a"
 * "" "a" "b" "ab"
 */

