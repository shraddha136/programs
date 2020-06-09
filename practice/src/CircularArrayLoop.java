class CircularArrayLoop {

    public static boolean loopExists(int[] arr) {
        // TODO: Write your code here
        int i = 0;
        int jumps = 0;
        int len = arr.length;
        int nextIndex = 0;
        while(jumps < len){
            nextIndex = getIndex(nextIndex,arr);
            jumps++;
            if(nextIndex == 0)
                return true;
        }
        return nextIndex == 0;
    }

    private static int getIndex(int i, int[] arr){
        return (arr[i] + i ) % arr.length;
    }

    public static void main(String[] args) {
        System.out.println(CircularArrayLoop.loopExists(new int[] { 1, 2, -1, 2, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 2, -1, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 1, -1, -2 }));
    }
}