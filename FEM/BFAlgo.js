/**
 * @param {number} source
 * @param {Array} edges
 * @returns {Array}
 */

function bellmanFordAlgo(source, edges){
    const numNodes = Math.max(...edges.map((edge)=>Math.max(edge.source, edge.target))) + 1;
    const distance = new Array(numNodes).fill(Infinity);
    distance[source] = 0;

    for(let i = 0; i < numNodes - 1; i++) {
        for(const edge of edges) {
            const {source, target, wt}  = edge;
            if(distance[source] !== Infinity && distance[source] + wt < distance[target]) {
                distance[target] = distance[source] + wt;
            }
        }
    }

    for(const edge of edges) {
        const {source, target, wt} = edge;
        if(distance[source] !== Infinity && distance[source] + wt < distance[target]) {
            throw new Error("Graph contains negative edge cycle");
        }
    }

    return distance;
}

const edges = [
    {source: 0, target: 1, wt: 6},
    {source: 0, target: 2, wt: 7},
    {source: 0, target: 3, wt: 5},
    {source: 1, target: 2, wt: -4},
    {source: 2, target: 3, wt: -2},
    {source: 3, target: 4, wt: -1},
    {source: 2, target: 4, wt: -2},
    {source: 1, target: 4, wt: 2},
]

const sourceNode = 0;
const distances = bellmanFordAlgo(sourceNode, edges);

console.log(distances);