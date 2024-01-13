#include <iostream>
#include <vector>
#include <queue>

using namespace std;

typedef pair<int, int> pii;

class Graph {
    public:
       int V;
       vector<vector<pii>> adj;
       
       Graph(int v) {
        V = v;
        adj.resize(V); // Adjacency list, resize
       }

       void addEdge(int u, int v, int wt) {
        adj[u].push_back(make_pair(v, wt));
        adj[v].push_back(make_pair(u, wt));
       }

       vector<pii> PMST() {
        priority_queue<pii, vector<pii>, greater<pii>> pq;
        vector<int> key(V, INT_MAX);
        vector<int> parent(V, -1);
        vector<bool> inMST(V, false); 

        int src = 0;

        pq.push(make_pair(0, src));
        key[src] = 0;

        while(!pq.empty()) {
            int u = pq.top().second;
            pq.pop();

            inMST[u] = true;

            for(const auto& neighbour : adj[u]) {
                int v = neighbour.first;
                int wt = neighbour.second;

                if(!inMST[v] && wt < key[v]) {//wt is less than the current 
                                              // key value of vertex v
                    key[v] = wt;//vertex v is updated to wt
                    pq.push(make_pair(key[v], v));//updated pair into the priority queue
                                                  //for the next iteration if it stafies the condition
                    parent[v] = u;//parent of vertex v is u
                }
            }
        }
        vector<pii> mst;

        for(int i = 1; i < V ; i++) {
            mst.push_back(make_pair(parent[i], i));
        }

        return mst;
       }

       
};

int main() {
    int V = 4;
    Graph graph(V);

    graph.addEdge(0, 1, 10);
    graph.addEdge(0, 2, 6);
    graph.addEdge(0, 3, 5);
    graph.addEdge(1, 3, 15);
    graph.addEdge(2, 3, 4);

    vector<pii> mst = graph.PMST();

    cout << "Following are the edges in the constructed MST" << endl;
    for(const auto& edge: mst) {
        cout << edge.first << " --- " << edge.second << endl;
    }
}