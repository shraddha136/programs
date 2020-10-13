import java.util.*;

public class BullsAndCows {
    public String getHint(String secret, String guess) {

        Map<Character, Integer> secCount = new HashMap<>();
        for (char c : secret.toCharArray()) {
            secCount.put(c, secCount.getOrDefault(c, 0) + 1);
        }
        StringBuilder result = new StringBuilder();
        int bulls = 0;
        int i = 0;
        while (i < secret.length()) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            }
            i++;
        }
        result.append(bulls).append('A');

        int cows = 0;
        for (char c : guess.toCharArray()) {
            if (secCount.containsKey(c) && secCount.get(c) > 0) {
                cows++;
                secCount.put(c, secCount.get(c) - 1);
            }
        }
        result.append(cows-bulls).append('B');
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new BullsAndCows().getHint("1807","7810"));
        System.out.println(new BullsAndCows().getHint("1123",  "0111"));
    }
}
