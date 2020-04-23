public class ValidParenthesis {
    public boolean checkValidString(String s) {
        char open = '(';
        char close = ')';
        char star = '*';
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            char atI = s.charAt(i);
            char atJ = s.charAt(j);
            if (atI == atJ && atI == star) {
                i++;
                j--;
            }
            else if (atI == open && atJ == close || atI == star && atJ == close || atI == open && atJ == star) {
                i++;
                j--;
            } else
                return false;

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidParenthesis().checkValidString("()"));
        System.out.println(new ValidParenthesis().checkValidString("(*)"));
        System.out.println(new ValidParenthesis().checkValidString("((((*))"));
    }
}
