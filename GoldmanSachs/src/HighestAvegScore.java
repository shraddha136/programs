import java.util.*;

public class HighestAvegScore {
    public static void main(String[] args) {
        String[][] marks = {{"Bob", "87"}, {"Mike", "35"}, {"Bob", "52"}, {"Jason", "35"}, {"Mike", "55"}, {"Jessica", "99"}};
        System.out.println(new HighestAvegScore().getHighestAvg(marks));
    }

    private int getHighestAvg(String[][] marks) {
        Map<String, List<Integer>> scoreMap = new HashMap<>();
        for(String[] score:marks){
            String name = score[0];
            int scoreVal = Integer.parseInt(score[1]);
            List<Integer> scoreList = new ArrayList<>();
            if(scoreMap.containsKey(name)){
                scoreList = scoreMap.get(name);
            }
            scoreList.add(scoreVal);
            scoreMap.put(name,scoreList);
        }
        int maxAvg = 0;
        for(String key: scoreMap.keySet()){
            List<Integer> scoreList = scoreMap.get(key);
            int average = calculateAverage(scoreList);
            maxAvg = Math.max(maxAvg,average);
        }
        return maxAvg;
    }

    private int calculateAverage(List<Integer> scoreList) {
        int sum = 0;
        for(int score:scoreList){
            sum += score;
        }
        double avg = sum/scoreList.size();
        return (int)Math.floor(avg);
    }
}
