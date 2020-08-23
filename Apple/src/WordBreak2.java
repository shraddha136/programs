import java.util.*;

public class WordBreak2 {
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
//    }
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.size()==0 && (s==null || s.length()==0)){
            return true;
        }
        Map<String,Boolean> map = new HashMap<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                int idx = q.poll();
                if(idx == s.length()){
                    return true;
                }
                for(int j = idx;j<=s.length();j++){
                    if(map.containsKey(s.substring(idx,j))){
                        continue;
                    }
                    if(wordDict.contains(s.substring(idx,j))){
                        map.put(s.substring(idx,j),true);
                        q.offer(j);
                    }else{
                        map.put(s.substring(idx,j),false);
                    }
                }
            }
        }
        return false;
    }
    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;

    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String[] words = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};

        System.out.println(new WordBreak2().wordBreak(s,Arrays.asList(words)));
    }
}
