import java.util.ArrayList;
import java.util.List;

public class DecodeWays {
    public int numDecodings(String s) {
        for (int i = 0; i < s.length(); i++)
            printString(s, i);
        return 0;
    }

    private void printString(String s, int i) {
        if (i == s.length())
            return;
        System.out.println(s.charAt(i));
        System.out.println(s.charAt(i));
        printString(s.substring(i+1), i );
    }

    public static void main(String[] args) {
        new DecodeWays().numDecodings("226");
    }
}
