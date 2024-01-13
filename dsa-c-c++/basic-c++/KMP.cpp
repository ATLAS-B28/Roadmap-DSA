#include <iostream>
#include <vector>

using namespace std;

vector<int> computeLPS(string pattern) {
    //preprocessed Longest Proper Prefix which is also a Suffix 
    //(LPS) array to optimize the search process
    int m = pattern.length();
    vector<int> lps(m,0);

    int len = 0;
    int i =  1;

    while(i < m) {
        if(pattern[i] == pattern[len]) {
            len++;//increment the length
            lps[i] = len;//update the LPS value
            i++;//move on to the next character
        } else {
            if(len != 0) {
                len  = lps[len-1];//assign the previous LPS value that matches to i - 1
            } else {
                lps[i] = 0;//set the LPS value to 0
                i++;//move on to the next character
            }
        }
    }
    return lps;
}

vector<int> searchKMP(string text, string pattern) {
    int n = text.length();
    int m = pattern.length();
    vector<int> lps = computeLPS(pattern);
    vector<int> matches;

    int i = 0;
    int j = 0;

    while(i < n) {
        if(pattern[j] == text[i]) {
            i++;
            j++;
        }

        if(j == m) {
            matches.push_back(i - j);//i - j is where the match starts in the text
            j = lps[j - 1];
            // This length is then used to determine the next index to
            // compare in the pattern,
        } else if(i < n && pattern[j] != text[i]) {
            //if the pattern doesn't match
            if(j != 0) {
                j = lps[j - 1];//heps skip unecessary comparisons
            } else {
                i++;
            }
        }
    }
    return matches;
}

int main() {
    string text = "ABCDABDCDABD";
    string pattern = "ABD";
    vector<int> matches = searchKMP(text, pattern);

    if(matches.empty()) {
        cout << "Pattern not found" << endl;
    } else {
        cout << "Pattern found at positions: " << endl;
        for(int  i = 0; i < matches.size(); i++) {
            cout << "Occurance at: " << matches[i] << "\n";
        }
    }
    return 0;
}
