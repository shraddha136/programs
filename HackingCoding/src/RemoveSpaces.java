public class RemoveSpaces {
    static void removeWhiteSpaces(char[] s) {
        //TODO: Write - Your - Code

        int nonSpace = 0;
        int space = 0;
        while (nonSpace < s.length) {
            if (s[nonSpace] == ' ') {
                nonSpace++;
            }
            swap(space, nonSpace,s);
            space++;
            nonSpace++;
        }
    }

    private static void swap(int space, int nonSpace, char[] s) {
        char c = s[space];
        s[space] = s[nonSpace];
        s[nonSpace] = c;
    }

    public static void main(String[] args) {
        char[] s = getArray("All greek to me");
        System.out.print("Before: ");
        print(s);
        removeWhiteSpaces(s);
        System.out.print("After: ");
        print(s);
    }

    static char[] getArray(String t) {
        char[] s = new char[t.length()];
        int i = 0;
        for (; i < t.length(); ++i) {
            s[i] = t.charAt(i);
        }
        return s;
    }

    static void print(char[] s) {
        int i = 0;
        while (i < s.length && s[i] != '\0') {
            System.out.print(s[i]);
            ++i;
        }
        System.out.println();
    }
}
