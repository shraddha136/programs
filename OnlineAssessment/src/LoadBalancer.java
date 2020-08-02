import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class LoadBalancer {

    public static void main(String[] args) {
//        int[] ar = {2, 4, 5, 3, 3, 9, 2, 2, 2};
        int[] ar = {1, 1, 1, 1};

        System.out.println(canBalance(ar));
    }

    private static boolean canBalance(int[] ar) {
        int totalSum = getTotal(ar);
        int left = 0;
        int right = ar.length-1;
        int leftSum = 0;
        int rightSum = 0;
        int midSum = 0;

        while(left < right){
            midSum = totalSum - (leftSum+rightSum) - ar[left] - ar[right];
            if(leftSum == midSum && midSum == rightSum){
                return true;
            }
            if(ar[left]<ar[right]){
                leftSum += ar[left++];
            }else{
                rightSum += ar[right--];
            }
        }
        return false;
    }

    private static int getTotal(int[] ar){
        int total = 0;
        for(int n:ar){
            total += n;
        }
        return total;
    }
}
