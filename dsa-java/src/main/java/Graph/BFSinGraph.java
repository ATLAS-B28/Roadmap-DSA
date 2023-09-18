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
        System.out.println("BFS Traversal:");
        g.BFS(startVertex);
    }
}
