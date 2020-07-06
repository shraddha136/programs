
import java.util.*;

class PrimeFibs {
    public static long[] solution(long n) {
       long[] fibs = getFibs(n);
       long maxFib = fibs[fibs.length-1];
       boolean[] primes = getPrimes(maxFib);
       return getPrimeFibs(primes,fibs,n);
    }

    private static long[] getPrimeFibs(boolean[] primes, long[] fibs, long n) {
        List<Long> list = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(fibs[i] > 1 && !primes[(int) fibs[i]]){
                list.add(fibs[i]);
            }
        }
        int i = 0;
        long[] result = new long[list.size()];
        for(long num:list){
            result[i++] = num;
        }
        return result;
    }

    private static boolean[] getPrimes(long maxFib) {
        boolean[] primes = new boolean[(int) maxFib+1];
        for(int i = 2;i<maxFib+1;i++){
            for(int j = 2;j< maxFib+1;j++){
                if(j*i<primes.length){
                    primes[j*i] = true;
                }
            }
        }
        return primes;
    }

    private static long[] getFibs(long n) {
        long[] fibs = new long[(int)n];
        fibs[0] = 0;
        fibs[1] = 1;
        for(int i = 2;i<n;i++){
            fibs[i] = fibs[i-1]+ fibs[i-2];
        }
        return fibs;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
        System.out.println(Arrays.toString(solution(10)));
        System.out.println(Arrays.toString(solution(7)));
        System.out.println(Arrays.toString(solution(9)));
        System.out.println(Arrays.toString(solution(11)));
    }
}

/// 0 1 2 3 4 5 6
/// 0 1

