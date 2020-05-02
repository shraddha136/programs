import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReorderDataLogFiles {
    public String[] reorderLogFiles(String[] logs) {
//        Arrays.sort(logs, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                String[] one = o1.split(" ", 2);
//                String[] two = o2.split(" ", 2);
//                boolean oDigit = Character.isDigit(one[1].charAt(0));
//                boolean tDigit = Character.isDigit(two[1].charAt(0));
//
//                if (!oDigit && !tDigit) {//both letter logs
//                    int comp = one[1].compareTo(two[1]);
//                    if (comp == 0)
//                        return one[0].compareTo(two[0]);
//                    return comp;
//                } else if (!oDigit && !tDigit) {
//                    return 0;
//                } else if (oDigit && !tDigit) {
//                    return 1;
//                } else
//                    return -1;
//            }
//        });
//        return logs;

        Arrays.sort(logs, new Comparator<String>() {
            @Override
            public int compare(String log1, String log2) {


                String[] singleLog1 = log1.split(" ", 2);
                String[] singleLog2 = log2.split(" ", 2);
                boolean digit1 = Character.isDigit(singleLog1[1].charAt(0));
                boolean digit2 = Character.isDigit(singleLog2[1].charAt(0));
                if (!digit1 && !digit2) {
                    String a1 = singleLog1[1];
                    String a2 = singleLog2[1];
                    int comp = a1.compareTo(a2);
                    if (comp == 0)
                        return singleLog1[0].compareTo(singleLog2[0]);
                    return comp;
                }
                 else if (digit1 && !digit2)
                    return 1;
                else if (digit1 && digit2)
                    return 0;
                else
                    return -1;
            }
        });
        return logs;
    }

    public static void main(String[] args) {
        String[] logs = {"ond 5092781 316 6704", "8qt 089 1 505824730", "ty szwmdr fqf nlums", "06hy thfo ofhdibrnc", "f 341750204886995331", "rab lxyhr xhlpkk t q", "54a 4 240 48299311 0", "nqp2o jrlokgypqh op", "jxc lafwu p ctjjj vv", "6c 944639313298 221", "hd6 dhdhajyqylb m c", "qp 5014057259194839", "3ljd2 cbvoeej da lro", "6lxa l xrvmcmsfdzlq", "zotrq 19964 46917945", "7m cecsiar vxp yksaq", "uktnk mgaa hbvc vt t", "p3 lseldodyxhiazo z", "xp sgiea f r mhnsqeu", "syufn 7 54169586 8 9"};
//        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println(Arrays.toString(new ReorderDataLogFiles().reorderLogFiles(logs)));
    }
}
