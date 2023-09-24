package Graph;
import java.util.*;
class PrimAlgo{
    private final int V;
    private final List<List<Edge>> graph;
    private static class Edge{
        int dest,w;
        public Edge(int dest,int w){
            this.dest = dest;
            this.w = w;
        }
    }
    PrimAlgo(int V){
        this.V = V;
        graph = new ArrayList<>(V);
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }
    }
    void addEdge(int src,int dest,int w){
        graph.get(src).add(new Edge(dest,w));
        graph.get(dest).add(new Edge(src,w));
    }
    void primMST(){
        PriorityQueue<Edge> pq = new PriorityQueue<>(
                                      Comparator.comparingInt(a -> a.w
                                     ));
        boolean[] visited = new boolean[V];//tracks vertices in MST
        int[] parent = new int[V];//tracks parent of each vertex in MST
        int[] key = new int[V];//tracks key of each vertex in MST
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        int startVertex = 0;
        key[startVertex] = 0;
        pq.offer(new Edge(startVertex,0));
        while(!pq.isEmpty()){
           Edge current = pq.poll();
           int currentVertex = current.dest;
            visited[currentVertex] = true;
            for(Edge neighbor : graph.get(currentVertex)){
                int neighborVertex = neighbor.dest;
                int neighborWeight = neighbor.w;
                if(!visited[neighborVertex] && neighborWeight < key[neighborVertex]){
                    key[neighborVertex] = neighborWeight;
                    parent[neighborVertex] = currentVertex;
                    pq.offer(new Edge(neighborVertex,neighborWeight));
                }
            }
        }
        System.out.println("MST is: ");
        for(int i = 1; i < V; i++){
            System.out.println(parent[i]+"--"+i+" : "+key[i]);
        }
    }
}
public class Prim {
    public static void main(String[] args) {
        int V = 4;
        PrimAlgo prim = new PrimAlgo(V);
        prim.addEdge(0, 1, 10);
        prim.addEdge(0, 2, 6);
        prim.addEdge(0, 3, 5);
        prim.addEdge(1, 3, 15);
        prim.addEdge(2, 3, 4);
        prim.primMST();
    }
}
