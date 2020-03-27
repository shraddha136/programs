import java.util.Arrays;

class AlienDictionary {
    int n = 26;//letters

    public String alienOrder(String[] words) {
        StringBuilder sb = new StringBuilder();
        //adjacency matrix
        boolean[][] adj = new boolean[n][n];
        //visited array
        int[] visited = new int[n];

        //build graph
        buildGraph(words, adj, visited);

        //perform dfs on adjacency matrix

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0)
                if (!dfs(adj, visited, i, sb))
                    return "";
        }

        return sb.reverse().toString();
    }

    private boolean dfs(boolean[][] adj, int[] visited, int i, StringBuilder sb) {
        visited[i] = 1; //visiting
        for (int j = 0; j < n; j++) {
            if (adj[i][j]) { //edge exists
                if (visited[j] == 1)//already visited
                    return false;//cycle
                if (visited[j] == 0) {
                    if (!dfs(adj, visited, j, sb))
                        return false;
                }
            }
        }
        visited[i] = 2; //visited
        sb.append((char) (i + 'a'));
        return true;
    }


    private void buildGraph(String[] words, boolean[][] adj, int[] visited) {
        Arrays.fill(visited, -1); //does not exist
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (char c : word.toCharArray())
                visited[c - 'a'] = 0; // exists
            if (i > 0) {
                String w1 = words[i - 1];
                String w2 = words[i];
                if (!w1.equals(w2) && w1.startsWith(w2))
                    Arrays.fill(visited, 2);
                int len = Math.min(w1.length(), w2.length());
                for (int j = 0; j < len; j++) {
                    char c1 = w1.charAt(j);
                    char c2 = w2.charAt(j);
                    if (c1 != c2) {
                        adj[c1 - 'a'][c2 - 'a'] = true;
                        break;
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        String[] words = {"abc","ab"};
//        String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
        System.out.println(new AlienDictionary().alienOrder(words));
    }
}
