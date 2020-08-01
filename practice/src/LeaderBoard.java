import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class LeaderBoard {

    private Map<Integer, Integer> mapPlayerIdToScore;
    private TreeMap<Integer, Integer> mapScoreToCount;

    public LeaderBoard() {
        mapPlayerIdToScore = new HashMap<>();
        mapScoreToCount = new TreeMap<>(Collections.reverseOrder());
    }

    public void addScore(int playerId, int score) {
        if (mapPlayerIdToScore.containsKey(playerId)) {
            int currentScore = mapPlayerIdToScore.get(playerId);
            mapPlayerIdToScore.put(playerId, currentScore + score);
            mapScoreToCount.put(currentScore, mapScoreToCount.get(currentScore) - 1);
            if (mapScoreToCount.get(currentScore) == 0) {
                mapScoreToCount.remove(currentScore);
            }
            mapScoreToCount.put(currentScore + score, mapScoreToCount.getOrDefault(currentScore + score, 0) + 1);
        } else {
            mapPlayerIdToScore.put(playerId,score);
            mapScoreToCount.put(score,mapScoreToCount.getOrDefault(score,0)+1);
        }
    }

    public int top(int K) {
        int topScore = 0;
        for(int score:mapScoreToCount.keySet()){
            for(int i = 0;i<mapScoreToCount.get(score);i++){
                topScore+= score;
                K--;
                if(K == 0){
                    return topScore;
                }
            }
        }
        return topScore;
    }

    public void reset(int playerId) {
        int score = mapPlayerIdToScore.get(playerId);
        mapScoreToCount.put(score,mapScoreToCount.get(score)-1);
        if(mapScoreToCount.get(score)==0){
            mapScoreToCount.remove(score);
        }
        mapPlayerIdToScore.remove(playerId);
    }

    public static void main(String[] args) {
        LeaderBoard LeaderBoard = new LeaderBoard ();
        LeaderBoard.addScore(1,73);   // LeaderBoard = [[1,73]];
        LeaderBoard.addScore(2,56);   // LeaderBoard = [[1,73],[2,56]];
        LeaderBoard.addScore(3,39);   // LeaderBoard = [[1,73],[2,56],[3,39]];
        LeaderBoard.addScore(4,51);   // LeaderBoard = [[1,73],[2,56],[3,39],[4,51]];
        LeaderBoard.addScore(5,4);    // LeaderBoard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
        LeaderBoard.top(1);           // returns 73;
        LeaderBoard.reset(1);         // LeaderBoard = [[2,56],[3,39],[4,51],[5,4]];
        LeaderBoard.reset(2);         // LeaderBoard = [[3,39],[4,51],[5,4]];
        LeaderBoard.addScore(2,51);   // LeaderBoard = [[2,51],[3,39],[4,51],[5,4]];
        LeaderBoard.top(3);           // returns 141 = 51 + 51 + 39;
    }
}
