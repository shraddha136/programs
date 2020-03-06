public class Levenshtein {
    public static int levenshteinDistance(String str1, String str2) {
        // Write your code here.
        int[][] edit = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                edit[i][0] = i;
                edit[0][j] = j;
            }
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    edit[i][j] = edit[i - 1][j - 1];
                } else {
                    edit[i][j] = 1 + Math.min(edit[i - 1][j - 1], Math.min(edit[i - 1][j], edit[i][j - 1]));
                }
            }
        }
        return edit[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "yabd";
        System.out.println(levenshteinDistance(str1, str2));
    }
}
