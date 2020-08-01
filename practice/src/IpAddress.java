import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpAddress {
    public static void main(String[] args) {
        String ip = "255.255.4.131";
        System.out.println(isValidIp(ip));
        String example = "";
//        System.out.println(getValidIp(example));
    }


    private static boolean isValidIp(String ip) {
        String pattern = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(ip);
        return m.matches();
    }

}
