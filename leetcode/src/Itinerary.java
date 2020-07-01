import java.util.*;

class Itinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> (a.compareTo(b)));
            if (!map.containsKey(ticket.get(0))) {

            } else {
                pq = map.get(ticket.get(0));

            }
            pq.offer(ticket.get(1));
            map.put(ticket.get(0), pq);
        }
        visit("JFK");
        return result;
    }

    List<String> result = new ArrayList<>();
    Map<String, PriorityQueue<String>> map = new HashMap<>();

    private void visit(String airport) {
        if (airport != null) {
            result.add(airport);
        }
        while (map.containsKey(airport) && map.get(airport).size() > 0) {
            visit(map.get(airport).poll());
        }
    }

    public static void main(String[] args) {
        List<String> a = Arrays.asList("MUC", "LHR");
        List<String> b = Arrays.asList("JFK", "MUC");
        List<String> c = Arrays.asList("SFO", "SJC");
        List<String> d = Arrays.asList("LHR", "SFO");
        List<List<String>> x = new ArrayList<>();
        x.add(a);
        x.add(b);
        x.add(c);
        x.add(d);
        System.out.println(new Itinerary().findItinerary(x));
    }
}