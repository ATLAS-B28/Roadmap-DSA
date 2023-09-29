package Graph;
import java.util.*;
public class BFSinGraph {
    private final Map<Integer,List<Integer>> ADL;
    public BFSinGraph(){
        ADL = new HashMap<>();
    }
    public void addEdge(int src,int dest){
        ADL.putIfAbsent(src,new LinkedList<>());
        ADL.putIfAbsent(dest,new LinkedList<>());
        ADL.get(src).add(dest);
        ADL.get(dest).add(src);
    }
    public void BFS(int start){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);
        while(!queue.isEmpty()){
            int current = queue.poll();
            System.out.println(current+" ");
            List<Integer> neighbors = ADL.get(current);
            for(int neighbor : neighbors){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }
    public List<Integer> findPath(int startVertex,int target){
        Set<Integer> visited = new HashSet<>();
        Map<Integer,Integer> parentMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(startVertex);
        queue.add(startVertex);
        while(!queue.isEmpty()){
            int curr = queue.poll();
            if(curr == target){
                return buildPath(parentMap,startVertex,target);
            }
            List<Integer> neighbors = ADL.get(curr);
            for(int neighbor : neighbors){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.add(neighbor);
                    parentMap.put(neighbor,curr);
                }
            }
        }
        return Collections.emptyList();
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
    public static void main(String[] args){
        BFSinGraph g = new BFSinGraph();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);

        int startVertex = 2;
        int target = 4;
        System.out.println("BFS Traversal:");
        g.BFS(startVertex);
        System.out.println("Path:");
        List<Integer> path = g.findPath(startVertex,target);
        if(path.isEmpty()){
            System.out.println("No path found");
        }else {
            System.out.println(path);
        }
    }
}
