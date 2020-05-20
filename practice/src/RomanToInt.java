import java.util.HashMap;

class RomanToInt {
    public int romanToInt(String s) {
        int[] numbers = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0;i<numbers.length;i++){
            map.put(romans[i],numbers[i]);
        }
        int number = 0;
        for(int i = s.length()-1;i>=0;i--){
            if(i<s.length()-1 && map.get(s.charAt(i)+"")<map.get(s.charAt(i+1)+"")){
                    number = number - map.get(s.charAt(i)+"");
            }
            else
                number = number + map.get(s.charAt(i)+"");
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInt().romanToInt("XX"));
    }
}