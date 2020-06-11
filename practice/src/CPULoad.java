import java.util.*;

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
};

class MaximumCPULoad {

    public static int findMaxCPULoad(List<Job> jobs) {
        // TODO: Write your code here
        Collections.sort(jobs,(a,b)->Integer.compare(a.start,b.start));
        int i = 0;
        int maxLoad = 0;
        while(i<jobs.size()-1){
            Job job1 = jobs.get(i);
            Job job2 = jobs.get(i+1);
            if(job2.start<job1.end){
                maxLoad = Math.max(maxLoad, maxLoad +job1.cpuLoad + job2.cpuLoad);
            }else{
                maxLoad = Math.max(maxLoad,Math.max(job1.cpuLoad,job2.cpuLoad));
            }
            i++;
        }
        return maxLoad;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }
}
