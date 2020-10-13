public class VersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version1.split("\\.");
        int i = 0;
        int j = 0;
        while (i < v1.length || j < v2.length) {
            int a = i >= v1.length ? 0 : Integer.parseInt(v1[i]);
            int b = j >= v2.length ? 0 : Integer.parseInt(v2[j]);
            if (a < b) {
                return -1;
            } else if (a > b) {
                return 1;
            }
            i++;
            j++;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new VersionNumbers().compareVersion("0.1","1.1"));
    }
}
