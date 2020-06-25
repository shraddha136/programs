import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AllPathNew {
    //Find all possible routes between two airports in a country, irrespective of hops.
//Given the following flight routes, print all possible routes between the airports C and D

//A <----> B
//A <----> C
//A <----> D
//B <----> C
//B <----> D

//Example: C,A,D is one possible valid route

// Map <Airport,List<Airports>>
// <A,<B,c,d>
// <b, <a,c,d>
// <c, a,b>
// <d, <a,b>
//<c> - currpath

// dfs : if(node == dest) -> result.currpath
//vis
// for( currNode : map.get(node)){
    //
    // curr.add(currNode)
    // dfs(currnode,curr,res)
    // curr.remove(curr.size-1)

//}


    public List<List<Character>> allPaths(Map<Character, List<Character>> airportMap, char start, char end) {
        List<List<Character>> result = new ArrayList<>();
        if (airportMap == null || airportMap.size() == 0) {
            return result;
        }
        List<Character> currPath = new ArrayList<>();
        Set<Character> visited = new HashSet<>();
        currPath.add(start);

        getAllPath(start, end, currPath, result, visited, airportMap);
        return result;
    }

    private void getAllPath(char start, char end, List<Character> currPath, List<List<Character>> result, Set<Character> visited, Map<Character, List<Character>> airportMap) {
        if (start == end) {
            System.out.println("at end:" + end);
            result.add(new ArrayList<>(currPath));
        }
        // System.out.println(start);
        visited.add(start);
        for (char neigbbor : airportMap.get(start)) {
            if (!visited.contains(neigbbor)) {
                System.out.println(neigbbor);
                currPath.add(neigbbor);
                getAllPath(neigbbor, end, currPath, result, visited, airportMap);
                visited.remove(neigbbor);
                currPath.remove(currPath.size() - 1);
            }
        }
    }

    /**
     * CP - C,B,D
     V - C,B,D
     result CBD,cabd
     */

    public static void main(String[] args) {
        Map<Character, List<Character>> airportMap = new HashMap<>();
        List<Character> pathA = new ArrayList<>();
        pathA.add('B');
        pathA.add('C');
        pathA.add('D');
        airportMap.put('A', pathA);
        List<Character> pathB = new ArrayList<>();
        pathB.add('C');
        pathB.add('D');
        airportMap.put('B', pathB);
        List<Character> pathC = new ArrayList<>();
        pathC.add('B');
        pathC.add('A');
        airportMap.put('C', pathC);
        List<Character> pathD = new ArrayList<>();
        pathD.add('B');
        pathD.add('A');
        airportMap.put('D', pathD);
        char start = 'C';
        char end = 'D';
        List<List<Character>> result = new AllPathNew().allPaths(airportMap, start, end);
        for (List<Character> currPath : result) {
            for (char ap : currPath) {
                System.out.print(ap);
            }
            System.out.println();
        }


    }
}


