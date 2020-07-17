public class LongestSubArrayKReplace {
    // 0 1 0 1 0 1 1 1 0

    public int maxSubArray(int[] array,int k){
        int start = 0;
        int zCount = 0;
        int end = 0;
        int maxLen = 0;
        while (end < array.length){
            if(array[end] == 0){
                zCount++;
            }
            if(zCount > k){
                if(array[start]==0){
                    zCount--;
                }
                start++;
            }
            maxLen = Math.max(end - start+1,maxLen);
            end++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] array = {0,1,0,0,0,1,1,1,0};
        System.out.println(new LongestSubArrayKReplace().maxSubArray(array,2));
    }
}
