import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, List<Character>> row = new HashMap<>();
        Map<Integer, List<Character>> col = new HashMap<>();
        Map<Integer, List<Character>> box = new HashMap<>();
        //box = (row/3)*3+col/3

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int boxNo = (i / 3) * 3 + (j / 3);
                char val = board[i][j];
                if(val == '.'){
                    continue;
                }
                if (row.containsKey(i)) {
                    if (row.get(i).contains(val)) {
                        return false;
                    }
                } else {
                    row.put(i, new ArrayList<>());
                }
                row.get(i).add(val);

                if (col.containsKey(j)) {
                    if (col.get(j).contains(val)) {
                        return false;
                    }
                } else {
                    col.put(j, new ArrayList<>());
                }
                col.get(j).add(val);

                if (box.containsKey(boxNo)) {
                    if (box.get(boxNo).contains(val)) {
                        return false;
                    }
                } else {
                    box.put(boxNo, new ArrayList<>());
                }
                box.get(boxNo).add(val);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(new ValidSudoku().isValidSudoku(board));
    }

}
