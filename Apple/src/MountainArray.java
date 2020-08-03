public class MountainArray {
    public int find(int[] mountainArray, int num) {
        //get the peak
        //find on the left side
        // if not found, find in right

        int peak = findPeak(mountainArray);
        int result = binarySearch(mountainArray, num, 0, peak, true);
        if (result == -1) {
            return binarySearch(mountainArray, num, peak, mountainArray.length-1, false);
        }
        return result;
    }

    private int binarySearch(int[] mountainArray, int num, int low, int high, boolean left) {
        if (left) {
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (mountainArray[mid] == num) {
                    return mid;
                }
                if(num < mountainArray[mid]){
                    high = mid -1;
                }else{
                    low = mid+1;
                }
            }
        } else {
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (mountainArray[mid] == num) {
                    return mid;
                }
               if(num < mountainArray[mid]){
                   low = mid+1;
               }else{
                   high = mid-1;
               }
            }
        }
        return -1;
    }

    private int findPeak(int[] mountainArray) {
        int low = 0;
        int high = mountainArray.length-1;
        int peak = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mountainArray[mid] < mountainArray[mid + 1]) {
                low = peak = mid + 1;
            } else {
                high = mid;
            }
        }
        return peak;
    }

    public static void main(String[] args) {
        int[] mountain = {1,3,5,7,2,1};
        System.out.println(new MountainArray().find(mountain,0));
        System.out.println(new MountainArray().find(mountain,1));
        System.out.println(new MountainArray().find(mountain,5));
    }
}
