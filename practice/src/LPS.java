import java.util.HashSet;
import java.util.Set;

public class LPS {
    public int matchDigit(int l, int r, int q){
        int res = 0;
        for(int i = l;i<=r;i++){
            res += getProduct(i,q);
        }
        return res;
    }

    private int getProduct(int i, int q) {
        Set<Integer> number = getDigits(i);
        Set<Integer> product = getDigits(i*q);

        for(int n:product){
            if(number.contains(n))
                return 0;
        }
        return 1;
    }

    private Set<Integer> getDigits(int n) {
        Set<Integer> set = new HashSet<>();
        if(n == 0){
            set.add(0);
            return set;
        }

        while(n!=0){
            int digit = n%10;
            set.add(digit);
            n /= 10;
        }
        return set;
    }

    public static void main(String[] args) {
        System.out.println(new LPS().matchDigit(5,15,2));;
    }
}
