import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PythagoreanTriplets {
    static List<int[]> findPythagoreanTriplets(int[] arr) {
        //TODO: Write - Your - Code
        List<int[]> triplets = new ArrayList<int[]>();
        Arrays.sort(arr);

        for(int i = 0;i<arr.length;i++){
            int a = arr[i];
            int j = i + 1;
            int k = arr.length - 1;
            while(j<k){
                int b = arr[j];
                int c = arr[k];
                if(a * a + b * b == c * c)
                    triplets.add(new int[]{a,b,c});
                if(a * a + b * b > c * c){
                    int currJ = j;
                    while(arr[currJ] == arr[j] && j < k)
                        j++;
                }else{
                    int currK = k;
                    while(arr[currK] == arr[k] && j < k)
                        k--;
                }
            }
        }
        return triplets;
    }

    public static void main(String[] argv) {
        int[] l1 = {4,16,1,2,3,5,6,8,25,10};

        List<int[]> t1 = findPythagoreanTriplets(l1);

        System.out.println("Original: " + Arrays.toString(l1));
        String result = "";

        for (int[] a : t1) {
            Arrays.sort(a);
            result += "[";
            for (int x : a) {
                result += Integer.toString(x) + ",";
            }
            result = result.replaceAll(",$", "");
            result += "]";
        }
        System.out.println("Pythagorean triplets: " + result);
    }
}
