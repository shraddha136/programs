import java.util.HashMap;
import java.util.HashSet;

public class RottenOranges {
    public static int orangesRotting(int[][] grid) {
        HashSet<String> fresh = new HashSet<>();
        HashSet<String> rotten = new HashSet<>();

        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    rotten.add(i+","+j);
                }
                if(grid[i][j]==1){
                    fresh.add(i+","+j);
                }
            }
        }

        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        int mins = 0;

        while(!fresh.isEmpty()){
            HashSet<String> infected = new HashSet<>();
            for(String rot:rotten){
                String[] rots = rot.split(",");
                int rotI = Integer.parseInt(rots[0]);
                int rotJ = Integer.parseInt(rots[1]);
                for(int[] dir:directions){
                    int newI = rotI + dir[0];
                    int newJ = rotJ + dir[1];
                    String newIJ = newI+","+newJ;
                    if(fresh.contains(newIJ)){
                        fresh.remove(newIJ);
                        infected.add(newIJ);
                    }
                }
            }
            if(infected.size()==0)
                return -1;
            mins++;
            rotten = infected;
        }
        return mins;
    }
}
