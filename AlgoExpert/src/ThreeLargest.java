public class ThreeLargest {
    public static int[] findThreeLargestNumbers(int[] array) {
        int[] largest = {Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
        for(int i = 0;i<array.length;i++){
            updateLargest(i,array,largest);
        }
        return largest;
    }

    private static void updateLargest(int i, int[] array, int[] largest) {
        if(largest[2]<array[i]){
            shift(array[i],largest,2);
        }
        else if(largest[1]<array[i]){
            shift(array[i],largest,1);
        }
        else if( largest[0]<array[i]){
            shift(array[i],largest,0);
        }
    }

    private static void shift(int num, int[] largest, int index) {
        for(int i = 0;i<index;i++){
            largest[i] = largest[i+1];
        }
        largest[index] = num;
    }

    public static void main(String[] args) {
        findThreeLargestNumbers(new int[]{55,7,8});
    }

}
