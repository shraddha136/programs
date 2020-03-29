import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterComboPhoneNumber {
    public List<String> letterCombinations(String digits) {
        Map<Integer,String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        String[] input = getInput(map,digits);

        return combo(map,input);
    }

    private String[] getInput(Map<Integer, String> map, String digits) {
        String[] ip = new String[digits.length()];
        int i = 0;
        for(String s:digits.split("")){
            ip[i++] = map.get(Integer.parseInt(s));
        }
        return ip;
    }

    private List<String> combo(Map<Integer, String> map, String[] input) {

    return null;
    }
}
