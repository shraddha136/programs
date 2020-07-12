import java.util.HashMap;
import java.util.Map;

public class SnakesAndLadders {
    class Cell {
        int row;
        int col;
        int boardVal;
        int value;
        Cell(int row, int col, int boardVal, int val) {
            this.row = row;
            this.col = col;
            this.boardVal = boardVal;
            this.value = val;
        }
    }
    default int x;

    private Cell[] cellValues;
    Map<Cell, Integer> positionToValue;

    SnakesAndLadders() {
        cellValues = new Cell[37];
        positionToValue = new HashMap<>();
    }

    public int snakesAndLadders(int[][] board) {
        initialize(board);
        int count = 0;
        count = traverse(0,0,board);
        return count;
    }

    private int traverse(int row, int col, int[][] board, int count) {
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length){
            return 0;
        }
        if(board[row][col] != -1){
            Cell newPosition = cellValues[board[row][col]];
            row = newPosition.row;
            col = newPosition.col;
            count += traverse(row,col,board,count);
        }
        count += traverse(row,col,board,count);
        count += traverse(row,col,board,count);
        count += traverse(row,col,board,count);
        count += traverse(row,col,board,count);
        count += traverse(row,col,board,count);
        count += traverse(row,col,board,count);

    }

    private void initialize(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        int i = row - 1;
        int j = 0;
        boolean forward = true;
        int count = 1;
        while (count <= 36) {
            Cell cell = new Cell(i, j, board[i][j],count);
            cellValues[count] = cell;
            positionToValue.put(cell, count);
            if (forward) {
                j++;
            }else{
                j--;
            }
            if (j == col || j < 0) {
                if (j == col) {
                    j = col - 1;
                }
                if (j < 0) {
                    j = 0;
                }
                i--;
                forward = !forward;
            }
            count++;
        }
    }

    public static void main(String[] args) {
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}};
        new SnakesAndLadders().snakesAndLadders(board);
    }
}
