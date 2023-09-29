package Graph;
import java.util.*;
/*
* To find a Hamiltonian path in a graph using Java,
* you can use various algorithms such as backtracking,
* dynamic programming, or graph traversal algorithms
* like Depth-First Search (DFS).
 * */
//backtracking
class HamiltonianPath {
    private int[][] graph;
    private int numVertices;
    private boolean[] visited;
    private List<Integer> path;
    public List<Integer> FHP(int[][] ADM){//find hamiltonian path
        graph = ADM;
        numVertices = graph.length;
        visited = new boolean[numVertices];
        path = new ArrayList<>();
        visited[0] = true;
        path.add(0);
        if(HPU(0,1)){
            return path;
        }else{
            return Collections.emptyList();
        }
    }
    private boolean HPU(int vertex,int count){//utility function
        if(count == numVertices){
            return graph[vertex][0] == 1;
        }
        for(int next = 0; next < numVertices; next++){
            if(isSafe(vertex,next)){
                visited[next] = true;
                path.add(next);
                if(HPU(next,count+1)){
                    return true;
                }
                visited[next] = false;
                path.remove(path.size()-1);
            }
        }
        return false;
    }
    private boolean isSafe(int current,int next){
        return graph[current][next] == 1 && !visited[next];
    }
}
public class Hamiltonian {
    public static void main(String[] args) {
        int[][] ADM = {
                {0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0}
        };
        HamiltonianPath hp = new HamiltonianPath();
        List<Integer> path = hp.FHP(ADM);
        if(path.isEmpty()){
            System.out.println("No Hamiltonian Path");
        }else{
            System.out.println("Hamiltonian path: "+path);
        }
    }
}
