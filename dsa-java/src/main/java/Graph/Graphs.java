package Graph;
import java.util.*;
//all graphs
/*public class Graphs {
   private final Map<Integer,List<Integer>> ADL;
   public Graphs(){
       ADL = new HashMap<>();
   }
   public void addEdge(int src,int dest){
       ADL.computeIfAbsent(src,k->new ArrayList<>()).add(dest);
       ADL.computeIfAbsent(dest,k->new ArrayList<>()).add(src);
   }
   public void getAdjVertices(int vertex){
       System.out.println(vertex+"->");
       System.out.println(ADL.getOrDefault(vertex, new ArrayList<>()));
   }
   public void print(){
       for(Map.Entry<Integer,List<Integer>> entry:ADL.entrySet()){
           int key = entry.getKey();
           List<Integer> values = entry.getValue();
           System.out.println(key+"->"+values);
           for(int value: values){
               System.out.println(value+" ");
           }
           System.out.println();
       }
   }
   public static void main(String[] args){
       Graphs graph = new Graphs();
       graph.addEdge(0,1);
       graph.addEdge(0,2);
       graph.addEdge(1,2);
       graph.addEdge(2,0);
       graph.addEdge(2,3);
       graph.addEdge(3,3);
       graph.print();
       graph.getAdjVertices(2);
   }
}*/
public class Graphs{
    //directed graphs
    private final int V;
    private final Map<Integer,List<Integer>> ADL;
    public Graphs(int vertices){
        V = vertices;
        ADL = new HashMap<>();
        for(int i=0; i<V; i++){
            ADL.put(i,new ArrayList<>());
        }
    }
    public void addEdge(int src,int dest){
        ADL.get(src).add(dest);
    }
    public void getAdjVertices(int vertex){
        System.out.println(ADL.getOrDefault(vertex,new ArrayList<>()));
    }
    public void print(){
        for(Map.Entry<Integer,List<Integer>> entry:ADL.entrySet()){
            int key = entry.getKey();
            List<Integer> values = entry.getValue();
            System.out.println(key+"->"+values);
            for(int value: values){
                System.out.println(value+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Graphs graph = new Graphs(4);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);
        graph.print();
        graph.getAdjVertices(3);
    }
}
