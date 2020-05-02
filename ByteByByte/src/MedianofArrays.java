import java.util.Arrays;

public class MedianofArrays {
    public double median(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        int[] total = new int[m+n];
        int i = 0;
        for(int x:nums1)
            total[i++] = x;
        for(int x:nums2)
            total[i++] = x;
        Arrays.sort(total);
        if(total.length%2==0)
            return (total[total.length/2]+total[(total.length/2)-1])/2.0;
        else
            return total[total.length/2]/2.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,5};
        int[] nums2 = {2,4,6};
        System.out.println(new MedianofArrays().median(nums1,nums2));
    }
}
