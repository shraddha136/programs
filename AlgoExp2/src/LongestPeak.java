public class LongestPeak {
    public static int longestPeak(int[] array) {
        // Write your code here.
        if(array == null || array.length == 0)
            return -1;
        int maxPeak = -1;
        for(int i = 1;i<array.length-1;i++){
            //find peak
            if(array[i-1]<array[i]&& array[i]>array[i+1]){
                int j = i-1;
                while(j>0 && array[j-1]<array[j])
                    j--;
                int k = i;
                while(k<array.length-1 && array[k]>array[k+1])
                    k++;
                maxPeak = Math.max(maxPeak,k-j+1);
                i= k;
            }
        }
        return maxPeak;
    }

    public static void main(String[] args) {
        System.out.println(longestPeak(new int[]{1,2,3,3,4,0,10,6,5,-1,-3,2,3}));
    }
}
