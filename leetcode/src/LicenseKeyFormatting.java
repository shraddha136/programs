public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        if (S == null || S.length() == 0)
            return "";

        int j = 0;
        StringBuilder sb = new StringBuilder();
        int i = S.length() - 1;
        while (i >= 0) {
            if (S.charAt(i) == '-') {
                i--;
                continue;
            }
            if (j == K) {
                sb.insert(0, '-');
                j = 0;
            }
            sb.insert(0, Character.toUpperCase(S.charAt(i)));
            j++;

            i--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LicenseKeyFormatting().licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(new LicenseKeyFormatting().licenseKeyFormatting("2-5g-3-J", 2));
    }
}
