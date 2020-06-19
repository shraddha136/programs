public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int total = 0;
        for (int i = 0; i < height.length; i++) {
            int l = i - 1;
            int r = i + 1;
            int leftMax = 0;
            int rightMax = 0;
            while (l >= 0) {
                leftMax = Math.max(leftMax, height[l--]);
            }
            while (r < height.length) {
                rightMax = Math.max(rightMax, height[r++]);
            }
            int amount = Math.min(leftMax, rightMax) - height[i];
            if (amount >= 0) {
                total += amount;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] water = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new TrappingRainWater().trap(water));
    }
}
