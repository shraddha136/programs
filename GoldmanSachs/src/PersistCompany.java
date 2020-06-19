import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Persistant {
    double price;
    int day;
    int interval;
    int count;
    boolean valid;

    public Persistant(double newPrice,int newDay){
        this.price = newPrice;
        this.day = newDay;
        this.valid = true;
        this.count = 1;
    }

    public void add(double newPrice, int newDay){
        if(!valid){
            return;
        }
        if(!canAdd(newPrice,newDay)){
            valid = false;
            return;
        }
        if(count == 1){
            interval = Math.abs(newDay - day);
        }
        day = newDay;
        count++;
    }
    private boolean canAdd(double newPrice,int newDay){
        return newPrice == price && (count < 2 || Math.abs(newDay - day)==interval);
    }
}

public class PersistCompany {


/* DATA
  ("Whole Foods", 48.11, 5),
  ("Comcast", 89.99, 10),
  ("Comcast", 89.99, 20),
  ("Comcast", 89.99, 30),
  ("T-Mobile", 40.00, 45),
  ("T-Mobile", 40.00, 55),
  ("T-Mobile", 40.33, 65),
  ("Jetblue", 20.11, 80),
  ("Jetblue", 20.11, 90),
  ("Jetblue", 20.11, 95),
*/

    static String[] c = new String[]{"Whole Foods", "Comcast", "Comcast", "Comcast", "T-Mobile", "T-Mobile", "T-Mobile", "Jetblue", "Jetblue", "Jetblue"};

    static double[] p = new double[]{48.11, 89.99, 89.99, 89.99, 40.00, 40.00, 40.33, 20.11, 20.11, 20.11};

    static int[] t = new int[]{5, 10, 20, 30, 45, 55, 65, 80, 90, 95};

    public static void main(String[] args) {
        for (String company : getPersistantCompanies()) System.out.println(company);
    }

    private static List<String> getPersistantCompanies() {
        Map<String,Persistant> companyMap = new HashMap<>();
        for(int i = 0;i<c.length;i++){
            String name = c[i];
            if(!companyMap.containsKey(name)){
                companyMap.put(name,new Persistant(p[i],t[i]));
            }else{
                companyMap.get(name).add(p[i],t[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for(String company:companyMap.keySet()){
            Persistant persistant = companyMap.get(company);
            if(persistant.valid && persistant.count >= 3){
                result.add(company);
            }
        }
        return result;
    }
}