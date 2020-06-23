

class Brackers {
    public static String solution(String angles) {
        // Type your solution here
        StringBuilder sb = new StringBuilder(angles);
        int index = 0;
        int open = 0;
        int close = 0;
        while(index < angles.length()){
            char c = angles.charAt(index);
            if(c == '<'){
                open++;
            }
            if(c == '>'){
                close++;
            }
            if(close>open){
                sb.insert(index,'<');
                close--;
            }

        }
        while(open>close){
            sb.insert(index++,'>');
            close++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("><"));
    }
}

