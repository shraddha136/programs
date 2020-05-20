import java.util.ArrayList;
import java.util.Arrays;

public class CompareVersion {
    public int compareVersion(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        boolean allEq = true;
        while (i < v1.length || j < v2.length) {
            int p = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int q = j < v2.length ? Integer.parseInt(v2[j]) : 0;

            if (p != q)
                return p < q ? -1 : 1;


        i++;
        j++;
    }
        return 0;
}

    public static void main(String[] args) {
        System.out.println(new CompareVersion().compareVersion("7.5.2.4", "7.5.3"));
    }
}
