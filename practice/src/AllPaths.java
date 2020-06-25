import java.util.*;

public class AllPaths {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        if (graph == null || graph.length == 0) {
            return result;
        }
        List<Integer> currPath = new ArrayList<>();
        currPath.add(0);
        getPath(graph,0,currPath,result);
        return result;
    }

    private void getPath(int[][] graph, int node, List<Integer> currPath, List<List<Integer>> result) {
        if(node == graph.length-1){
            result.add(new ArrayList<>(currPath));
            return;
        }

        for(int next: graph[node]){
            currPath.add(next);
            getPath(graph,next,currPath,result);
            currPath.remove(currPath.size()-1);
        }
    }

    public static void main(String[] args) {
        int[][] nodes = {{1,2}, {3}, {3}, {}};
        System.out.println(new AllPaths().allPathsSourceTarget(nodes));
    }
}
