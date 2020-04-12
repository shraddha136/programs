public class PowerNum {
    static double power(double x, int n) {
        //TODO: Write - Your - Code
        if (n == 1)
            return x;
        double r = power(x, n / 2);
        if (n % 2 == 0)
            return r * r;
        else
            return x * r * r;
    }

    public static void main(String[] args) {
        System.out.println(power(3, 5));
    }
}
