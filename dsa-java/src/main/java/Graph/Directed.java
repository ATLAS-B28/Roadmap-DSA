package Graph;
import java.util.*;
public class Directed {
    private final Map<Integer,List<Integer>> ADL;
    public Directed(){
        ADL = new HashMap<>();
    }
    public void addEdgeAndVertex(int src, int dest){
        ADL.computeIfAbsent(src,k->new ArrayList<>()).add(dest);
        //k-> new ArrayList<>() == ArrayList::new
        ADL.computeIfAbsent(dest,ArrayList::new);
    }
    public void showConnections(){
        for(Map.Entry<Integer,List<Integer>> entry : ADL.entrySet()){
            int vertex = entry.getKey();
            List<Integer> edges = entry.getValue();
            System.out.println(vertex+"->"+Arrays.toString(edges.toArray()));
            System.out.println();
        }
    }
    public static void main(String[] args){
        Directed g = new Directed();
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
