public class StringShift {
    public String stringShift(String s, int[][] shift) {
        int move = 0;
        for(int[] shft:shift){
            if(shft[0]==0)
                move -= shft[1];
            else
                move += shft[1];
        }

        String result = "";
        if(move > 0) {
            move = move % s.length();
            result = s.substring(s.length() - move) + s.substring(0, s.length() - move);
        }
        else {
            move = -move;
            move = move %s.length();
            result = s.substring(move) + s.substring( 0,move);;
        }
        return result;
    }

    public static void main(String[] args) {
        new StringShift().stringShift("mecsk", new int[][]{{1,-3},{0,5},{0,4},{1,1},{1,5}});
    }
}
