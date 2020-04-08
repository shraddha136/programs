public class DivideInteger {
    public static int integerDivide(int x, int y) {
        //TODO: Write - Your - Code
        if (y == 0)
            return -1;
        if (x == y)
            return 1;
        if (y > x)
            return 0;

        int temp = y;
        int quo = 1;
        while (temp < x) {
            temp = temp << 1;
            quo = quo << 1;
        }
        if (temp > x) {
            temp = temp >> 1;
            quo = quo >> 1;
            quo += integerDivide(x - temp, y);
        }
        return quo;
    }

    public static void main(String[] args) {
        System.out.println("7/2 = " + integerDivide(7, 2));
        System.out.println("5/4 = " + integerDivide(5, 4));
        System.out.println("1/3 = " + integerDivide(1, 3));
        System.out.println("40/5 = " + integerDivide(40, 5));
        System.out.println("40/4 = " + integerDivide(40, 4));
    }
}
