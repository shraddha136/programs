import com.sun.tools.corba.se.idl.StringGen;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ZombieMatrix {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1, 0, 1}, {0, 1, 0, 1, 0}, {0, 0, 0, 0, 1}, {0, 1, 0, 0, 0}};
        System.out.println(minDays(grid));
    }

    private static int minDays(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int days = 0;
        int zombies = 0;
        HashSet<String> zombieQ = new HashSet<>();
        HashSet<String> humanQ = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    zombieQ.add(i+","+j);
                    zombies++;
                }
                if (grid[i][j] == 0) {
                    humanQ.add(i+","+j);
                }
            }
        }
        int total = grid.length * grid[0].length;
        while (!humanQ.isEmpty()) {
            if (zombies == total) {
                return days;
            }
            HashSet<String> infected = new HashSet<>();
            for (String currentZombie : zombieQ) {
                String[] currentZ = currentZombie.split(",");
                for (int[] dir : directions) {
                    int newX = dir[0] + Integer.parseInt(currentZ[0]);
                    int newY = dir[1] + Integer.parseInt(currentZ[1]);
                    String next = newX +"," + newY;
                    if (humanQ.contains(next)) {
                        infected.add(next);
                        humanQ.remove(next);
                        zombies++;
                    }
                }
            }
            days++;
            zombieQ = infected;
        }
        return days;
    }


}
