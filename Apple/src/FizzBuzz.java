import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        Map<Integer,String> map = new HashMap<>();
        map.put(3,"Fizz");
        map.put(5,"Buzz");

        List<String> result = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            StringBuilder sb = new StringBuilder();
            for(int key: map.keySet()){
                System.out.println(key);
                if(i%key == 0){
                    sb.append(map.get(key));
                }
            }
            if(sb.length()==0){
                sb.append(i);
            }
            result.add(sb.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FizzBuzz().fizzBuzz(15));
    }
}
