import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    final double INF = Math.pow(2,31)-1;
    public void wallsAndGates(int[][] rooms) {
        int room = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0;i<rooms.length;i++){
            for(int j = 0;j<rooms[0].length;j++){
                if(rooms[i][j]==0){
                    queue.offer(new int[]{i,j});
                }
                if(rooms[i][j]==INF){
                    room++;
                }
            }
        }

        if(room == 0)
            return;

        int[][] direction = {{-1,0},{0,-1},{1,0},{0,1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            if(room == 0)
                return;
            for(int i = 0;i<size;i++){
                int[] rm = queue.poll();
                int val = rooms[rm[0]][rm[1]];
                for(int[] dir: direction){
                    int newX = rm[0] + dir[0];
                    int newY = rm[1] + dir[1];
                    if(isValid(newX,newY,rooms) && rooms[newX][newY]==INF){
                        room--;
                        rooms[newX][newY] = val+1;
                        queue.offer(new int[]{newX,newY});
                    }
                }
            }
        }
    }


    private boolean isValid(int x, int y, int[][] rooms){
        return x>=0 && x<rooms.length && y>=0 && y<rooms[0].length;
    }
}
