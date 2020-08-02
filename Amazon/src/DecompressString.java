import java.util.ArrayList;
import java.util.List;

public class DecompressString {

    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        s.add("a");
        s.add("b");
        s.add("c");
        s.add("d");
        s.add("0xFF,1,2");
        s.add("x");
        s.add("y");
        s.add("0xFF,3,3");

        System.out.println(decompress(s));
    }

    private static String decompress(List<String> s) {
        StringBuilder sb = new StringBuilder();
        for (String value : s) {
            String[] sArray = value.split(",");
            if (sArray.length > 1) {
                int move = Integer.parseInt(sArray[1]);
                int offset = Integer.parseInt(sArray[2]);
                int pos = sb.length() - offset;
                if (pos < 0) {
                    return "";
                } else {
                    String sub = sb.substring(pos, pos + move);
                    sb.append(sub);
                }
            } else {
                sb.append(value);
            }
        }
        return sb.toString();
    }
}
