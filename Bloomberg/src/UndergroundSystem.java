//
//import org.apache.commons.lang3.tuple.Pair;
//
//import java.util.HashMap;
//import java.util.Map;
//
//class UndergroundSystem {
//    //undergroundSystem.checkIn(27, "Leyton", 10);
//    //undergroundSystem.checkOut(45, "Waterloo", 15);
//
//    Map<Integer, Pair<String,Integer>> checkIn;
//    Map<String,Pair<Integer,Integer>> checkOut;
//    public UndergroundSystem() {
//        checkIn = new HashMap<>();
//        checkOut = new HashMap<>();
//    }
//
//    public void checkIn(int id, String stationName, int t) {
//        checkIn.put(id,new Pair<String,Integer>(stationName,t));
//    }
//
//    public void checkOut(int id, String stationName, int t) {
//        String checkInStation = checkIn.get(id).getKey();
//        String stationPair = checkInStation+"_"+stationName;
//        int timeDiff = t-checkIn.get(id).getValue();
//        Pair<Integer,Integer> existingPair = checkOut.get(stationPair);
//        if(existingPair == null){
//            existingPair = new Pair<Integer,Integer>(timeDiff,1);
//        }else{
//            int count = existingPair.getValue()+1;
//            existingPair = new Pair<Integer, Integer>(timeDiff,count);
//        }
//        checkOut.put(stationPair,existingPair);
//    }
//
//    public double getAverageTime(String startStation, String endStation) {
//        Pair<Integer,Integer> stationTimePair = checkOut.get(startStation+"_"+endStation);
//        return (double)(stationTimePair.getKey()/stationTimePair.getValue());
//    }
//}
//
///**
// * Your UndergroundSystem object will be instantiated and called as such:
// * UndergroundSystem obj = new UndergroundSystem();
// * obj.checkIn(id,stationName,t);
// * obj.checkOut(id,stationName,t);
// * double param_3 = obj.getAverageTime(startStation,endStation);
// */