import java.util.HashSet;
import java.util.Set;

public class UniqueEmails {
    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0)
            return 0;
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            set.add(processEmail(email));
        }
        return set.size();
    }

    private String processEmail(String email) {
        String[] parts = email.split("@");
        StringBuilder sb = new StringBuilder();
        if (parts[0].contains("+")) {
            int idxPlus = parts[0].indexOf("+");
            parts[0] = parts[0].substring(0, idxPlus);
        }
        if (parts[0].contains("."))
            parts[0] = parts[0].replaceAll("\\.", "");
        return parts[0] + "@" + parts[1];
    }

    public static void main(String[] args) {
        System.out.println(new UniqueEmails().numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
    }
}
