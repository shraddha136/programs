import java.util.PriorityQueue;

public class MinDeletionsUniqueCount {
    public static int minDeletetions(String word){
        if(word == null || word.length()==0){
            return 0;
        }
        int[] charCount = new int[26];
        for(char c:word.toCharArray()){
            charCount[c-'a']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        for(int c:charCount){
            if(c > 0){
                pq.offer(c);
            }
        }
        int deletions = 0;
        while(!pq.isEmpty()){
            int max = pq.poll();
            if(pq.isEmpty()){
                return deletions;
            }
            if(max == pq.peek()){
                if(max > 1){
                    pq.offer(max-1);
                }
                deletions++;
            }
        }
        return deletions;
    }

    public static void main(String[] args) {
        System.out.println(minDeletetions("eeeeffff"));
        System.out.println(minDeletetions("eeeeffffaaaa"));
        System.out.println(minDeletetions("aabbffddeaee"));
        System.out.println(minDeletetions("llll"));
        System.out.println(minDeletetions("example"));
    }
}
