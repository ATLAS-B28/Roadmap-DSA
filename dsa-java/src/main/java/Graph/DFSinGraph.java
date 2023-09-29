package Graph;
import java.util.*;
class GraphDFS{
    private final Map<Integer,List<Integer>> ADL;
    public GraphDFS(){
        ADL = new HashMap<>();
    }
    public void addEdge(int src,int dest){
        //undirected graph
        ADL.computeIfAbsent(src,k-> new ArrayList<>()).add(dest);
        //directed graph - comment out this
        //but undirected graph is more useful
        ADL.computeIfAbsent(dest,k-> new ArrayList<>()).add(src);
    }
    public void dfs(int start){
        boolean[] visited = new boolean[ADL.size()];
        //dfsRecursive(start,visited);
        dfsIterative(start);
    }
    /*private void dfsRecursive(int current,boolean[] visited){
        visited[current] = true;
        System.out.println(current+" ");
        List<Integer> neighbors = ADL.get(current);
        for(int neighbor : neighbors){
            if(!visited[neighbor]){
                dfsRecursive(neighbor,visited);
            }
        }
    }*/
    private void dfsIterative(int start){
        boolean[] visited = new boolean[ADL.size()];
        Stack<Integer> st = new Stack<>();
        st.push(start);

        while (!st.isEmpty()) {
            int current = st.pop();
            if(!visited[current]){
                visited[current] = true;

                System.out.println(current+" ");
                List<Integer> neighbors = ADL.get(current);

                for(int neighbor : neighbors){
                    if(!visited[neighbor]){
                        st.push(neighbor);
                    }
                }
            }
        }
    }
    public List<Integer> findPath(int startVertex,int target){
        Set<Integer> visited = new HashSet<>();
        Map<Integer,Integer> parentMap = new HashMap<>();
        dfsFind(startVertex,target,visited,parentMap);
        if(!parentMap.containsKey(target)){
            return  Collections.emptyList();
        }
        return buildPath(parentMap,startVertex,target);
    }
    private void dfsFind(int currentVertex,int target,Set<Integer> visited,Map<Integer,Integer> parentMap){
        visited.add(currentVertex);
        if(currentVertex == target){
            return;
        }
        List<Integer> neighbors = ADL.get(currentVertex);
        for(int neighbor : neighbors){
            if(!visited.contains(neighbor)){
                parentMap.put(neighbor,currentVertex);
                dfsFind(neighbor,target,visited,parentMap);
            }
        }
    }
    private List<Integer> buildPath(Map<Integer,Integer> parentMap,int startVertex,int target){
        List<Integer> path = new ArrayList<>();
        int curr = target;
        while(curr != startVertex){
            path.add(0,curr);
            curr = parentMap.get(curr);
        }
        path.add(0,startVertex);
        return path;
    }
}
public class DFSinGraph {
    public static void main(String[] args){
        GraphDFS g = new GraphDFS();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.dfs(0);
    }
}
