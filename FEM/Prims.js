/**
 * @typedef {Object} Edge
 * @property {string} source
 * @property {string} destination
 * @property {number} weight
 */

/**
 * @param {string[]} vertieces
 * @param {Edge[]} edges
 * @returns {Edge[]}
 */

function prim(vertices, edges) {
    const visited = new Set();
    const mst = [];
    const adjacencyList = new Map();

    vertices.forEach(vertex => {
        adjacencyList.set(vertex, []);
    });

    edges.forEach(edge => {
        adjacencyList.get(edge.source).push(edge);
        adjacencyList.get(edge.destination).push(edge);
    });

    const startVertex = vertices[0];
    visited.add(startVertex);

    while(visited.size < vertices.length) {
        let minEdge = null;
        let minWight = Infinity;

        visited.forEach(visitedVertex => {
            adjacencyList.get(visitedVertex).forEach(edge => {
                const unvisitedVertex = edge.source === visitedVertex ?
                                        edge.destination : edge.source;
                if(!visited.has(unvisitedVertex) && edge.weight < minWight) {
                    minEdge = edge;
                    minWight =edge.weight;
                }
            });
        });

        if(minEdge !== null) {
            mst.push(minEdge);
            visited.add(minEdge.source);
            visited.add(minEdge.destination);
        }
    }
    mst.forEach(edge => {
        console.log(`${edge.source} -- ${edge.destination} : ${edge.weight}`);
    });

    return mst;
}

const vertices = ['A', 'B', 'C', 'D'];
const edges = [
    {source: 'A', destination: 'B', weight: 2},
    {source: 'A', destination: 'C', weight: 3},
    {source: 'B', destination: 'C', weight: 1},
    {source: 'B', destination: 'D', weight: 4},
    {source: 'C', destination: 'D', weight: 2},
    {source: 'A', destination: 'D', weight: 5},
];

console.log(prim(vertices, edges));