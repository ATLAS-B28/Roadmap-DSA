#include <iostream>
#include <vector>
#include <queue>
#include <limits>

#define INF std::numeric_limits<int>::max()

struct Node{
    int vertex;
    int distance;
};

struct CompareQueueForPriority{
    bool operator()(const Node& n1,const Node& n2){
        return n1.distance > n2.distance;
    }
};

void dijkstra(std::vector<std::vector<std::pair<int,int>>>& graph,int source){
    int numVertices = graph.size();
    std::vector<int> distances(numVertices,INF);
    std::vector<bool> visited(numVertices,false);
    std::priority_queue<Node,std::vector<Node>, CompareQueueForPriority> pq;

    distances[source] = 0;
    pq.push({source,0});

    while(!pq.empty()){
        int u = pq.top().vertex;
        pq.pop();

        if(visited[u]){
            continue;
        }

        visited[u] = true;

        for(const auto& neighbour: graph[u]){
            int v = neighbour.first;
            int wt = neighbour.second;

            if(distances[u] != INF && distances[u] + wt < distances[v]){
                distances[v] = distances[u] + wt;
                pq.push({v,distances[v]});
            }
        }
    }
    std::cout << "Shortest Distances from source" << source << ":\n";
    for(int i = 0; i < numVertices; i++) {
        if(distances[i] == INF) {
            std::cout << i << ": Infinity\n";
        } else {
            std::cout << i << ": " << distances[i] << "\n";
        }
    }
}

int main(){
    int numVertices = 5;
    std::vector<std::vector<std::pair<int,int>>> graph(numVertices);

    graph[0].push_back({1, 9});
    graph[0].push_back({2, 3});
    graph[1].push_back({3, 2});
    graph[2].push_back({1, 1});
    graph[2].push_back({3, 4});
    graph[2].push_back({4, 2});
    graph[3].push_back({4, 6});

    int source = 0;

    dijkstra(graph,source);

    return 0;
}