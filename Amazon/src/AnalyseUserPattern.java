import javafx.util.Pair;

import java.util.*;

public class AnalyseUserPattern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair<Integer, String>>> userMap = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            userMap.putIfAbsent(username[i], new ArrayList<Pair<Integer, String>>());
            userMap.get(username[i]).add(new Pair<Integer, String>(timestamp[i], website[i]));
        }
        String res = "";
        int max = 0;
        Map<String, Integer> visitMap = new HashMap<>();
        for (String user : userMap.keySet()) {
            if (userMap.get(user).size() >= 3) {
                List<Pair<Integer, String>> list = userMap.get(user);
                Collections.sort(list, new Comparator<Pair<Integer, String>>() {
                    @Override
                    public int compare(Pair<Integer, String> o1, Pair<Integer, String> o2) {
                        return o1.getKey()-o2.getKey();
                    }
                });
                for (int i = 0; i < list.size(); i++) {
                    for (int j = i + 1; j < list.size(); j++) {
                        for (int k = j + 1; k < list.size(); k++) {
                            String seq = list.get(i).getValue() + "," + list.get(j).getValue() + "," + list.get(k).getValue();
                            visitMap.put(seq, visitMap.getOrDefault(seq, 0) + 1);
                            if (visitMap.get(seq) == max) {
                                res = res.compareTo(seq) < 0 ? res : seq;
                            } else if (visitMap.get(seq) > max) {
                                max = visitMap.get(seq);
                                res = seq;
                            }
                        }
                    }
                }
            }
        }
        return Arrays.asList(res.split(","));
    }

    public static void main(String[] args) {
        String[] username = {"joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary"};
        int[] timestamp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] website = {"home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career"};
        System.out.println(new AnalyseUserPattern().mostVisitedPattern(username, timestamp, website));
    }
}
