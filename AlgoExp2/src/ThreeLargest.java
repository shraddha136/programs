import java.util.Arrays;

public class ThreeLargest {
    public static int[] findThreeLargestNumbers(int[] array) {
        // Write your code here.
        int[] largest = {Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
        for(int i = 0;i<array.length;i++){
            if(array[i]>=largest[0]){
                largest[2] = largest[1];
                largest[1] = largest[0];
                largest[0] = array[i];
            }else if(array[i]<=largest[0] && array[i]>largest[1]){
                largest[2] = largest[1];
                largest[1] = array[i];
            }else if(array[i]<=largest[1] && array[i]>largest[0]){
                largest[0] = array[i];
            }
        }
        Arrays.sort(largest);
        return largest;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(findThreeLargestNumbers(new int[]{141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7})));
        System.out.println(Arrays.toString(findThreeLargestNumbers(new int[]{7, 7, 7})));
    }
}
