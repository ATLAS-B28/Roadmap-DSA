package Graph;

import java.util.*;

public class Graphs{
    //undirected graph
    int noOfNode;
    private final Map<Integer,List<Integer>> ADL;
    public Graphs(){
        ADL = new LinkedHashMap<>();
        noOfNode=0;
    }
    public void addVertexAndEdge(int source,int destination){
        ADL.computeIfAbsent(source,k->new ArrayList<>());
        //takes the key if no mapping for it exists
        //it computes it by taking the mapping function
        ADL.computeIfAbsent(destination,k->new ArrayList<>());
        ADL.get(source).add(destination);
        ADL.get(destination).add(source);
        noOfNode+=2;
    }
    public void showConnections(){
        Object[] keys = ADL.keySet().toArray();
        /*
        * Returns a Set view of the keys contained in this map.
        * The set is backed by the map, so changes to the map are
        * reflected in the set, and vice-versa.
         * */
        for(Object key : keys){
            System.out.println(key + "--->" + ADL.get(Integer.parseInt(key.toString())));
        }
    }
    public static void main(String[] args){
        Graphs g = new Graphs();
       g.addVertexAndEdge(1,2);
       g.addVertexAndEdge(1,3);
       g.addVertexAndEdge(1,4);
       g.addVertexAndEdge(2,5);
       g.addVertexAndEdge(2,6);
       g.addVertexAndEdge(2,1);
        g.showConnections();
    }
}