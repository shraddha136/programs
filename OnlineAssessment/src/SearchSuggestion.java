import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SearchSuggestion {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TreeMap<String,Integer> map = new TreeMap<>();
        Arrays.sort(products);

        for(int i = 0;i<products.length;i++)
            map.put(products[i],i);

        String key = "";
        List<String> prodList = Arrays.asList(products);
        List<List<String>> list = new ArrayList<>();
        for(char c:searchWord.toCharArray()){
            key+= c;
            String ceil = map.ceilingKey(key);
            String floor = map.floorKey(key+'~');
            if(ceil == null || floor == null)
                break;

            list.add(prodList.subList(map.get(ceil),Math.min(map.get(ceil)+3,map.get(floor)+1)));
        }
        while (list.size() < searchWord.length()) list.add(new ArrayList<>());
        return list;
    }

    public static void main(String[] args) {
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        System.out.println(new SearchSuggestion().suggestedProducts(products, searchWord));
    }
}
