import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPhoneNumber {
    public static void main(String[] args) {
        String ph = "My number is 585-510-7208";
        System.out.println(getNumber(ph));
    }

    private static boolean getNumber(String ph) {
//        Pattern p = Pattern.compile("^[0-9]*[-0-9]*[-0-9]*$");
//        Matcher m = p.matcher(ph);
//        if(m.matches()){
//            System.out.println(m.group(1));
//        }
//        return true;
        Pattern pattern = Pattern.compile(".*[0-9][-0-9][-0-9].*");
        String mydata = "585-510-7208";

        Matcher matcher = pattern.matcher(mydata);
        if(matcher.matches()) {
            System.out.println(matcher.group());
        }
        return true;
    }
}
