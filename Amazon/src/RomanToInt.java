import java.util.*;

public class RomanToInt {
    public int romanToInt(String s) {
        int[] numbers = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        Map<String,Integer> map = new HashMap<>();
        for(int i = 0;i<numbers.length;i++){
            map.put(romans[i],numbers[i]);
        }
        System.out.println(map.size());
        int num = 0;
        for(int i = s.length()-1;i>=0;i--){
            char c= s.charAt(i);
            if(i<s.length()-2 && map.get(s.charAt(i)+"")<map.get(s.charAt(i+1)+"")){
                num -= map.get(s.charAt(i)+"");
            }else{
                System.out.println(c);
                num += map.get(c+"");
            }
        }
        return num;
    }
}
