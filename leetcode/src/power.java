public class power {
    public static double myPow(double x, int n) {
        if (n >= Integer.MAX_VALUE)
            n = 1;
        else if (n <= Integer.MIN_VALUE)
            n = -1;
        double ans = 1.0;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        for (int i = 0; i < n; i++)
            ans *= x;

        return ans;
    }
    public static boolean isPowerOfTwo(int n) {
        if(n<=0)
            return false;
        if(n == 1)
            return true;
        while(n>1){
            if(n%2==0){
                n /= 2;
            }else return false;

        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(myPow(2.00000,-2147483648));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(4));
        System.out.println(isPowerOfTwo(100));
    }
}
