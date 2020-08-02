import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

class AtMostKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0)
            return 0;
        int maxLen = 1;
        int left = 0;
        int right = 0;

        Map<Character, Integer> map = new LinkedHashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);

            if(map.containsKey(c))
                map.remove(c);
            map.put(c, right++);

            if (map.size() == k + 1) {
                Map.Entry<Character, Integer> leftIdx = map.entrySet().iterator().next();
                left = leftIdx.getValue() + 1;
                map.remove(leftIdx.getKey());
            }
            maxLen = Math.max(maxLen, right - left);

        }
        return maxLen;
    }

//    public  int countSubstrings(String s,int k){
//        int count = 0;
//        int x = k;//setting k to x to check all the substrings
//        //using sliding window technique find all substrings of length k and above with K unique characters
//        while(x<s.length()){
//            for(int i=0;i<=s.length()-x;i++){
//                if(hasKdistChars(s.substring(i,i+x),k)){
//                    count++;
//                    //System.out.println(s.substring(i,i+x));
//                }
//            }
//            x++;
//        }
//        return count;
//    }
//    //finding substring has k distinct characters using a set
//    public  boolean hasKdistChars(String str,int k){
//        Set<Character> set = new HashSet<>();
//        for(int i=0;i<str.length();i++){
//            char ch = str.charAt(i);
//            set.add(ch);
//            if(set.size()>k){
//                return false;
//            }
//        }
//        return true;
//    }

    public  int countSubstrings(String s,int k){
        int count = 0;
        int x = k;//setting k to x to check all the substrings
        //using sliding window technique find all substrings of length k and above with K unique characters
        while(x<s.length()){
            for(int i=0;i<=s.length()-x;i++){
                if(hasKdistChars(s.substring(i,i+x),k)){
                    count++;
                    //System.out.println(s.substring(i,i+x));
                }
            }
            x++;
        }
        return count;
    }
    //finding substring has k distinct characters using a set
    public  boolean hasKdistChars(String str,int k){
        Set<Character> set = new HashSet<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            set.add(ch);
            if(set.size()>k){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "LOVELEETCODE";
        String s = "awaglks";
        System.out.println(new AtMostKDistinct().countSubstrings(s, 2));
    }
}
