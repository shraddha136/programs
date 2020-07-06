public class Maze {


    public static boolean solution(long[][] maze, long n) {
        // Type your solution here
        return visit(0, 0, maze);
    }

    private static boolean visit(int i, int j, long[][] maze) {
        if (i < 0 || j < 0 || i >= maze.length || j >= maze.length || maze[i][j] == 1) {
            return false;
        }
        if (i == maze.length - 1 && j == maze.length - 1 && maze[i][j] == 0) {
            return true;
        }
        maze[i][j] = 1;
        return visit(i - 1, j, maze) || visit(i + 1, j, maze) || visit(i, j - 1, maze) || visit(i, j + 1, maze);
    }


}
