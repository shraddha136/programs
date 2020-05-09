public class LVHDist {

    public static int levenshteinDistance(String str1, String str2) {

        return getDist(1, 1, str1, str2);
    }

    private static int getDist(int m, int n, String str1, String str2) {
        if (m == str1.length() && n == str2.length())
            return 0;
        if(m==0 && n == 0)
            return 0;
        else if (m > 0 && n <= 0)
            return m;
        else if (m <= 0 && n > 0)
            return n;

        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return getDist(m+1, n + 1, str1, str2);
        } else {
            return 1 + Math.min(getDist(m - 1, n - 1, str1, str2), Math.min(getDist(m - 1, n, str1, str2), getDist(m, n - 1, str1, str2)));
        }
    }

    public static void main(String[] args) {
        System.out.println(levenshteinDistance("ycc", "c"));
    }
}
