public class MaxSubArraySum {
    public static int maxSubsetSumNoAdjacent(int[] array) {
        array[1] = Math.max(array[0],array[1]);
        for(int i = 2;i<array.length;i++){
            array[i] = Math.max(array[i-1],array[i]+array[i-2]);
        }
        return array[array.length-1];
    }

    public static void main(String[] args) {
        System.out.println(maxSubsetSumNoAdjacent(new int[]{75,105,120,75,90,135}));
    }
}
