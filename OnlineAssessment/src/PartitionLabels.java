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


    public List<String> getParts(String S){
        List<String> result = new ArrayList<>();
        int[] idx = new int[26];
        for(int i = 0;i<S.length();i++){
            idx[S.charAt(i)-'a'] = i;
        }

        int last = 0;
        int first = 0;
        for(int i = 0;i<S.length();i++){
            last = Math.max(last,idx[S.charAt(i)-'a']);
            if(last == i) {
                result.add(S.substring(first,last+1));
                first = last + 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(new PartitionLabels().getParts("ababcbacadefegdehijhklij"));
        System.out.println(new PartitionLabels().partitionLabels("bbeadcxede"));
        System.out.println(new PartitionLabels().getParts("bbeadcxede"));
        System.out.println(new PartitionLabels().partitionLabels("baddacx"));
        System.out.println(new PartitionLabels().getParts("baddacx"));
    }
}
