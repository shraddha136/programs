public class Factorial {
    public int recFac(int n){
        if(n<=1){
            return 1;
        }
        return n * recFac(n-1);
    }

    public int iterFac(int n){
        int ans = 1;
        for(int i = 1;i<=n;i++){
            ans *= i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Factorial().iterFac(6));
        System.out.println(new Factorial().recFac(6));
    }
}
