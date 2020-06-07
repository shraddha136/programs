import java.util.*;

class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {
        // TODO: Write your code here
        Map<Character,Integer> map = new HashMap<>();
        for(char c:pattern.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int pLen = pattern.length();
        for(int i = 0;i<str.length();i++){
            char c = str.charAt(i);
            if(map.containsKey(c)){
                for(int j = i;j<i+pattern.length();j++){
                    char x = str.charAt(j);
                    if(map.containsKey(x) && map.get(x)>0){
                        map.put(x,map.get(x)-1);
                        pLen--;
                    }else{
                        for(int k = i;k<j;k++){
                            map.put(str.charAt(k),map.getOrDefault(str.charAt(k),0)+1);
                            pLen++;
                        }
                        break;
                    }
                    if(pLen==0)
                        return true;
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
