import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Critical {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    int[] discovery;
    int[] low;
    int[] parent;
    boolean[] visited;
    List<List<Integer>> graph;
    int id = 0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        visited = new boolean[n];
        discovery = new int[n];
        parent = new int[n];
        low = new int[n];
        graph = buildGraph(connections, n);
        dfs(0);
        return result;
    }

    private void dfs(int current) {
        if(!visited[current]){
            ++id;
            low[current] = id;
            discovery[current] = id;
            visited[current] = true;
        }
        for(int child: graph.get(current)){
            if(!visited[child]){
                parent[child] = current;
                dfs(child);
                if(low[child]<low[current]){
                    low[current] = low[child];
                }
                if(discovery[current]<low[child]){
                    List<Integer> list = new ArrayList<>();
                    list.add(current);
                    list.add(child);
                    result.add(list);
                }
            }else if(child != parent[current]){
                if(low[current]>discovery[child]){
                    low[current] = discovery[child];
                }
            }

        }
    }

    private List<List<Integer>> buildGraph(List<List<Integer>> connections, int n) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> connect : connections) {
            int x = connect.get(0);
            int y = connect.get(1);
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        return graph;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(0);
        a.add(1);
        List<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);
        List<Integer> c = new ArrayList<>();
        c.add(2);
        c.add(0);
        List<Integer> d = new ArrayList<>();
        d.add(1);
        d.add(3);
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(a);
        connections.add(b);
        connections.add(c);
        connections.add(d);
        System.out.println(new Critical().criticalConnections(4,connections));
    }
}
