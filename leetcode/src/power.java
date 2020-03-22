public class power {
    public static double myPow(double x, int n) {
        if(n==0)
            return 1;
        if(n<0){
            x = 1/x;
            n = -n;
        }
        double[] pow = new double[n+1];
        pow[0] = 1;
        for(int i = 1;i<=n;i++){
            pow[i] = x * pow[i-1];
        }
        return pow[n];
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.000,-2));
    }
}
