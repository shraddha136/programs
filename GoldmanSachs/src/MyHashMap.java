//import java.util.List;
//
//class MyHashMap {
//
//    /** Initialize your data structure here. */
//    Integer[List<int[]>] mapArray;
//    public MyHashMap() {
//        mapArray = new Integer[773];
////    }
//
//    /** value will always be non-negative. */
//    public void put(int key, int value) {
//        int index = key % 773;
//        if(mapArray[index]==null){
//            mapArray[index] = new ArrayList<>();
//        }
//        mapArray[index].add(new int[]{key,value});
//    }
//
//    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
//    public int get(int key) {
//        int index = key % 773;
//
//        List<int[]> values = mapArray[index];
//        ListIterator<int[]> it = values.listIterator();
//        while(it.hasNext()){
//            int[] curVal = it.next();
//            if(curVal[0]==key){
//                return curVal[1];
//            }
//        }
//        return -1;
//    }
//
//    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
//    public void remove(int key) {
//        int index = key % 773;
//        List<int[]> values = mapArray[index];
//        ListIterator<int[]> it = values.listIterator();
//        int[] reqd;
//        while(it.hasNext()){
//            int[] curVal = it.next();
//            if(curVal[0]==key){
//                reqd = curVal;
//                break;
//            }
//        }
//        values.remove(reqd);
//    }
//}
//
///**
// * Your MyHashMap object will be instantiated and called as such:
// * MyHashMap obj = new MyHashMap();
// * obj.put(key,value);
// * int param_2 = obj.get(key);
// * obj.remove(key);
// */