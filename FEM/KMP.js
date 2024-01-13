/**
 * @param {string} pattern
 * @returns {number[]} 
 */

function calculateLPS(patttern) {
    const lps = [0];
    let len = 0;
    let i = 1;

    while(i < patttern.length) {
        if(patttern[i] === patttern[len]) {
            len++;
            lps[i] = len;
            i++;
        } else {
            if(len !== 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
    }
    return lps;
}

/**
 * @param {string} text
 * @param {string} pattern
 * @returns {number[]}
 */

function KMPSearch(text, pattern) {
    const indces = [];
    const lps = calculateLPS(pattern);
    let i = 0;
    let j = 0;

    while(i < text.length) {
        if(pattern[j] === text[i]) {
            i++;
            j++;
        }

        if(j === pattern.length) {
            indces.push(i - j);
            j = lps[j - 1];
        } else if (i < text.length && pattern[j] !== text[i]) {
            if(j !== 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
    }
    return indces;
}

const text  = "ABCABCDABABCDABCDABDE";
const pattern = "ABCDABD";
const indces = KMPSearch(text, pattern);
console.log(`Pattern found at indices: ${indces}`);