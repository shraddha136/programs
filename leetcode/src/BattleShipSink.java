import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BattleShipSink {
    public static String solution(int N, String S, String T) {
        int hit = 0;
        int sink = 0;
        List<String> TList = Arrays.asList(T.split(" "));
        String[] SList = S.split(",");
        for (String ship : SList) {
            Set<String> shipPart = new HashSet<>();
            String[] locs = ship.split(" ");
            char top = ship.charAt(0);
            char left = ship.charAt(1);
            char bottom = ship.charAt(3);
            char right = ship.charAt(4);
            for(char i = top; i<=bottom;i++)
                for(char j = left;j<=right;j++)
                    shipPart.add(""+i+j);

            if(TList.containsAll(shipPart))
                sink++;
            else{
                for(String part:shipPart)
                    if(TList.contains(part)){
                        hit++;
                        break;
                    }
            }
        }
        return "sink:"+sink+" hit:"+hit;
    }

    public static void main(String[] args) {
        String ans = solution(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A");
        System.out.println(ans);

        ans = solution(12, "1A 2A,12A 12A", "12A");
        System.out.println(ans);
    }
}
