public class SurroundRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (board[i][j] == 'O') {
                    if (shouldFlip(i, j, board)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    private boolean shouldFlip(int i, int j, char[][] board) {
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (board[x][y] == 'O' && (x == 0 || y == 0 || x == board.length - 1 || y == board[0].length - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        new SurroundRegions().solve(board);
    }
}
