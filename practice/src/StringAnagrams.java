import java.util.*;

class StringAnagrams {
    public static List<Integer> findStringAnagrams(String str, String pattern) {
        List<Integer> resultIndices = new ArrayList<Integer>();
        // TODO: Write your code here
        int i = 0;
        int count = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c:pattern.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);

        for(int j = 0;j<str.length();j++){
            char c = str.charAt(j);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0)
                    count++;
            }
            if(count == map.size())
                resultIndices.add(i);
            if(j >= pattern.length()-1){
                char x = str.charAt(i++);
                if(map.containsKey(x)){
                    if(map.get(x)==0)
                        count--;
                    map.put(x,map.get(x)+1);
                }
            }
        }
        return resultIndices;
    }
    public static void main(String[] args) {
        System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
        System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
    }
}
