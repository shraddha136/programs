import java.util.*;

public class CompositeKey {

    List<Object> objectList;
    static int id = 1;
    public CompositeKey(Object... keyValues) {
        objectList = new ArrayList<>();
        for(Object key:keyValues){
            objectList.add(key);
        }
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof CompositeKey){
            CompositeKey k = (CompositeKey)  o;
            return this.objectList.equals(k.objectList);
        }
        return false;
    }

    @Override
    public int hashCode(){
        int hcode = this.objectList.hashCode();
        id++;
        return hcode+(id%2);
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Map<CompositeKey, String> map = new HashMap<>();
        CompositeKey key1 = new CompositeKey("1", 2, new Date(3000000));
        CompositeKey dupkey1 = new CompositeKey("1", 2, new Date(3000000));
        map.put(key1, "value1");
        map.put(dupkey1, "value2");

        if ("value1".equals(map.get(new CompositeKey("1", 2, new Date(3000000))))) {
            System.out.println("matches");
        } else {
            System.out.println("not matches");
        }
        if ("value1".equals(map.get(new CompositeKey("1", 2, new Date(3000000))))) {
            System.out.println("matches");
        } else {
            System.out.println("not matches");
        }
    }
}
