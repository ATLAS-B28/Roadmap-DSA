#include <iostream>
#include <vector>

using namespace std;

void printPath(const vector<int>& path) {
    for(int vertex : path) {
        cout << vertex << " ";
    }
    cout << endl;
}

void hamiltionPathUtil(vector<vector<int>>& graph , 
                       vector<bool>& visisted,
                        vector<int>& path, 
                        int currVertex,
                        int numVertices) {
               visisted[currVertex] = true;
               path.push_back(currVertex);

               if(path.size() == numVertices) {
                printPath(path);
               } else {
                for(int nextVertex = 0; nextVertex < numVertices; nextVertex++) {
                    if(!visisted[nextVertex] && graph[currVertex][nextVertex] == 1) {
                        hamiltionPathUtil(graph, visisted, path, nextVertex, numVertices);
                    }
                }
               }

               visisted[currVertex] = false;
               path.pop_back();
}

void hamiltionPath(vector<vector<int>>& graph) {
    int numVertices = graph.size();

    vector<bool> visited(numVertices, false);
    vector<int> path;

    for(int startVertex = 0; startVertex < numVertices; startVertex++) {
        hamiltionPathUtil(graph, visited, path, startVertex, numVertices);
    }
}

int main() {
    int numVertices;
    cout << "Enter the number of vertices: ";
    cin >> numVertices;

    vector<vector<int>> graph(numVertices, vector<int>(numVertices, 0));

    cout << "Enter the adjacency matrix: ";
    for(int i = 0; i < numVertices; i++) {
        
        for(int j = 0; j < numVertices; j++) {
            cin >> graph[i][j];
        }

    }

    cout << "Hamiltonian Path: ";
    hamiltionPath(graph);

    return 0;
}