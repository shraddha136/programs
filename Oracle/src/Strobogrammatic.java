import java.util.*;

public class Strobogrammatic {
    List<String> result;

    public List<String> findStrobogrammatic(int n) {
        result = new ArrayList<>();
        findStrobogrammaticFrom(new char[n], 0, n - 1);
        return result;
    }

    private void findStrobogrammaticFrom(char[] curRes, int l, int r) {
        if (l > r) {
            result.add(new String(curRes));
            return;
        }
        if (l == r) {
            curRes[l] = '0';
            result.add(new String(curRes));
            curRes[l] = '1';
            result.add(new String(curRes));
            curRes[l] = '8';
            result.add(new String(curRes));
            return;
        }
        if (l != 0) {
            curRes[l] = '0';
            curRes[r] = '0';
            findStrobogrammaticFrom(curRes, l + 1, r - 1);
        }

        curRes[l] = '1';
        curRes[r] = '1';
        findStrobogrammaticFrom(curRes, l + 1, r - 1);

        curRes[l] = '8';
        curRes[r] = '8';
        findStrobogrammaticFrom(curRes, l + 1, r - 1);

        curRes[l] = '6';
        curRes[r] = '9';
        findStrobogrammaticFrom(curRes, l + 1, r - 1);

        curRes[l] = '9';
        curRes[r] = '6';
        findStrobogrammaticFrom(curRes, l + 1, r - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Strobogrammatic().findStrobogrammatic(4));
    }
}
