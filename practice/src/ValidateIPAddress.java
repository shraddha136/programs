public class ValidateIPAddress {
    public String validIPAddress(String IP) {
        if (!IP.contains(".") && !IP.contains(":"))
            return "Neither";
        if (IP.contains(".")) {
            if(IP.chars().filter(c->c=='.').count()!=3)
                return "Neither";
            String[] ipArray = IP.split("\\.",-1);

            for (int i = 0; i < ipArray.length; i++) {
                int num = Integer.parseInt(ipArray[i]);
                if (!String.valueOf(num).equals(ipArray[i]) || num > 255 || num < 0)
                    return "Neither";
            }
            return "IPv4";
        } else {
            if(IP.chars().filter(c->c==':').count()!=7)
                return "Neither";

            String hexVal = "0123456789abcdefABCDEF";
            String[] ipArray = IP.split(":",-1);

            for(String s:ipArray){
                if(s.length()>4 || s.length()<1)
                    return "Neither";
                for(char c:s.toCharArray()){
                    if(hexVal.indexOf(c)==-1)
                        return "Neither";
                }
            }
            return "IPv6";
        }
    }

    public static void main(String[] args) {
        System.out.println(new ValidateIPAddress().validIPAddress("172.16.254.1"));
        System.out.println(new ValidateIPAddress().validIPAddress("256.256.256.256"));
        System.out.println(new ValidateIPAddress().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(new ValidateIPAddress().validIPAddress("2001:0db8:85a3::8A2E:0370:7334"));
        System.out.println(new ValidateIPAddress().validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"));
        System.out.println(new ValidateIPAddress().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    }
}
