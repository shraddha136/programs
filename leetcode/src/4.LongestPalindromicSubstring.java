class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPal(s.substring(i, j))) {
                    longest = s.substring(i, j).length() > longest.length() ? s.substring(i, j) : longest;
                }
            }
        }
        return longest;
    }

    private boolean isPal(String s) {
        StringBuilder rev = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--)
            rev.append(s.charAt(i));
        return s.contentEquals(rev.toString());
    }


    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
    }
}
