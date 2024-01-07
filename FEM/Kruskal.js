/**
 * @typedef {Object} Edge
 * @property {string} source
 * @property {string} destination
 * @property {number} weight
 */

/**
 * @class DisjointSet
 */
class DisjointSet {
    /**
     * @constructor
     */
    constructor() {
        this.parent = new Map();
        this.rank = new Map();
    }
    /**
     * @param {string} vertex
     */
    makeSet(vertex) {
        this.parent.set(vertex, vertex);
        this.rank.set(vertex, 0);
    }
    /**
     * @param {string} vertex
     * @returns {string}
     */
    find(vertex) {
        if(this.parent.get(vertex) !== vertex) {
            this.parent.set(vertex, this.find(this.parent.get(vertex)));
        }
        return this.parent.get(vertex);
    }
    /**
     * @param {string} vx1
     * @param {string} vx2
     */
    union(vx1, vx2) {
        const root1 = this.find(vx1);
        const root2 = this.find(vx2);

        if (root1 !== root2) {
            if (this.rank.get(root1) < this.rank.get(root2)) {
                this.parent.set(root1, root2);
            } else if (this.rank.get(root1) > this.rank.get(root2)) {
                this.parent.set(root2, root1);
            } else {
                this.parent.set(root2, root1);
                this.rank.set(root1, this.rank.get(root1) + 1) ;
            }
        }
    }
}

/**
 * @param {string[]} vertices
 * @param {Edge[]} edges
 * @returns {Edge[]} 
 */

function kruskal(vertices, edges) {
    const sortedEdges = edges.sort((a,b) => a.weight - b.weight);
    const disjointSet = new DisjointSet();
    const mst = [];

    vertices.forEach(vertex => {
        disjointSet.makeSet(vertex);
    });

    sortedEdges.forEach(edge => {
        if(disjointSet.find(edge.source) !== disjointSet.find(edge.destination)) {
            disjointSet.union(edge.source, edge.destination);
            mst.push(edge);
            console.log(edge);
        }
    })
}

const vertices = ['A', 'B', 'C', 'D'];
const edges = [
    {source: 'A', destination: 'B', weight: 2},
    {source: 'A', destination: 'C', weight: 3},
    {source: 'B', destination: 'C', weight: 1},
    {source: 'B', destination: 'D', weight: 5},
    {source: 'C', destination: 'D', weight: 4}

];
console.log("MST with Kruskal's Algorithm: ");
kruskal(vertices, edges);