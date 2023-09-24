package Graph;
import java.util.Scanner;

public class BellmanFord{
    private final int[] distances;
    private final int NoOfVertices;
    public static final int MAX_VALUE = Integer.MAX_VALUE;
    public BellmanFord(int NoOfVertices){
        this.NoOfVertices = NoOfVertices;
        distances = new int[NoOfVertices + 1];
    }
    public void BellmanFordEvaluation(int source, int[][] ADM){
        for(int node = 1; node <= NoOfVertices; node++){
            distances[node] = MAX_VALUE;
        }
        distances[source] = 0;
        for(int node = 1; node <= NoOfVertices - 1; node++){
            for(int srcNode = 1; srcNode <= NoOfVertices; srcNode++){
                for(int destNode = 1; destNode <= NoOfVertices; destNode++){
                    if(ADM[srcNode][destNode] != MAX_VALUE){
                        if(distances[destNode] > distances[srcNode] + ADM[srcNode][destNode])
                            distances[destNode] = distances[srcNode] + ADM[srcNode][destNode];
                    }
                }
            }
        }
        for(int srcNode = 1; srcNode <= NoOfVertices; srcNode++){
            for (int destNode = 1; destNode <= NoOfVertices; destNode++){
                if (ADM[srcNode][destNode] != MAX_VALUE){
                    if (distances[destNode] > distances[srcNode]
                            + ADM[srcNode][destNode])
                        System.out.println("The Graph contains negative edge cycle");
                }
            }
        }
        for(int vertex = 1; vertex <= NoOfVertices; vertex++){
            System.out.println("distance of source  " + source + " to " + vertex + " is " + distances[vertex]);
        }
    }

    public static void main(String... arg){
        int NoOfVertices = 0;
        int source;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices");
        NoOfVertices = scanner.nextInt();
        int[][] ADM = new int[NoOfVertices + 1][NoOfVertices + 1];
        System.out.println("Enter the adjacency matrix");
        for(int srcNode = 1; srcNode <= NoOfVertices; srcNode++){
            for(int destNode = 1; destNode <= NoOfVertices; destNode++){
                ADM[srcNode][destNode] = scanner.nextInt();
                if(srcNode == destNode){
                    ADM[srcNode][destNode] = 0;
                    continue;
                }
                if(ADM[srcNode][destNode] == 0){
                    ADM[srcNode][destNode] = MAX_VALUE;
                }
            }
        }
        System.out.println("Enter the source vertex");
        source = scanner.nextInt();
        BellmanFord bellmanford = new BellmanFord(NoOfVertices);
        bellmanford.BellmanFordEvaluation(source, ADM);
        scanner.close();
    }
}