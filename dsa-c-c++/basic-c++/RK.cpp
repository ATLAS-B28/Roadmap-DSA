#include <iostream>
#include <string>

using namespace std;

const int prime = 101;

int searchRK(string text, string pattern) {
    int n  = text.length();
    int m = pattern.length();

    int patternHash = 0;
    int textHash = 0;
    int power = 1;

    //calculate the hash value of the pattern and
    //the initial hash value of the text
    for(int i = 0; i <= n - m; i++) {
        if(i == 0) {//start of the matching
            for(int j = 0; j < m; j++) {
                patternHash = (
                    patternHash + pattern[m - 1 - j] * power
                ) % prime;

                textHash = (
                    textHash + text[m - 1 - j] * power
                ) % prime;

                if(j < m - 1) {
                    power = (power * 2) % prime;
                    /**
                     * By using powers of 2, we can avoid recalculating
                     * the exponentiation of 2 for each character in the pattern.
                    */
                }
            }
        } else {//not the start so do the rolling
            textHash = (2 * /*makes room for the next character**/
                         (textHash - 
                          text[i - 1] * power /**this is the old character*/
                         ) + text[m + i - 1] /**this is the new character*/
                        ) % prime;
        }

        //if the hash values match, compare character by character
        if (patternHash == textHash) {
            bool found = true;
            for(int j = 0; j < m; j++) {
                if(text[i + j] != pattern[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }

    }

        return -1;//pattern not found
}

int main() {
    string text, pattern;
    cout << "Enter text: ";
    getline(cin, text);
    cout << "Enter pattern: ";
    getline(cin, pattern);

    int index = searchRK(text, pattern);

    if(index != -1) {
        cout << "Pattern found at index: " << index << endl;
    } else {
        cout << "Pattern not found" << endl;
    }
    return 0;
}