package Graph;
import java.util.*;
public class Directed {
    private final Map<Integer,List<Integer>> ADL;
    public Directed(){
        ADL = new HashMap<>();
    }
    private boolean vertexExists(int vertex){
        return !ADL.containsKey(vertex);
    }
    private boolean edgeExists(int src,int dest){
        List<Integer> edges = ADL.get(src);
        return edges != null && edges.contains(dest);
    }
    private void addEdge(int src,int dest){
        List<Integer> edges = ADL.get(src);
        if(!edges.contains(dest)){
            edges.add(dest);
        }
    }
    public void addEdgeAndVertex(int src, int dest){
        if(vertexExists(src)){
            ADL.put(src,new ArrayList<>());
        }
        if(vertexExists(dest)){
            ADL.put(dest,new ArrayList<>());
        }
        if(!edgeExists(src,dest)){
            addEdge(src,dest);
        }
        //k-> new ArrayList<>() == ArrayList::new

    }
    public void showConnections(){
        for(Map.Entry<Integer,List<Integer>> entry : ADL.entrySet()){
            int vertex = entry.getKey();
            List<Integer> edges = entry.getValue();
            System.out.println(vertex+"--->"+Arrays.toString(edges.toArray()));
            System.out.println();
        }
    }
    public static void main(String[] args){
        Directed g = new Directed();
        g.addEdgeAndVertex(1,2);
        g.addEdgeAndVertex(1,2);
        g.addEdgeAndVertex(1,3);
        g.addEdgeAndVertex(1,4);
        g.addEdgeAndVertex(2,5);
        g.addEdgeAndVertex(2,6);
        g.addEdgeAndVertex(2,1);
        g.addEdgeAndVertex(3,7);
        g.showConnections();
    }
}
