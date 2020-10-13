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
        Collections.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.start-o2.start;
            }
        });

        Job job = jobs.get(0);
        int maxLoad = job.cpuLoad;
        for(int i = 1;i<jobs.size();i++){
            if(job.end>jobs.get(i).start){
                maxLoad = Math.max(maxLoad,maxLoad+jobs.get(i).cpuLoad);
            } 
            maxLoad = Math.max(maxLoad,jobs.get(i).cpuLoad);
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
