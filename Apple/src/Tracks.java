import java.util.*;

public class Tracks {

    Map<String, List<String>> personTracks;

    Tracks() {
        personTracks = new HashMap<>();
    }


    public String bestTracks(String[] trackList){
        personTracks = getTracksByPerson(trackList);
        String bestTracks = getBestTracks(personTracks);
        return bestTracks;
    }

    private String getBestTracks(Map<String, List<String>> personTracks) {
        String bestTracks = "";
        int maxCount = 0;
        Map<String, Integer> trackCount = new HashMap<>();
        for(List<String> tracks: personTracks.values()){
            StringBuilder songList = new StringBuilder();
            for(int i = 0;i<tracks.size()-3;i++){
                songList.append(tracks.get(i)).append(",");
                songList.append(tracks.get(i+1)).append(",");
                songList.append(tracks.get(i+2)).append(",");

            }
            trackCount.put(songList.toString(),trackCount.getOrDefault(songList.toString(),0)+1);
            if(trackCount.get(songList.toString())>maxCount){
                maxCount = trackCount.get(songList.toString());
                bestTracks = songList.toString();
            }
        }
        return bestTracks;
    }

    private Map<String, List<String>> getTracksByPerson(String[] trackList) {
        Map<String, List<String>> personTracks = new HashMap<>();
        for(String track:trackList){
            String[] trackDetails = track.split(",");
            personTracks.putIfAbsent(trackDetails[0],new ArrayList<>());
            personTracks.get(trackDetails[0]).add(trackDetails[1]);
        }
        return personTracks;
    }

    public static void main(String[] args) {
        String[] trackList = {
                "daniel,ShapeOfYou,1519753867",
                "daniel,Perfect,1519753868",
                "martin,ShapeOfYou,1519753869",
                "daniel,Thunder,1519753870",
                "martin,ShapeOfYou,1519753871",
                "martin,Despacito,1519753872",
                "martin,ShapeOfYou,1519753873",
                "martin,Perfect,1519753874",
                "daniel,Despacito,1519753875",
                "martin,Thunder,1519753875"
        };
        System.out.println(new Tracks().bestTracks(trackList));
    }
}
