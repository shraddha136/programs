public class StringCompression {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        if(chars == null || chars.length == 0)
            return sb.toString().length();
        if(chars.length ==1)
            return 1;
        int count = 0;
        for(int i = 0;i<chars.length-1;i++){
            if(chars[i]!=chars[i+1]){
                sb.append(chars[i]);
                count++;
                if(count != 1)
                    sb.append( count);
                count = 0;
            }else
                count++;
        }
        if(chars[chars.length-1]==chars[chars.length-2]){
            sb.append(chars[chars.length-1]);
            count++;
            sb.append(count);
        }else{
            sb.append(chars[chars.length-1]);
            sb.append('1');
        }
        return sb.toString().length();
    }

    public static void main(String[] args) {
        System.out.println(new StringCompression().compress(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(new StringCompression().compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
        System.out.println(new StringCompression().compress(new char[]{'a'}));
    }
}
