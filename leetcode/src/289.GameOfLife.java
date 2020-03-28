import java.util.Arrays;

class GameOfLife {
    public void gameOfLife(int[][] board) {
        int[][] copyArray = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1 && rule1(board, i, j) || board[i][j] == 1 && rule3(board, i, j))
                    copyArray[i][j] = 0;

                if (board[i][j] == 0 && rule4(board, i, j))
                    copyArray[i][j] = 1;

                if (board[i][j] == 1 && rule2(board, i, j))
                    copyArray[i][j] = 1;
            }
        }

        adjustArray(board, copyArray);
    }

    private void adjustArray(int[][] board, int[][] copyArray) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != copyArray[i][j])
                    board[i][j] = copyArray[i][j];
            }
        }
    }

    int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

    //Any live cell with fewer than two live neighbors dies, as if caused by under-population.
    private boolean rule1(int[][] board, int i, int j) {
        int neighbours = 0;
        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (isValid(board, newI, newJ)) {
                if (board[newI][newJ] == 1)
                    neighbours++;
            }
        }
        return neighbours < 2;
    }

    private boolean isValid(int[][] board, int newI, int newJ) {
        if (0 <= newI && newI < board.length && 0 <= newJ && newJ < board[0].length)
            return true;
        return false;
    }

    //Any live cell with two or three live neighbors lives on to the next generation.
    private boolean rule2(int[][] board, int i, int j) {
        int neighbours = 0;
        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (isValid(board, newI, newJ)) {
                if (board[newI][newJ] == 1)
                    neighbours++;
            }
        }
        return neighbours == 2 || neighbours == 3;
    }

    //Any live cell with more than three live neighbors dies, as if by over-population..
    private boolean rule3(int[][] board, int i, int j) {
        int neighbours = 0;
        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (isValid(board, newI, newJ)) {
                if (board[newI][newJ] == 1)
                    neighbours++;
            }
        }
        return neighbours > 3;
    }

    //Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
    private boolean rule4(int[][] board, int i, int j) {
        int neighbours = 0;
        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (isValid(board, newI, newJ)) {
                if (board[newI][newJ] == 1)
                    neighbours++;
            }
        }
        return neighbours == 3;
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
