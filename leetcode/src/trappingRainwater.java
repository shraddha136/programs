import java.util.Stack;

public class trappingRainwater {
    public static int trap(int[] height) {// solution o(n^2)

        int ans = 0;
        for(int j = 0;j<height.length;j++){
            int maxLeft = 0;
            int maxRight = 0;

            for(int i = j;i>=0;i--){
                maxLeft = Math.max(maxLeft,height[i]);
            }
            for(int i = j;i<height.length;i++){
                maxRight = Math.max(maxRight,height[i]);
            }
            ans += (Math.min(maxLeft,maxRight)-height[j]);
        }
        return ans;
    }

    private static int trap2(int height[]){
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int ans = 0;
        while(i<height.length){
            while(!stack.isEmpty() && height[i]>height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty())
                    break;
                int dist = i - stack.peek() - 1;
                int bht = Math.min(height[i],height[stack.peek()]) - height[top];
                ans += (dist * bht);
            }
            stack.push(i);
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap2(height));
    }
}
