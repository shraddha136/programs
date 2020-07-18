import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubStringK {
    public static void main(String[] args) {
//        System.out.println(getSubStrings("abacab",3));
        System.out.println(getSubStrings("awaglknagawunagwkwagl",4));
    }

    private static List<String> getSubStrings(String s, int k) {
        int start = 0;
        List<String> result = new ArrayList<>();
        Map<Character,Integer> charCount = new HashMap<>();
        for(int end = 0;end<s.length();end++){
            char c = s.charAt(end);
            if(charCount.get(c)==null){
                charCount.put(c,end);
            }else{
                int index = charCount.get(c)+1;
                while(start<index ){
                    charCount.remove(s.charAt(start++));
                }
                charCount.put(c,end);
            }
            if(end-start+1==k && charCount.size()==k){
                String res = s.substring(start,end+1);
                if(!result.contains(res)){
                    result.add(res);
                }
            }
            if(charCount.size()==k){
                charCount.remove(s.charAt(start++));
            }
        }
        return result;
    }
}
