import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


class MinRewards {
    public static int minRewards(int[] scores) {
        // Write your code here.
        List<Integer> mins = new ArrayList<>();
        for(int i = 1;i<scores.length-1;i++){
            if(scores[i-1]>scores[i] && scores[i]<scores[i+1])
                mins.add(i);
        }
        if(scores[0]<scores[1])
            mins.add(0);
        if(scores[scores.length-1]<scores[scores.length-2] && !mins.contains(scores.length-1))
            mins.add(scores.length-1);

        int[] rewards = new int[scores.length];
        Arrays.fill(rewards,1);
        for(int i = 0;i<rewards.length;i++){
            if(mins.contains(i)){
                int j = i-1;
                while(j>=0 && scores[j]>scores[j+1]){
                    rewards[j] = Math.max(rewards[j],rewards[j+1]+1);
                    j--;
                }
                j = i+1;
                while(j<scores.length && scores[j]>scores[j-1]){
                    rewards[j] = rewards[j-1]+1;
                    j++;
                }
            }
        }
        int reward = 0;
        for(int i:rewards){
            reward += i;
            System.out.print(i+",");
        }
        return reward;
    }

    public static void main(String[] args) {
        System.out.println(minRewards(new int[]{8, 4, 2, 1, 3, 6, 7, 9, 5}));
    }
}
