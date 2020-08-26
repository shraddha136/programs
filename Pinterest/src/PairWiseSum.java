import java.util.Arrays;

public class PairWiseSum {
    public static void main(String[] args) {
        int[] a = {1, 3, 5};
        int[] b = {2, 4};
        System.out.println(getPair(a, b, 7));
    }

    private static int getPair(int[] a, int[] b, int target) {
        Arrays.sort(a);
        Arrays.sort(b);
        int index = 0;
        boolean found = false;
        for (int value : a) {
            int id = find(b, target - value) + 1;
            if (id < b.length && b[id] == target - value) {
                found = true;
            }
            index += id;
        }
        if(found)
            return index;
        return -1;
    }

    private static int find(int[] b, int target) {
        int start = 0;
        int end = b.length-1;
        while (start<=end){
            int mid = start + (end - start)/2;
            if(b[mid]>=target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return end;
    }
}
