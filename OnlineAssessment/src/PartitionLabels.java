import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] idx = new int[26];
        for(int i = 0;i<S.length();i++){
            idx[S.charAt(i)-'a'] = i;
        }

        int last = 0;
        int first = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<S.length();i++){
            last = Math.max(last,idx[S.charAt(i)-'a']);
            if(last == i) {
                list.add(last - first + 1);
                first = last + 1;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
    }
}
