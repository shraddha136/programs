import java.util.*;

class Interveaving {

        public static boolean interweavingStrings(String one, String two, String three) {
            // Write your code here.
            if(three.length() != (one.length()+two.length()))
                return false;
            return areWoven(0,0,one,two,three);
        }

        private static boolean areWoven(int i, int j, String one, String two, String three){
            int k = i + j;
            if(k >= three.length())
                return true;
            if(i < one.length() && one.charAt(i)==three.charAt(k)){
                return areWoven(i+1,j,one,two,three);
            }else if(j < two.length() && two.charAt(j)==three.charAt(k)){
                return areWoven(i,j+1,one,two,three);
            }else
                return false;
        }


    public static void main(String[] args) {
        System.out.println(interweavingStrings("algoexpert","your-dream-job","your-algodream-expertjob"));
    }
}
