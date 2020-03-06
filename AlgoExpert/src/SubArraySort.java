import java.util.Arrays;

public class SubArraySort {
    public static int[] subarraySort(int[] array) {
        // Write your code here.
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<array.length;i++){
            if(!outOfOrder(array,i)){
                min = Math.min(min,array[i]);
                max = Math.max(max,array[i]);
            }
        }
        if(max==Integer.MIN_VALUE)
            return new int[]{-1,-1};

        int i = 0;
        while(array[i]<=min)
            i++;
        int j = array.length-1;
        while(array[j]>=max)
            j--;
        return new int[]{i,j};
    }
    private static boolean outOfOrder(int[] array, int i){
        if(i==0)
            return array[i]<=array[i+1];
        else if(i==array.length-1)
            return array[i]>=array[i-1];
        else
            return array[i-1]<=array[i] && array[i]<=array[i+1];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(subarraySort(new int[]{0,1,1,2,3,5,8,13,21,34,55,89})));
        System.out.println(Arrays.toString(subarraySort(new int[]{2, 1})));
    }

}
