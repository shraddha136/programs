import java.util.HashMap;
import java.util.HashSet;

public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
//        HashMap<Character,Integer> map = new HashMap<>();
//        for(char c:S.toCharArray())
//            map.put(c,map.getOrDefault(c,0)+1);
//        int count = 0;
//        for(char c:J.toCharArray()){
//            count += map.getOrDefault(c, 0);
//        }
//        return count;
        HashSet<Character> set = new HashSet<>();
        for (char c : J.toCharArray())
            set.add(c);
        int count = 0;
        for (char c : S.toCharArray())
            if (set.contains(c))
                count++;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new JewelsAndStones().numJewelsInStones("aA", "aAAbbbb"));
        System.out.println(new JewelsAndStones().numJewelsInStones("z", "ZZ"));
        System.out.println(new JewelsAndStones().numJewelsInStones("z", "0"));
    }
}
