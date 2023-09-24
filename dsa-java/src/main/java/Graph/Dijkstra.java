package Graph;
import java.util.*;
public class Dijkstra {
    private static final int MAX_VALUE = Integer.MAX_VALUE;
    private int findMinDistance(int[] dist, boolean[] sptSet) {
        int minDist = MAX_VALUE;
        int minDistVertex = -1;
        for(int v = 0; v < dist.length;v++){
            if(!sptSet[v] && dist[v] < minDist){
                minDist = dist[v];
                minDistVertex = v;
            }
        }
        return minDistVertex;
    }
    private void printShortestDistance(int src, int[] dist){
        System.out.println("Shortest distances from source vertex");
        for(int v = 0;v < dist.length;v++){
            System.out.println("Vertex "+v+" is at distance "+dist[v]);
        }
    }
    static class Edge{
        int vertex;
        int w;
        public Edge(int vertex,int w){
            this.vertex = vertex;
            this.w = w;
        }
    }
    public void Dijkstra(List<List<Edge>> graph, int src) {
        int numVertices = graph.size();
        int[] dist = new int[numVertices];
        boolean[] visited = new boolean[numVertices];
        Arrays.fill(dist, MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i < numVertices - 1; i++) {
            int minDistVertex = findMinDistance(dist, visited);
            visited[minDistVertex] = true;
            List<Edge> neighbors = graph.get(minDistVertex);
            for (Edge neighbor : neighbors) {
                int vertex = neighbor.vertex;
                int w = neighbor.w;
                if (!visited[vertex] && dist[minDistVertex] != MAX_VALUE) {
                    int newDist = dist[minDistVertex] + w;
                    if (newDist < dist[vertex]) {
                        dist[vertex] = newDist;
                    }
                }
            }
        }
        printShortestDistance(src, dist);
    }
    public static void main(String[] args) {
        int numVertices =9;
        List<List<Edge>> graph = new ArrayList<>(numVertices);
        for(int i = 0; i < numVertices; i++){
            graph.add(new ArrayList<>());
        }
        graph.get(0).add(new Edge(1,4));
        graph.get(0).add(new Edge(7,8));
        graph.get(1).add(new Edge(0, 4));
        graph.get(1).add(new Edge(2, 8));
        graph.get(1).add(new Edge(7, 11));
        graph.get(2).add(new Edge(1, 8));
        graph.get(2).add(new Edge(3, 7));
        graph.get(2).add(new Edge(5, 4));
        graph.get(2).add(new Edge(8, 2));
        graph.get(3).add(new Edge(2, 7));
        graph.get(3).add(new Edge(4, 9));
        graph.get(3).add(new Edge(5, 14));
        graph.get(4).add(new Edge(3, 9));
        graph.get(4).add(new Edge(5, 10));
        graph.get(5).add(new Edge(2, 4));
        graph.get(5).add(new Edge(3, 14));
        graph.get(5).add(new Edge(4, 10));
        graph.get(5).add(new Edge(6, 2));
        graph.get(6).add(new Edge(5, 2));
        graph.get(6).add(new Edge(7, 1));
        graph.get(7).add(new Edge(0, 8));
        graph.get(7).add(new Edge(1, 11));
        graph.get(7).add(new Edge(6, 1));
        graph.get(8).add(new Edge(0, 2));
        graph.get(8).add(new Edge(1, 2));
        graph.get(8).add(new Edge(7, 2));
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.Dijkstra(graph, 0);
    }
}
