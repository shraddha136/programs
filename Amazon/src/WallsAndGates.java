import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    //-1 - A wall or an obstacle.
    //0 - A gate.
    //INF - Infinity means an empty room. We use the
    // value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
    private final int max = 2147483647;

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int distance = 0;
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++distance;
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int[] dir : directions) {
                    int newx = current[0] + dir[0];
                    int newy = current[1] + dir[1];
                    if (isValid(newx, newy, rooms)) {
                        rooms[newx][newy] = distance;
                        queue.offer(new int[]{newx, newy});
                    }
                }
            }
        }
    }

    private boolean isValid(int x, int y, int[][] board) {
        return (x >= 0 && y >= 0 && x < board.length && y < board[0].length && board[x][y] == max);
    }

}
