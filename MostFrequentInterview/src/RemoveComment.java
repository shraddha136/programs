import java.util.*;

public class RemoveComment {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        boolean openComment = false;
        for (String line : source) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (openComment && !line.contains("*/")) {

                continue;
            }
            if (openComment && line.contains("*/")) {
                openComment = false;
                i = line.indexOf("*/") + 2;
            }
            for (; i < line.length(); i++) {

                char c = line.charAt(i);
                if (c == '*' && line.charAt(i + 1) == '/') {
                    openComment = false;
                }
                if (openComment) {
                    continue;
                }
                if (c == '/' && line.charAt(i + 1) == '/') {
                    if (sb.toString().trim().length() > 0) {
                        result.add(sb.toString().trim());
                    }
                    break;
                }
                if (c == '/' && line.charAt(i + 1) == '*') {
                    openComment = true;
                    if (!line.contains("*/")) {
                        if (sb.toString().trim().length() > 0) {
                            result.add(sb.toString().trim());
                        }
                        break;
                    } else {
                        i = line.indexOf("*/") + 2;
                        openComment = false;
                    }
                } else {
                    sb.append(c);
                }

            }
            if (sb.toString().trim().length() > 0) {
                result.add(sb.toString().trim());
            }

        }
        return result;
    }

    public static void main(String[] args) {
        String[] s = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
        System.out.println(new RemoveComment().removeComments(s));
        s = new String[]{"a/*comment", "line", "more_comment*/b"};
        System.out.println(new RemoveComment().removeComments(s));
    }
}
