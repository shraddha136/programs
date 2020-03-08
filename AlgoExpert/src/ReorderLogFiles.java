import java.util.*;

public class ReorderLogFiles {
    public static String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<String>();
        List<String> digiLogs = new ArrayList<String>();
        String[] result = new String[logs.length];

        for(String log:logs){
            String[] singleLog = log.split(" ");
            if(Character.isDigit(singleLog[1].charAt(0))){
                digiLogs.add(log);
            }else{
                letterLogs.add(log);
            }
        }
        letterLogs.sort((s1, s2) -> {
            String[] o1 = s1.split(" ");
            String[] o2 = s2.split(" ");
            int l1 = o1.length;
            int l2 = o2.length;
            for (int i = 1; i < Math.min(l1, l2); i++) {
                if (!o1[i].equals(o2[i]))
                    return o1[i].compareTo(o2[i]);
            }
            return 0;
        });

        int k = 0;
        for(String log:letterLogs)
            result[k++] = log;
        for(String log:digiLogs)
            result[k++] = log;
        return result;
    }

//    private static List<String> sortLetterLogs(List<String> letterLogs) {
//        HashMap<String,String> map = new HashMap<>();
//        List<String> list;
//        List<String> sorted = new ArrayList<>();
//        for(String log:letterLogs){
//            String rest = log.substring(log.indexOf(" "));
//            map.put(rest,log);
//            sorted.add(rest);
//        }
//        letterLogs = new ArrayList<>();
//        Collections.sort(sorted,(s1,s2)->{
//
//        });
//        for(String log:sorted){
//            letterLogs.add(map.get(log));
//        }
//        return letterLogs;
//    }

    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println(Arrays.toString(reorderLogFiles(logs)));
    }
}
