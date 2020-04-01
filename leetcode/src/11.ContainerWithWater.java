class ContainerWithWater {
    public int maxArea(int[] height) {

        int maxAmt = Integer.MIN_VALUE;
        for(int i = 0;i<height.length;i++){
            int j = 0;
            int leftAr = 0;
            while(j<i){
                int minHt = Math.min(height[i],height[j]);
                leftAr = Math.max(leftAr,(i - j)*minHt);
                j++;
            }

            j = height.length-1;
            int rightAr = 0;
            while(j>i){
                int minHt = Math.min(height[i],height[j]);
                rightAr = Math.max(rightAr, (j - i) * minHt);
                j--;
            }
            maxAmt = Math.max(maxAmt,Math.max(leftAr,rightAr));
        }
        return maxAmt;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new ContainerWithWater().maxArea(height));
    }
}
