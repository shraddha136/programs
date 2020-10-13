import java.util.*;

public class EntityParser {
    public String entityParser(String text) {
        Map<String,Character> map = new HashMap<>();
        map.put("&quot;",'\"');
        map.put("&apos;",'\'');
        map.put("&amp;",'&');
        map.put("&gt;",'>');
        map.put("&lt;",'<');
        map.put("&frasl;",'/');

        StringBuilder sb = new StringBuilder();
        for(int i = text.length()-1;i>=0;i--){
            char c = text.charAt(i);
            if(c == ';'){
                int j = i;
                while(j >= 0 && text.charAt(j)!='&'){
                    j--;
                }
                String curr = text.substring(j,i+1);
                String replace = map.containsKey(curr)? String.valueOf(map.get(curr)) :curr;
                sb.insert(0,replace);
                i = j;
            }else{
                sb.insert(0,c);
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new EntityParser().entityParser("&amp; is an HTML entity but &ambassador; is not."));
        System.out.println(new EntityParser().entityParser("and I quote: &quot;...&quot;"));
        System.out.println(new EntityParser().entityParser("Stay home! Practice on Leetcode :)"));
        System.out.println(new EntityParser().entityParser("x &gt; y &amp;&amp; x &lt; y is always false"));
        System.out.println(new EntityParser().entityParser("leetcode.com&frasl;problemset&frasl;all"));
    }
}
