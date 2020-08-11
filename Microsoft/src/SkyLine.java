import java.util.*;





//split into start and end and height
//sort by small start
//PQ maxheap on height
//when start add to heap, if max changes add to result;
//when end, remove from heap, if max changes, add to result
public class SkyLine {
    static class myBuild implements Comparable<myBuild>{
        int val;
        boolean start;
        int height;

        @Override
        public int compareTo(myBuild mb) {
            if (this.val != mb.val) {
                return this.val - mb.val;
            } else {
                return (this.start ? -this.height : this.height) - (mb.start ? -mb.height : mb.height);
            }
        }
    }

    public static void main(String[] args) {
        int[][] skyline = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        System.out.println(getSkyline(skyline));
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        myBuild[] each = convert(buildings);
        Arrays.sort(each);
        return processSkyLine(each);
    }

    private static List<List<Integer>> processSkyLine(myBuild[] each) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        maxHeap.offer(0);
        int maxHeight = 0;

        for (myBuild bldg : each) {
            int currMaxHeight = maxHeap.isEmpty() ? 0 : maxHeap.peek();
            if(bldg.start){
                maxHeap.offer(bldg.height);
            }else{
                maxHeap.remove(bldg.height);
            }
            int currMax = maxHeap.isEmpty() ? 0 : maxHeap.peek();
            if(currMax != currMaxHeight){
                result.add(Arrays.asList(bldg.val,currMax));
            }
        }
        return result;
    }

    private static myBuild[] convert(int[][] buildings) {
        myBuild[] building = new myBuild[buildings.length * 2];
        int index = 0;
        for (int[] b : buildings) {
            myBuild mb = new myBuild();
            mb.val = b[0];
            mb.height = b[2];
            mb.start = true;
            building[index++] = mb;
            myBuild mb2 = new myBuild();
            mb2.val = b[1];
            mb2.height = b[2];
            mb2.start = false;
            building[index++] = mb2;
        }
        return building;
    }
}
