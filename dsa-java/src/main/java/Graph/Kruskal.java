package Graph;
import java.util.*;
class Edge implements Comparable<Edge>{
    int src,dest,w;
    @Override
    public int compareTo(Edge other) {
        return this.w - other.w;
    }
}
class KruskalAlgo{
    int V;//no.of vertices
    ArrayList<Edge> edges;//list of edges
    KruskalAlgo(int v){
        V = v;
        edges = new ArrayList<>();
    }
    void addEdge(int src,int dest,int w){
        Edge edge = new Edge();
        edge.src = src;
        edge.dest = dest;
        edge.w = w;
        edges.add(edge);
    }
    int find(int[] parent,int i){
        if(parent[i] == i){ //if current element is parent (i th's value == i)
            return i;//i <- current element is parent
        }//if not then di recursive call
        return find(parent,parent[i]);
    }
    void union(int[] parent,int x,int y){
        int xRoot = find(parent,x);
        int yRoot = find(parent,y);
        System.out.println(xRoot + " " + yRoot);
        parent[yRoot] = xRoot;//yRoot's th index value is xRoot value
        System.out.println(parent[yRoot] + " " + xRoot);
    }
    void kruskalMST(){
        ArrayList<Edge> result = new ArrayList<>();
        Collections.sort(edges);
        int[] parent = new int[V];
        for(int i = 0; i < V; i++){
            parent[i] = i;
        }
        int edgeCount = 0;
        int i = 0;
        while(edgeCount < V - 1 && i < edges.size()){
            Edge edge=  edges.get(i);
            int srcRoot = find(parent,edge.src);
            int destRoot = find(parent,edge.dest);
            if(srcRoot != destRoot){
                result.add(edge);
                union(parent,srcRoot,destRoot);
                edgeCount++;
            }
            i++;
        }
        System.out.println("MST is: ");
        for(Edge edges : result){
            System.out.println(edges.src + "--" + edges.dest + " : " + edges.w);
        }
    }
}
public class Kruskal {
    public static void main(String[] args) {
        KruskalAlgo k = new KruskalAlgo(4);
        k.addEdge(0, 1, 10);
        k.addEdge(0, 2, 6);
        k.addEdge(0, 3, 5);
        k.addEdge(1, 3, 15);
        k.addEdge(2, 3, 4);
        k.kruskalMST();
    }
}
