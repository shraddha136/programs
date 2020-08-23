import java.util.Arrays;

public class CandiesSend {
    public int[] distributeCandies(int candies, int num_people) {
        int distributedCandies = 1;
        int index = 0;
        int[] candiesP = new int[num_people];
        while (candies > 0) {
            candiesP[index++ % num_people] += Math.min(candies, distributedCandies);
            candies -= distributedCandies;
           distributedCandies++;
        }
        return candiesP;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CandiesSend().distributeCandies(7, 4)));
        System.out.println(Arrays.toString(new CandiesSend().distributeCandies(10, 3)));
    }
}
