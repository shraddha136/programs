// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.*;
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class PrisonCells
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<Integer> cellCompete(int[] states, int days) {
        // WRITE YOUR CODE HERE
        if(states==null || states.length==0 || days<=0) return convertToList(states);
        boolean hasCycle = false;
        int cycle = 0;
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<days;i++){
            int[] next = changeState(states);
            String key = Arrays.toString(next);
            if(!set.contains(key)){ //store cell state
                set.add(key);
                cycle++;
            }
            else{ //hit a cycle
                hasCycle = true;
                break;
            }
            states = next;
        }
        if(hasCycle){
            days%=cycle;
            for(int i=0;i<days;i++){
                states = changeState(states);
            }
        }
        return convertToList(states);
    }

    private int[] changeState(int[] oldState) {
        int[] tmp = new int[oldState.length];
        for(int i=1;i<oldState.length-1;i++){
            tmp[i]=oldState[i-1]==oldState[i+1]?0:1;
        }
        return tmp;
    }

    private List<Integer> convertToList(int[] states){
        List<Integer> result = new ArrayList<>();
        for(int s: states){
            result.add(s);
        }
        return result;
    }
    // METHOD SIGNATURE ENDS
    public static void main(String[] args) {
        int[] a= {1,1,1,0,1,1,1,1};
        System.out.println(new PrisonCells().cellCompete(a,3));
    }
}