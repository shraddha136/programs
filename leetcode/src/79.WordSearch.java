import java.util.HashSet;
import java.util.Set;

class WordSearch {
    char[][] board;


    public boolean exist(char[][] board, String word) {
        this.board = board;
        if (word == null || word.length() == 0)
            return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(0, i, j, word))
                    return true;

            }
        }
        return false;
    }

    int[][] directions = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

    private boolean search(int idx, int i, int j, String word) {
        if (idx >= word.length())
            return true;
        if (!isValid(i, j) || this.board[i][j] != word.charAt(idx))
            return false;
        boolean ret = false;
        this.board[i][j] = '#';

        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            ret = search(idx + 1,newI, newJ,word);
            if(ret)
                break;
        }
        this.board[i][j] = word.charAt(idx);
        return ret;
    }

    private boolean isValid(int newI, int newJ) {
        return 0 <= newI && newI <= this.board.length - 1 && 0 <= newJ && newJ <= this.board[0].length - 1;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(new WordSearch().exist(board, "ABCCED"));
        System.out.println(new WordSearch().exist(board, "SEE"));
        System.out.println(new WordSearch().exist(board, "ABCB"));

        board = new char[][]{{'a', 'a'}};
        System.out.println(new WordSearch().exist(board, "aaa"));

        board = new char[][]{{'a'}};
        System.out.println(new WordSearch().exist(board, "b"));

        board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(new WordSearch().exist(board, "ABCESEEEFS"));
//        System.out.println(new WordSearch().exist(board, "aaaaaaaaaaaaa"));
    }
}

//            if (isValid(newI, newJ) && this.board[newI][newJ] == word.charAt(idx)) {
//                if (search(idx + 1, newI, newJ, word)) {
//                    this.board[newI][newJ] = word.charAt(idx);
//                    return true;
//                }
//            }