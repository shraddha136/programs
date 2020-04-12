import java.util.HashSet;

class RemoveDuplicates {
    static void removeDuplicates(char[] str) {
        //TODO: Write - Your - Code
        HashSet<Character> set = new HashSet<>();
        StringBuilder s = new StringBuilder();
        for (char c : str) {
            if (!set.contains(c)) {
                set.add(c);
                s.append(c);
            }
        }
        str = new char[set.size()];
        str = s.toString().toCharArray();
    }

    public static void main(String[] args) {
        char[] input = getArray("dabbac");
        System.out.print("Before: ");
        System.out.println(input);
        RemoveDuplicates.removeDuplicates(input);
        System.out.print("After: ");
        print(input);
    }

    static char[] getArray(String t) {
        char[] s = new char[t.length() + 1];
        int i = 0;
        for (; i < t.length(); ++i) {
            s[i] = t.charAt(i);
        }

        return s;
    }

    /// Test Program.
    static void print(char[] s) {
        int i = 0;
        while (s[i] != '\0') {
            System.out.print(s[i]);
            ++i;
        }
        System.out.println();
    }
}