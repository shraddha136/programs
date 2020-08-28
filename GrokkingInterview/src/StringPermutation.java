import java.util.*;

public class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {
        Map<Character,Integer> pat = new HashMap<>();
        for(char c: pattern.toCharArray()){
            pat.put(c,pat.getOrDefault(c,0)+1);
        }
        int start = 0;
        int end = 0;
        int found = 0;
        for(;end < str.length();end++){
            char c = str.charAt(end);
            if(pat.containsKey(c)){
                pat.put(c,pat.get(c)-1);
                if(pat.get(c)==0){
                    found++;
                }
            }
            if(found==pat.size()){
                return true;
            }
            if(end >= pattern.length()-1){
                char s = str.charAt(start++);
                if(pat.containsKey(s)){
                    if(pat.get(s)==0){
                        found--;
                    }
                    pat.put(s,pat.get(s)+1);
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf", "dc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacb", "abc"));
    }
}
