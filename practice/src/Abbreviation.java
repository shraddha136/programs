import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Abbreviation {

//daBcd
//ABC

    /***
     AbcDE    E F
     AFDE
     **/
    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
        if (a == null && b == null || a.length() == 0 && b.length() == 0) {
            return "YES";
        }
        if (a.length() > 0 && b == null || a.length() > 0 && b.length() == 0) {
            return "YES";
        }
        if (canConvert(a, b, 0, 0)) {
            return "YES";
        }
        return "NO";
    }

    private static boolean canConvert(String a, String b, int index1, int index2) {
        if (index1 == a.length() && index2 < b.length()) {
            return false;
        }
        if (index2 == b.length()) {
            return onlyLowerCase(a,index1);
        }
        if (a.charAt(index1) == b.charAt(index2) || Character.toUpperCase(a.charAt(index1)) == b.charAt(index2)) {
            return canConvert(a, b, index1 + 1, index2 + 1);
        } else {
            return canConvert(a, b, index1 + 1, index2);
        }
    }

    private static boolean onlyLowerCase(String a, int index1) {
        for(int i = index1;i<a.length();i++){
            if(Character.isUpperCase(a.charAt(index1))){
                return false;
            }
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int q = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int qItr = 0; qItr < q; qItr++) {
        String a = "beFgH";

        String b = "EFG";

        String result = abbreviation(a, b);
        System.out.println(result);
//
//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
    }
//
//        bufferedWriter.close();
//
//        scanner.close();
}

