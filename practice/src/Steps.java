

class Steps {
    public static long solution(long n) {
        // Type your solution here
        if(n <= 1){
            return 1;
        }
        if(n <= 2){
            return 2;
        }
        if(n == 3){
            return 4;
        }
        long[] steps = new long[(int)n+1];
        steps[0] = 1;
        steps[1] = 1;
        steps[2] = 2;
        steps[3] = 4;
        for(int index = 4;index<=n;index++){
            steps[index] = steps[index-1]+steps[index-2]+steps[index-3];
        }
        return steps[(int) n];
    }
}

