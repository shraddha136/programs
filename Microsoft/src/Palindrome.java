public class Palindrome {

    public boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            char s = Character.toLowerCase(str.charAt(start));
            char e = Character.toLowerCase(str.charAt(end));
            if (!Character.isLetterOrDigit(s)) {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(e)) {
                end--;
                continue;
            }
            if (Character.isLetterOrDigit(s) != Character.isLetterOrDigit(e)) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Palindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
