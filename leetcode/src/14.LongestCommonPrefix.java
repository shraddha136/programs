class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        int minLength = minLen(strs);
        int idx = 0;
        for (int i = 0; i < minLength; i++) {
            if (isSame(strs, i)) {
                idx++;
            } else
                break;

        }
        return strs[0].substring(0, idx);

    }

    private boolean isSame(String[] strs, int idx) {
        for (int i = 0; i < strs.length - 1; i++) {
            if (strs[i].charAt(idx) != strs[i + 1].charAt(idx))
                return false;
        }
        return true;
    }

    private int minLen(String[] strs) {
        int min = Integer.MAX_VALUE;
        for (String s : strs)
            min = Math.min(min, s.length());
        return min;
    }

    public static void main(String[] args) {
        String[] str = {"c", "c"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(str));

        str = new String[]{"flower","flow","flight"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(str));
    }
}
