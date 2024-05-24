class XHeap {
    constructor() {
        /**
         * @type {Array<number>}
         */
        this.heap = []
    }
    /**
     * inserts a value into the heap
     * @param {number} value
     */
    insert(value) {
        this.heap.push(value)
        this.heap.sort((a,b) => b - a)
    }
    /**
     * remove and returns the max value
     * @returns {number|null}
     */
    popMax() {
        if(this.heap.length === 0) {
            return null
        }
        return this.heap.shift()
    }
}

const xHeap = new XHeap()
xHeap.insert(5)
xHeap.insert(3)
xHeap.insert(69)
xHeap.insert(420)
xHeap.insert(4)
xHeap.insert(1)

console.log(xHeap.heap);

console.log(xHeap.popMax())
console.log(xHeap.popMax())
