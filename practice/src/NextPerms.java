import java.util.ArrayList;
import java.util.List;

class NextPerms {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            numbers.add(i);
        }

        StringBuilder result = new StringBuilder();

        while(numbers.size()>0){
            int totalPerms = factorial(n-1);
            int slot = k/totalPerms;
            result.append(numbers.get(slot));
            result.append(",");
            n = n-1;
            k = k-(slot*totalPerms);
            numbers.remove(slot);
        }
        return result.toString();
    }

    private int factorial(int n){
        int[] fact = new int[n+1];
        fact[0] = 1;
        fact[1] = 1;
        for(int i = 2;i<=n;i++){
            fact[i] = i * fact[i-1];
        }
        return fact[n];
    }

    public static void main(String[] args) {
        System.out.println(new NextPerms().getPermutation(4,9));
    }

}