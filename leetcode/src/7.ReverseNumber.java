class ReverseNumber {
    public int reverse(int x) {
        int n = 0;
        int rev = 0;
        while (x != 0) {
            int remainder = x % 10;
            n = n * 10 + remainder;
            if ((n - remainder) / 10 != rev)
                return 0;
            x = x / 10;
            rev = n;

        }
        return n;
    }

    public static void main(String[] args) {
//        System.out.println(new ReverseNumber().reverse(-123));
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(Integer.MAX_VALUE );
    }
}
