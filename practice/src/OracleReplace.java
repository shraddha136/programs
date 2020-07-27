import com.sun.tools.corba.se.idl.constExpr.Or;

import java.util.HashMap;
import java.util.Map;

public class OracleReplace {
    Map<String,Character> map = new HashMap<>();
    public OracleReplace(){
        map.put("&amp;",'&');
        map.put("&quot;",'\"');
        map.put("&apos;",'\\');
        map.put("&gt;",'>');
        map.put("&lt;",'<');
    }

    public String replace(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i< s.length();i++){
            char c = s.charAt(i);
            if(c == '&'){
                int j = i;
                while(j<s.length() && s.charAt(j)!=';'){
                    j++;
                }
                char repl = map.get(s.substring(i,j+1));
                sb.append(repl);
                i = j;
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        OracleReplace oracleReplace = new OracleReplace();
        System.out.println(oracleReplace.replace("This is &amp;"));
        System.out.println(oracleReplace.replace("This is &amp;&gt;"));
        System.out.println(oracleReplace.replace("This is &&amp;"));
    }
}
