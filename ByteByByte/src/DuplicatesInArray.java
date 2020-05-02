import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesInArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {1, 2, 2};
        int[] c = {3, 3, 3};
        int[] d = {2, 1, 2, 1};
        System.out.println(new DuplicatesInArray().duplicates(a));
        System.out.println(new DuplicatesInArray().duplicates(b));
        System.out.println(new DuplicatesInArray().duplicates(c));
        System.out.println(new DuplicatesInArray().duplicates(d));
    }

    private List<Integer> duplicates(int[] a) {
        Set<Integer> set = new HashSet<>();
//        for(int i = 0;i<a.length;i++){
//            for(int j = i+1;j<a.length;j++){
//                if(a[i]==a[j])
//                    set.add(a[i]);
//            }
//        }
        Set<Integer> list = new HashSet<>();
//            for (int value : a) {
//            if (set.contains(value))
//                list.add(value);
//            set.add(value);

        int i = 0;
        while (i < a.length) {
            while (a[i] != a[a[i] - 1]) {
                int temp = a[a[i] - 1];
                a[a[i] - 1] = a[i];
                a[i] = temp;
            }
            i++;
        }
        for (int ii = 0; ii < a.length; ii++)
            if (a[ii] != ii+1)
                list.add(a[ii]);
        return new ArrayList<>(list);
    }
}
