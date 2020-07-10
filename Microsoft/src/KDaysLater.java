import java.util.HashMap;
import java.util.Map;

public class KDaysLater {
    private static Map<String,Integer> dayNumber;
    private static String[] days;

    private static void initialize(){
        days = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        dayNumber = new HashMap<>();
        for(int i = 0;i<7;i++){
            dayNumber.put(days[i],i);
        }
    }
    public static String kDaysLater(String day, int k){
        int dayIndex = dayNumber.get(day);
        int newIndex = (dayIndex+k)%7;
        return days[newIndex];
    }

    public static void main(String[] args) {
        initialize();
        System.out.println(kDaysLater("Wed",2));
        System.out.println(kDaysLater("Sat",23));
    }
}
