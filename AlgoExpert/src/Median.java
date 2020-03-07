class Median {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length==0)
            return nums2[nums2.length/2];
        if(nums2.length==0)
            return nums1[nums1.length/2];
        int m = nums1.length;
        int n = nums2.length;
        int[] mixed = new int[m+n];



        int i = 0;
        int j = 0;
        int k = 0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                mixed[k++] = nums1[i++];
            }else{
                mixed[k++] = nums2[j++];
            }
        }
        while(i<m){
            mixed[k++] = nums1[i++];
        }
        while(j<n){
            mixed[k++] = nums2[j++];
        }

        k = m + n;
        if(mixed.length%2==0){
            return (mixed[k/2]+mixed[(k/2)-1])/2.0;
        }else{
            return mixed[k/2];
        }
    }
}