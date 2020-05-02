import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.crypto.spec.PSource;
import java.util.LinkedList;
import java.util.Queue;

public class ZombieAttack {
    public int infectHumans(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int zombies = 0;
        int totalZombies = matrix.length * matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    zombies++;
                }
            }
        }

        int hours = 0;
        if (zombies == totalZombies)
            return hours;
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (zombies == totalZombies)
                return hours;
            for (int i = 0; i < size; i++) {
                int[] zombie = queue.poll();
                for (int[] dir : directions) {
                    int newX = zombie[0] + dir[0];
                    int newY = zombie[1] + dir[1];
                    if (isValid(newX, newY, matrix) && matrix[newX][newY] != 1) {
                        matrix[newX][newY] = 1;
                        queue.offer(new int[]{newX, newY});
                        zombies++;
                    }

                }
            }
            hours++;
        }
        return hours;
    }

    private boolean isValid(int x, int y, int[][] matrix) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 0, 0, 0},
                {1, 1, 1, 0,1}};
        System.out.println(new ZombieAttack().infectHumans(matrix));
    }


}
