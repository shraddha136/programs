public class LongestSS3 {
    //Given a string s containing only a and b, find longest substring of s such that
    // s does not contain more than two contiguous occurrences of a and b.

    public static void main(String[] args) {
        System.out.println(getLongest("aabbaaaaabb"));
        System.out.println(getLongest("aabbaabbaabbaa"));
        System.out.println(getLongest("abbaabbaaabbaaa"));
    }

    private static String getLongest(String s) {
        //check empty or null
        if(s == null || s.length() == 0){
            return "";
        }
        // 2 pointer i and j
        int i = 0, j = 0;
        // curr char and its count
        char current = s.charAt(j++);
        int count = 1;
        //keep incr j till count < 3
        String max = "";
        while(j < s.length()){
            while(j < s.length() && current == s.charAt(j) && count < 3){
                j++;
                count++;
            }
            if(j == s.length()){
                break;
            }
            // if char changes reset count and char
            if(count < 3){
                count = 0;
                current = s.charAt(j);
            }else{
                // if count = 3, take substring as max and set i = j + 1 and reset count
                max = s.substring(i,j-1);
                i = j ;
                count = 0;
            }
        }

        return max.length()==0?s:max;

    }
}
