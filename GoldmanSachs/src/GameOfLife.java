import java.util.Arrays;

class GameOfLife {
    public void gameOfLife(int[][] board) {
        //kill = -1;
        //alive = -2;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (Math.abs(board[i][j]) == 1) {
                    if (rule1(i, j, board) || rule3(i, j, board)) {
                        board[i][j] = -1;
                    }
                } else {
                    if (rule4(i, j, board)) {
                        board[i][j] = -2;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
                if (board[i][j] == -2) {
                    board[i][j] = 1;
                }
            }
        }

    }

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    private boolean rule1(int i, int j, int[][] board) {
        int neighbors = 0;
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (valid(x, y, board) && Math.abs(board[x][y]) == 1) {
                neighbors++;
            }
        }
        return neighbors < 2;
    }

    private boolean rule3(int i, int j, int[][] board) {
        int neighbors = 0;
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (valid(x, y, board) && Math.abs(board[x][y]) == 1) {
                neighbors++;
            }
        }
        return neighbors > 3;
    }

    private boolean rule4(int i, int j, int[][] board) {
        int neighbors = 0;
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (valid(x, y, board) && Math.abs(board[x][y]) == 1) {
                neighbors++;
            }
        }
        return neighbors == 3;
    }

    private boolean valid(int i, int j, int[][] board) {
        if (i >= 0 && j >= 0 && i < board.length && j < board[0].length)
            return true;
        return false;
    }

    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        new GameOfLife().gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }
}
