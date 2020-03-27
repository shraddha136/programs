class HappyNumber {
    public boolean isHappy(int n) {
        int slow = sumOfSquares(n);
        int fast = sumOfSquares(sumOfSquares(n));

        while (slow != fast) {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
            if (slow == fast){
                break;
            }

        }
        return slow == 1;
    }

    private int sumOfSquares(int n) {
        int sum = 0;
        while (n != 0) {
            int x = n % 10;
            sum += x * x;
            n = n / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(12));
        System.out.println(new HappyNumber().isHappy(23));
    }
}
