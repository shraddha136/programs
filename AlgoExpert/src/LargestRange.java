import java.util.Arrays;
import java.util.Hashtable;

public class LargestRange {
    public static int[] largestRange(int[] array) {
        // Write your code here.
//        Arrays.sort(array);
//        int maxLen = 0;
//        int[] res = {1,1};
//
//
//        int i = 0;
//        while (i < array.length - 1) {
//            int j = i;
//            while (j < array.length - 1 && array[j+1]-array[j] <= 1) {
//                j++;
//            }
//            int len = j - i + 1;
//            if (len > maxLen) {
//                maxLen = len;
//                res[0] = array[i];
//                res[1] = array[j];
//            }
//            i = j + 1;
//
//        }
//
//        return res;
        int maxLen = 0;
        int[] res = {1,1};
        Hashtable<Integer,Boolean> table = new Hashtable<>();
        for (int value : array) table.put(value, true);

        int i = 0;
        while(i<array.length){
            //take the number if it is true
            int n = array[i];
            if(table.get(n)){
                //get its left extreme
                //get its right extreme
                //calculate length and range
                int left = getlast(i,n-1,true,array,table);
                int right = getlast(i,n+1,false,array,table);
                int dist = Math.abs(left-right);
                if(dist>maxLen){
                    maxLen = dist;
                    res[0] = left;
                    res[1] = right;
                }
            }
            i++;

        }
        return res;
    }

    private static int getlast(int i, int n, boolean left, int[] array, Hashtable<Integer, Boolean> table) {
        if(left){
            while(table.containsKey(n)) {
                table.put(n,false);
                n--;
            }
            return n+1;
        }else{
            while(table.containsKey(n)){
                table.put(n,false);
                n++;
            }
            return n-1;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(largestRange(new int[]{1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6,-1})));
        System.out.println(Arrays.toString(largestRange(new int[]{1, 2})));
        System.out.println(Arrays.toString(largestRange(new int[]{1})));
    }
}
