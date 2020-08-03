import java.util.*;

public class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || words == null || words.length == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        for (String word : words) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        if (boardContainsWord(word, board, 0, i, j)) {
                            result.add(word);
                        }
                    }
                }
            }
        }
        return result;
    }

    private boolean boardContainsWord(String word, char[][] board, int index, int i, int j) {
        if(index >= word.length()){
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length  || board[i][j] != word.charAt(index)) {
            return false;
        }
        char c = board[i][j];
        board[i][j] = '#';
        boolean containsWord = boardContainsWord(word, board, index + 1, i - 1, j) || boardContainsWord(word, board, index + 1, i + 1, j) || boardContainsWord(word, board, index + 1, i, j - 1) || boardContainsWord(word, board, index + 1, i, j + 1);
        board[i][j] = c;
        return containsWord;
    }

    public static void main(String[] args) {
//        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
//        String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {{'a'},{'a'}};
        String[] words = {"aa"};
        System.out.println(new WordSearch2().findWords(board,words));
    }
}
