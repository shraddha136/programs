class SingleCycle {
    public static boolean hasSingleCycle(int[] array) {
        // Write your code here.
        int eleCounts = 0;
        int start = 0;
        while(eleCounts<array.length){
            if(eleCounts>0&& start==0) return false;
            eleCounts++;
            start = getIdx(start,array);
        }
        return start==0;
    }

    private static int getIdx(int idx,int[] array) {
        return (array.length + (idx + array[idx]))%array.length;
    }

    public static void main(String[] args) {
        int[] array = {2,3,1,-4,-1,2};
        System.out.println(hasSingleCycle(array));

    }
}
