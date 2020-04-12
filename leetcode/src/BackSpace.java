public class BackSpace {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        while (i >= 0 || j >= 0) {
            int s1 = getSkip(i, S);
            int t1 = getSkip(j, T);
            if (s1 < 0 && t1 < 0)
                return true;
            if (s1 < 0 || t1 < 0)
                return false;
            if (S.charAt(s1) != T.charAt(t1))
                return false;
            i = s1 - 1;
            j = t1 - 1;
        }
        return true;
    }

    private int getSkip(int i, String s) {
        int backspace = 0;
        while (i >= 0) {
            if (s.charAt(i) == '#')
                backspace++;
            else if (backspace > 0)
                backspace--;
            else
                break;
            i--;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new BackSpace().backspaceCompare("xywrrmp", "xywrrmu#p"));
        System.out.println(new BackSpace().backspaceCompare("bbbextm","bbb#extm"));

    }
}
