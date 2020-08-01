import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

class SummaryRanges {

    class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /** Initialize your data structure here. */
    TreeMap<Integer, Interval> treeMap;

    public SummaryRanges() {
        treeMap = new TreeMap<>();
    }

    public void addNum(int val) {
        if (treeMap.containsKey(val)) {
            return;
        }

        Integer low = treeMap.lowerKey(val);
        Integer high = treeMap.higherKey(val);

        if (low != null && high != null && treeMap.get(low).end + 1 == val && high == val + 1) {
            treeMap.get(low).end = treeMap.get(high).end;
            treeMap.remove(high);
        } else if (low != null && treeMap.get(low).end + 1 >= val) {
            treeMap.get(low).end = Math.max(treeMap.get(low).end, val);
        } else if (high != null && val + 1 == high) {
            treeMap.put(val, new Interval(val, treeMap.get(high).end));
            treeMap.remove(high);
        } else {
            treeMap.put(val, new Interval(val, val));
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[treeMap.size()][2];
        int i = 0;
        for (Interval a : treeMap.values()) {
            res[i][0] = a.start;
            res[i++][1] = a.end;
        }
        return res;
    }

    public static void main(String[] args) {
        SummaryRanges sm = new SummaryRanges();
        sm.addNum(1);
        sm.addNum(3);
        sm.addNum(7);
        sm.addNum(2);
        sm.addNum(6);
        System.out.println(Arrays.deepToString(sm.getIntervals()));
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */