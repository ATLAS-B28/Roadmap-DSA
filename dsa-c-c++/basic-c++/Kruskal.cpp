#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Edge {
    public:
       int src, dest, weight;
};

class Graph {
    public:
       int V, E;
       vector<Edge> edges;

       Graph(int v, int e) {
        V = v;
        E = e;
       }

       void addEdge(int src, int dest, int weight) {
        Edge edge;
        edge.src = src;
        edge.dest = dest;
        edge.weight = weight;
        edges.push_back(edge);
       }

       static bool compareEdge(Edge a, Edge b) {
        return a.weight < b.weight;
       }

       vector<Edge> KMST() {
        vector<Edge> result;

        sort(edges.begin(), edges.end(), compareEdge);

        vector<int> parent(V, -1);
        vector<int> rank(V, 0);

        int i = 0;

        while(result.size() < V - 1) {

            Edge nextEdge = edges[i++];

            int srcParent = find(parent, nextEdge.src);
            int destParent = find(parent, nextEdge.dest);

            if(srcParent != destParent) {

                result.push_back(nextEdge);
                Union(parent, rank, srcParent, destParent);
                
            }
        }

        return result;
       }

       int find(vector<int>& parent, int i) {
        if(parent[i] == -1) {
            return i;
        }
        return find(parent, parent[i]);
       }

       void Union(vector<int>& parent, vector<int>& rank, int x, int y) {
        
         int xroot = find(parent, x);
         int yroot = find(parent, y);

         if(rank[xroot] < rank[yroot]) {

            parent[xroot] = yroot;

         } else if(rank[xroot] > rank[yroot]) {

            parent[yroot] = xroot;

         } else {

            parent[yroot] = xroot;
            rank[xroot]++;

         }
       }
};

int main() {
    int V = 4;
    int E = 5;
    Graph graph(V, E);

    graph.addEdge(0, 1, 10);
    graph.addEdge(0, 2, 6);
    graph.addEdge(0, 3, 5);
    graph.addEdge(1, 3, 15);
    graph.addEdge(2, 3, 4);

    vector<Edge> result = graph.KMST();

    cout << "Following are the edges in the constructed MST" << endl;
    for(const auto& edge : result) {
         cout << edge.src << " --- " << edge.dest << " : " << edge.weight << endl;
    }

    return 0;
}