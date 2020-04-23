public class BattleShip {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0)
            return 0;
        int ships = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    ships++;
                    traverse(board, i, j);
                }
            }
        }
        return ships;
    }

    private void traverse(char[][] board, int i, int j) {
        if (i >= board.length || i < 0 || j < 0 || j >= board[0].length || board[i][j] == '.')
            return;
        board[i][j] = '.';
        traverse(board, i + 1, j);
        traverse(board, i, j + 1);
    }

    public static void main(String[] args) {
        System.out.println(new BattleShip().countBattleships(new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}}));
    }
}
