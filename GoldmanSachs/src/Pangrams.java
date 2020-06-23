import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Pangrams {


    // Complete the pangrams function below.
    static String pangrams(String s) {
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            if(Character.isAlphabetic(c)){
                charCount[Character.toLowerCase(c) - 'a']++;
            }
        }
        int maxCount = 0;
        for (int i = 0; i < 26; i++) {
            if (charCount[i] < 1 || (charCount[i] > 0 && charCount[i] != maxCount)) {
                return "not pangram";
            }
            maxCount = Math.max(maxCount, charCount[i]);
        }
        return "pangram";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//        String s = scanner.nextLine();
        String s = "We promptly judged antique ivory buckles for the next prize";
        String result = pangrams(s);
//
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}


