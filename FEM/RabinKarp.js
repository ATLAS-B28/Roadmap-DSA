/**
 * @param {string} str
 * @returns {number}
 */

function hash(str) {
    let hashValue = 0;
    for (let i = 0; i < str.length; i++) {
        hashValue += str.charCodeAt(i);
    }

    return hashValue;
}

/**
 * @param {string} str
 * @param {string} text
 * @returns {Array}
 */

function RKA(pattern, text) {
    const patternLength = pattern.length;
    const textLength = text.length;
    const indices = [];
     // Calculate the hash value of the pattern and the first window of the text
    const patternHash = hash(pattern);
    let windowHash = hash(text.substring(0, patternLength));

    //Slide the window through the text
    for (let i = 0; i <= textLength - patternLength; i++) {
        //check if the hash value matches and then compare the actual strings
        if (patternHash === windowHash && pattern === text.substring(i, i + patternLength)) {
            indices.push(i);
        }

        //recalculate the hash value for the next window
        windowHash = hash(text.substring(i + 1, i + patternLength + 1));
    }

    return indices;
}