import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonConversion {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("Jon", "Smith");
        map.put("Adam", new String[]{"Jake", null, "Nancy"});
        Map<String, Object> map1 = new HashMap<>();
        map1.put("Mueller", new String[]{null, "Sam"});
        map1.put("Phil", null);
        map1.put("Mike", "Tom");
        map.put("Alex", map1);
        System.out.println(getList(map));
    }

    private static List<String> getList(Map<String, Object> map) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() instanceof String[]) {
                String[] names = (String[]) entry.getValue();
                for (int i = 0; i < names.length; i++) {
                    if (names[i] == null) {
                        result.add(entry.getKey() + "." + i);
                    }
                }
            } else if (entry.getValue() instanceof Map) {
                List<String> curr = getList((Map<String, Object>) entry.getValue());
                for (String s : curr) {
                    result.add(entry.getKey() + "." + s);
                }
            } else if (entry.getValue() == null) {
                result.add(entry.getKey());
            }
        }
        return result;

    }
}
