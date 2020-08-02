import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland2 {
    public static void main(String[] args) {
        char[][] a = {
                {'S', 'O', 'O', 'S', 'S'},
                {'D', 'O', 'D', 'O', 'D'},
                {'O', 'O', 'O', 'O', 'X'},
                {'X', 'D', 'D', 'O', 'O'},
                {'X', 'D', 'D', 'D', 'O'}};
        System.out.println(getMinSteps(a));
    }

    private static int getMinSteps(char[][] a) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0;i<a.length;i++){
            for(int j = 0;j<a[0].length;j++){
                if(a[i][j]=='S'){
                    queue.offer(new int[]{i,j});
                }
            }
        }

        int steps = 0;
        int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                int[] current = queue.poll();
                for(int[] dir: directions){
                    int newX = current[0]+dir[0];
                    int newY = current[1]+dir[1];
                    if(isValid(newX,newY,a)){
                        if(a[newX][newY]=='X'){
                            return steps+1;
                        }
                        a[newX][newY] = 'D';
                        queue.offer(new int[]{newX,newY});
                    }
                }
            }
            steps++;
        }
        return steps;
    }

    private static boolean isValid(int x, int y, char[][] a) {
        return x >= 0 && y >= 0 && x < a.length && y < a[0].length && a[x][y]!='D';
    }
}
