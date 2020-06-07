class RemoveDuplicates {

    public static int remove(int[] arr) {
        // TODO: Write your code here
        int i = 0;
        int currNum = arr[0];
        int j = 1;
        while(j < arr.length){

            while(j<arr.length && arr[j]==currNum){
                j++;
            }
            if(j != arr.length && arr[j]!=currNum){
                i++;
                arr[i] = arr[j];
                currNum = arr[j];
            }
            j++;

        }
        return i;
    }
    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(RemoveDuplicates.remove(arr));
    }
}
