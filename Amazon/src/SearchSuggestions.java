import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SearchSuggestions {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TreeMap<String,Integer> map = new TreeMap<>();
        List<String> productList = new ArrayList<>();
        Arrays.sort(products);
        for(int i = 0;i<products.length;i++){
            map.put(products[i],i);
            productList.add(products[i]);
        }
        List<List<String>> result = new ArrayList<>();
        StringBuilder key = new StringBuilder();
        for(char c:searchWord.toCharArray()){
            key.append(c);
            String firstIndex = map.ceilingKey(key.toString());
            String secondIndex = map.floorKey((key+"~"));
            if(firstIndex == null || secondIndex == null){
                break;
            }
            result.add(productList.subList(map.get(firstIndex),Math.min(map.get(secondIndex)+1,map.get(firstIndex)+3)));
        }
        return result;
    }

    public static void main(String[] args) {
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
//        String[] products = {"bags","baggage","banner","box","cloths"};
//        String searchWord = "bags";
        System.out.println(new SearchSuggestions().suggestedProducts(products,searchWord));
    }
}
