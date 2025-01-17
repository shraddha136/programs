import java.util.*;

class WordSearch2 {
    char[][] board;


    public String[] exist(char[][] board, String[] words) {
        this.board = board;

        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (word == null || word.length() == 0)
                continue;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (search(0, i, j, word)) {
                        list.add(word);
                        break;
                    }

                }
            }
        }
        return list.toArray(new String[list.size()]);
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
            ret = search(idx + 1, newI, newJ, word);
            if (ret)
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
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
//        System.out.println(Arrays.toString(new WordSearch2().exist(board, words)));
//        System.out.println(new WordSearch().exist(board, "train"));
//        System.out.println(new WordSearch().exist(board, "ABCB"));
//
        board = new char[][]{{'a', 'a'}};
        System.out.println(Arrays.toString(new WordSearch2().exist(board, new String[]{"a"})));
//
//        board = new char[][]{{'a'}};
//        System.out.println(new WordSearch().exist(board, "b"));
//
//        board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
//        System.out.println(new WordSearch().exist(board, "ABCESEEEFS"));
//        System.out.println(new WordSearch().exist(board, "aaaaaaaaaaaaa"));
    }
}

//            if (isValid(newI, newJ) && this.board[newI][newJ] == word.charAt(idx)) {
//                if (search(idx + 1, newI, newJ, word)) {
//                    this.board[newI][newJ] = word.charAt(idx);
//                    return true;
//                }
//            }