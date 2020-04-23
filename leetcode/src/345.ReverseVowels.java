import java.util.HashSet;
import java.util.Set;

class ReverseVowels {
    public String reverseVowels(String s) {
        if(s == null || s.length()==0)
            return s;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        int i = 0;
        int j = s.length()-1;
        char[] sArray = s.toCharArray();
        while(i<=j){
            while(i<=j && !vowels.contains(sArray[i]))
                i++;
            if(i >j)
                break;
            while(i<=j && !vowels.contains(sArray[j]))
                j--;
            if(j == 0)
                break;
            char temp = sArray[i];
            sArray[i] = sArray[j];
            sArray[j] = temp;
            i++;
            j--;

        }
        return String.valueOf(sArray);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseVowels().reverseVowels("aA"));
    }
}
