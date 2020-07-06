import java.util.*;

class Cipher {
    public static String solution(String word, String cipher) {
        // Type your solution here
        Map<Character, Character> map = new HashMap<>();
        int j = 0;
        Set<Character> set = new HashSet<>();

        for(int i = 0;i<26;i++){
            set.add(cipher.charAt(i));
            map.put((char)(i+'a'),cipher.charAt(i));
        }
        if(set.size()!=26){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for(char c: word.toCharArray()){
            if(!map.containsKey(c)){
                return "";
            }
            sb.append(map.get(c));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("helloworld","bjosxcqukmrhgeeynazldwfpvti"));
    }
}

